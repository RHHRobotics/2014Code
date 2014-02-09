/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author austin
 */
public class BallShooter {
    
    /**
     * Does the ball have a chance of getting into the goal?
     * @return If the target is visible or not
     */
    public static boolean canShoot()
    {
        if(Camera.isTargetVisible())
            return true;
        else
            return false;
    }
    
    /**
     * Shoots the ball
     * @param encoderVal Determines the angle of how far the shooter is supposed to turn, effectivley determining power 
     */
    public static void shoot(int encoderVal)
    {
        PnuematicFunctions.setShooterPistons(true);
        
        while(encoderVal < Encoder.getEncoderAngleValue()) //While the angle hasn't been hit keep pistons expanding
        {
            System.out.println("Solenoids expanding");
        }
        
        PnuematicFunctions.setShooterPistons(false);
    }
    
    /**
     * NOT IMPLIMENTED YET!
     * Finds the distance from robot to the goal
     * @return the hypotenuse of the robot to the goal (Derived from the known hight and the distance sensor)
     */
    private static double distance()
    {
        return 0.0;
    }
    
}
