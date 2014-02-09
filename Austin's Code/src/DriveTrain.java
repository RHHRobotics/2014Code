
import edu.wpi.first.wpilibj.RobotDrive;

/*
 * Made by Austin DeLauney on 1/5/2014
 * This class is supposed to initiate the drive stuff. I think
 */

public class DriveTrain 
{
    public static DriveTrain dT; //Used for singleton
    RobotDrive rDrive;
    /**
     * Input DriveTrain parameters
     */
    public DriveTrain(int motor1, int motor2, int motor3, int motor4)
    {
        rDrive = new RobotDrive(motor1, motor2, motor3, motor4);
    }
    
    /**
     * Move the robot forward
     */
    public void moveForward()
    {
        rDrive.arcadeDrive(0.5, 0.0); //Move forward at half speed, zero rotation
    }
    
    /**
     * Moves the robot forward or backward based on the inputted speed, no rotation
     * @param speed Positive = forward, Negative = backward, (1.0 - -1.0 values only)
     */
    public void moveForwardOrBackward(double speed)
    {
        rDrive.arcadeDrive(speed, 0.0); //Move forward at half speed, zero rotation
    }
    
    /**
     * Move the robot backwards
     */
    public void moveBackward()
    {
        rDrive.arcadeDrive(-0.5, 0.0); //Move backward at half speed, zero rotation
    }
    
    /**
     * Move the robot left
     * MECANUM WHEELS ONLY: NOT IMPLIMENTED
     */
    public void moveLeft()
    {
        //Use rDrive.mecanumDrive... methods and play around with them to see what works and what doesn't
    }
    
    /**
     * Move the robot right
     * MECANUM WHEELS ONLY: NOT IMPLIMENTED
     */
    public void moveRight()
    {
        //Use rDrive.mecanumDrive... methods and play around with them to see what works and what doesn't
    }
    
    /**
     * Pivot the robot left
     */
    public void pivotLeft()
    {
        rDrive.tankDrive(-0.5, 0.5); //Left turns backwards half speed, Right turns forward half speed, making robot move in the left direction
    }
    
    /**
     * Pivot the robot right
     */
    public void pivotRight()
    {
        rDrive.tankDrive(0.5, -0.5); //Right turns backwards half speed, Left turns forward half speed, making robot move in the right direction
    }
}
