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
    
    public Camera()
    {
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
}
