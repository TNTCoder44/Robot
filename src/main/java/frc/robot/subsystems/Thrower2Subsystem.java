package frc.robot.subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkLowLevel.MotorType;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class Thrower2Subsystem extends SubsystemBase {
    private static Thrower2Subsystem instance;

    private CANSparkMax motorBottom;
    private CANSparkMax motorTopRight;
    private CANSparkMax motorTopLeft;

    private double m_speed_bottom = 0;
    private double m_speed_top = 0;

    public Thrower2Subsystem() {
        initializeMotors();
    }

    public static Thrower2Subsystem getInstance() {
        if (instance == null) {
            System.out.println("thrower init");
            instance = new Thrower2Subsystem();
        }
        return instance;
    }

    @Override
    public void periodic() {
        motorBottom.set(m_speed_bottom);
        motorTopLeft.set(m_speed_top);
    }

    public void initializeMotors() {
        motorBottom = new CANSparkMax(Constants.Thrower2.BOTTOM_ID, MotorType.kBrushless);
        motorTopRight = new CANSparkMax(Constants.Thrower2.TOP_RIGHT, MotorType.kBrushless);
        motorTopLeft = new CANSparkMax(Constants.Thrower2.TOP_LEFT, MotorType.kBrushless);

        motorBottom.restoreFactoryDefaults();
        motorTopLeft.restoreFactoryDefaults();
        motorTopRight.restoreFactoryDefaults();

        motorTopRight.follow(motorTopLeft, true);
        motorBottom.setInverted(true);
        motorTopLeft.setInverted(true);
    }

    public void startMotorBottom(double speed) {
        m_speed_bottom = speed;
    }

    public void startMotorTop(double speed) {
        m_speed_top = speed;
    }
}
