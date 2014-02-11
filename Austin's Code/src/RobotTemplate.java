/*----------------------------------------------------------------------------*/
/* Copyright (c) FIRST 2008. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.Joystick;

/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the IterativeRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the manifest file in the resource
 * directory.
 */
public class RobotTemplate extends IterativeRobot {
    
    Camera camera;
    DriveTrain driveTrain;
    PnuematicFunctions pnuematics;
    BallShooter ballShooter;
    Encoder shooterEncoder;
    DistanceSensor ultraSonic;
    Joystick xboxController;
    
    /**
     * This function is run when the robot is first started up and should be
     * used for any initialization code.
     */
    public void robotInit() {
        driveTrain = new DriveTrain(0, 1, 2, 3);
        camera = new Camera();
        pnuematics = new PnuematicFunctions(new Compressor(), new DoubleSolenoid(), new DoubleSolenoid())
        ballShooter = new BallShooter();
        shooterEncoder = new Encoder(5);
        ultraSonic = new DistanceSensor(1);
        xboxController = new Joystick(3);
    }

    /**
     * This function is called periodically during autonomous
     */
    public void autonomousPeriodic() {
        Camera.findHotTarget();
        
    }

    /**
     * This function is called periodically during operator control
     */
    public void teleopPeriodic() {
        DriveTrain.rawArcadeDrive(xboxController);
    }
    
    /**
     * This function is called periodically during test mode
     */
    public void testPeriodic() {
        
    }
    
}
