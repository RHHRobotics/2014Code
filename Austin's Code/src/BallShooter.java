/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author austin
 */
public class BallShooter {
    
    public static boolean canShoot()
    {
        if(Camera.isTargetVisible())
            return true;
        else
            return false;
    }
    
    public static void shoot(int encoderVal)
    {
        Pnuematics.setShooterPistons(true);
        
        while(encoderVal < Encoder.getEncoderAngleValue()) //While the angle hasn't been hit keep pistons expanding
        {
            System.out.println("Solenoids expanding");
        }
        
        Pnuematics.setShooterPistons(false);
    }
    
    /**
     * NOT IMPLIMENTED YET!
     * Finds the distance from robot to the goal
     * @return the hypotenuse of the robot to the goal (Derived from the known hight and the distance sensor)
     */
    public static double distance()
    {
        return 0.0;
    }
    
}
