
import edu.wpi.first.wpilibj.AnalogChannel;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author austin
 */
public class DistanceSensor {
    static AnalogChannel distanceSensor;
    
    public DistanceSensor(int analogChannel)
    {
        distanceSensor = new AnalogChannel(analogChannel);
    }
    
    /**
     * May or may not work. Needs testing
     * @return the distance from the robot to the object infront of it
     */
    public static double getDistance()
    {
        //MAKE SURE FACING THE WALL!
        double toReturn = 0.0;
        int rawVal = distanceSensor.getValue();
        toReturn = (rawVal / 500.0) * 30; //Divide by 500 becaus that is the max value, then divide by 30 because 30 feet is the value of 500
        return toReturn;
    }
    
}
