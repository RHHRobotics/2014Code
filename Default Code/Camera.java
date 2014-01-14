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
    
    public Camera(String cam)
    {
        pixels = new Pixel[aCam.getResolution().height][aCam.getResolution().width];
    }
    
    /**
     * Take a photo, do something 
     */
    public void takePhoto() throws AxisCameraException, NIVisionException
    {
        cI = aCam.getImage();
    }
    
    /**
     * Analyze the photo, check each pixel color and tell where the robot to point
     */
    public void analyzePhoto()
    {
        for(Pixel[] pArray : pixels)
        {
            for(Pixel p : pArray)
            {
                p.
            }
        }
    }
}
