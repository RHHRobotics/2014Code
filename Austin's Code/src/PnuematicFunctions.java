
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
public class PnuematicFunctions {
    static Compressor compressor;
    static DoubleSolenoid doubleSol1;
    static DoubleSolenoid doubleSol2;
    
    public PnuematicFunctions(Compressor c, DoubleSolenoid dS1, DoubleSolenoid dS2)
    {
        compressor = c;
        doubleSol1 = dS1;
        doubleSol2 = dS2;
        compressor.start();
    }
    
    /**
     * Sets the state off the shooters
     * @param b if True, turns them on, if False turns them to off, not backwards
     */
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
    
    public static void modulateShooterPistons(int modulationTime)
    {
        try 
        {
            doubleSol1.set(DoubleSolenoid.Value.kForward);
            doubleSol2.set(DoubleSolenoid.Value.kForward);
            
            Thread.sleep(modulationTime);
            
            doubleSol1.set(DoubleSolenoid.Value.kOff);
            doubleSol2.set(DoubleSolenoid.Value.kOff);
            
        } 
        
        catch (InterruptedException ex) 
        {
            System.out.println("ERROR WITH SHOOTER PISTON MODULATION! \nTURNING ON PISTONS WITHOUT MODULATION!");
            doubleSol1.set(DoubleSolenoid.Value.kForward);
            doubleSol2.set(DoubleSolenoid.Value.kForward);
        }
    }
    
}
