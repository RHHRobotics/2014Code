
import edu.wpi.first.wpilibj.PWM;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author austin
 */
public class Encoder 
{
    static PWM encoder;
    
    public Encoder(int pWMPort)
    {
        encoder = new PWM(pWMPort);
    }
    
    public static int getEncoderAngleValue()
    {
        return encoder.getRaw();
    }
}
