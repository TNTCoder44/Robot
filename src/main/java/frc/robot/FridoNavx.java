package frc.robot;

import com.kauailabs.navx.frc.AHRS;

import edu.wpi.first.wpilibj.I2C.Port;

public class FridoNavx extends AHRS {
    private double offset = 0;

    public FridoNavx(Port port_id) {
        super(port_id);
        this.reset();
    }

    @Override
    public void reset()
    {   
        offset = 0;
        super.reset();
    }

    public void setOffset(double newOffset) {
        offset = newOffset;
    }

    @Override
    public double getAngle() {
        return super.getAngle() + offset;
    }

}
