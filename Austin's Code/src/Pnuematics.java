
import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.DoubleSolenoid;

/*
 * Created by Austin DeLauney
 * This is supposed to control all of the pnematic stuff (Don't know yet)
 */

/**
 *
 * @author Austin
 */
public class Pnuematics {
    static Compressor compressor;
    static DoubleSolenoid doubleSol1;
    static DoubleSolenoid doubleSol2;
    
    public Pnuematics(Compressor c, DoubleSolenoid dS1, DoubleSolenoid dS2)
    {
        compressor = c;
        doubleSol1 = dS1;
        doubleSol2 = dS2;
        compressor.start();
    }
    
    public static void launchBall(int encoderVal)
    {
        doubleSol1.set(DoubleSolenoid.Value.kForward); //Turn on the pistons
        doubleSol2.set(DoubleSolenoid.Value.kForward);
        
        while(encoderVal < Encoder.getEncoderAngleValue()) //While the angle hasn't been hit keep pistons expanding
        {
            System.out.println("Solenoids expanding");
        }
        
        doubleSol1.set(DoubleSolenoid.Value.kOff); //Once the angle has been hit bring the pistons back down via gravity
        doubleSol2.set(DoubleSolenoid.Value.kOff);
        
        compressor.start(); //Start the compressor again
    }
    
    public static void setShooterPistons(boolean b)
    {
        if(b)
        {
            doubleSol1.set(DoubleSolenoid.Value.kForward); //Turn on the pistons
            doubleSol2.set(DoubleSolenoid.Value.kForward);
        }
        
        else
        {
            doubleSol1.set(DoubleSolenoid.Value.kOff); //Turn off the pistons
            doubleSol2.set(DoubleSolenoid.Value.kOff);
        }
    }
    
}
