/*
 * Made by Austin DeLauney
 * Made on 1/5/2014
 * Used for an image, stores info and all
 */

/**
 *
 * @author Austin
 */
public class Pixel 
{    
    private int red;
    private int green;
    private int blue;
    
    public Pixel()
    {
        red = 0;
        green = 0;
        blue = 0;
    }
    
    public Pixel(int r, int g, int b)
    {
        red = r;
        green = g;
        blue = b;
    }
    
    public int getRed()
    {
        return red;
    }
    
    public int getGreen()
    {
        return green;
    }
    
    public int getBlue()
    {
        return blue;
    }
    
    public void setRed(int r)
    {
        red = r;
    }
    
    public void setGreen(int g)
    {
        green = g;
    }
    
    public void setBlue(int b)
    {
        blue = b;
    }
    
    public void setPixel(int r, int g, int b)
    {
        red = r;
        green = g;
        blue = b;
    }
    
    public Color getShade()
    {
        return null;
    }
}
