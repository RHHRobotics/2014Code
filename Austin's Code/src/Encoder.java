/**
 * Created by Austin DeLauney, 02/08/2014
 * Used to get the value of the encoder on the ball shooter axis thing
 */

import edu.wpi.first.wpilibj.PWM;

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
