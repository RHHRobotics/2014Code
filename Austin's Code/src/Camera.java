/*
 * Made by Austin DeLauney on 1/5/2014
 * This class is supposed to do the camera stuff
 */

 import edu.wpi.first.wpilibj.camera.*; 
 import edu.wpi.first.wpilibj.image.*;

public class Camera
{
    AxisCamera aCam;
    Pixel[][] pixels;
    ColorImage cI;
    CriteriaCollection cc;
    
    public Camera()
    {
        cc = new CriteriaCollection(); //Assigns the Criteria object
        cc.addCriteria(NIVision.MeasurementType.IMAQ_MT_BOUNDING_RECT_WIDTH, 0, 0, false); //Add a width criteria
        cc.addCriteria(NIVision.MeasurementType.IMAQ_MT_BOUNDING_RECT_HEIGHT, 0, 0, false); //Add a height criteria - change these
        
        pixels = new Pixel[aCam.getResolution().height][aCam.getResolution().width];
        
        for(int i = 0; i < pixels.length; i++)
        {
            for(int j = 0; j < pixels.length; j++)
            {
                pixels[i][j] = new Pixel();
            }
        }
    }
    
    /**
     * Take a photo, do something 
     */
    public void takePhoto()
    {
        try 
        {
            cI = aCam.getImage();
            analyzePhoto(); //Assuming everything is A-OK, analyze the photo
        } 
        
        catch (AxisCameraException ex) 
        {
            ex.printStackTrace();
        } 
        
        catch (NIVisionException ex) 
        {
            ex.printStackTrace();
        }
    }
    
    public void assignPixels()
    {
        for(int i = 0; i < pixels.length; i++)
        {
            for(int j = 0; j < pixels.length; j++)
            {
                pixels[i][j].setPixel(0, 0, 0); //Place values accordingly
            }
        }
    }
    
    /**
     * Analyze the photo, check each pixel color and tell where the robot to point
     */
    public void analyzePhoto()
    {
        //Assign the pixels first

    }
    
    /**
     * NOT IMPLIMENTED YET!
     * @return If we can see the target in vision
     */
    public static boolean isTargetVisible()
    {
        return false;
    }
    
    /**
     * NOT IMPLIMENTED YET!
     * Finds the hot target for auto
     */
    public static void findHotTarget()
    {
        
    }
    
    /**
     * Made by Sohum Thakkar on 02/10/2014
     * Finds the center of the circle
     */
     private Point[] getGoalCenterPoints() {
        ColorImage fullImage = null; //First pic
        BinaryImage thresholdImage = null; //with only red objects
        BinaryImage onlyBigObjects = null; //with only red, big objects
        BinaryImage convexHull = null; //with only red, big objects that are filled in
        BinaryImage filtered = null; //with only red, big objects that meet the height and width criteria
        
        try //attempt the following code; if unsuccessful, go to the catch
        { 
            fullImage = aCam.getImage(); //Take pic
            thresholdImage = fullImage.thresholdRGB(25, 255, 0, 40, 0, 40); //Filter out objects that are not red enough. PARAMETERS : (red min value, red max value, green min, green max, blue min, blue max)
            onlyBigObjects = thresholdImage.removeSmallObjects(false, 2); //Filter out small objects PARAMETERS ; (CONNECTIVITY8, how small the objects have to be to get filtered out)
            convexHull = onlyBigObjects.convexHull(false); //Fills in the remaining objects
            filtered = convexHull.particleFilter(cc); //Keep only objects that meet the criteria defined in robotInit
            
            ParticleAnalysisReport [] reports = filtered.getOrderedParticleAnalysisReports(); //analysis array made
            Point[] centerPoints = new Point[reports.length];
            
            for (int i = 0; i < reports.length + 1; i++) {
                centerPoints[i] = new Point(reports[i].center_mass_x, reports[i].center_mass_y);
            }//prints middle Y-value of remaining objects (should only be the goal)
            
           return centerPoints;
        }
        
        catch(Exception ex) //What to do when the try fails
        {
            System.out.println("ERROR WITH CAMERA! NO POINTS SELECTED! RETURNING NULL!");
            return null;
        }
        
        finally
        {
            //what to do after the catch throws the exception
        }
    }
}
