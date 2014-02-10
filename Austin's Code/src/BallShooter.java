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
     * NOT IMPLIMENTED!
     * @return Finds the best value to stop the shooter so it's at the correct angle
     * /
    private static int shootingAngle()
    {
        
    }
}
