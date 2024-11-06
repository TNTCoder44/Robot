package frc.robot.subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkLowLevel.MotorType;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class ThrowerSubsystem extends SubsystemBase {
    private static ThrowerSubsystem instance;
    
    private CANSparkMax motorBottom;
    private CANSparkMax motorTopRight;
    private CANSparkMax motorTopLeft;

    public ThrowerSubsystem () {
        initializeMotors();
    }

    public static ThrowerSubsystem getInstance() {
        if (instance == null) {
            System.out.println("thrower init");
            instance = new ThrowerSubsystem();
        }
        return instance;
    }

    public void initializeMotors() {
        motorBottom = new CANSparkMax(Constants.Thrower.BOTTOM_ID, MotorType.kBrushless);
        motorTopRight = new CANSparkMax(Constants.Thrower.TOP_RIGHT, MotorType.kBrushless);
        motorTopLeft = new CANSparkMax(Constants.Thrower.TOP_LEFT, MotorType.kBrushless);
        
        motorBottom.restoreFactoryDefaults();
        motorTopLeft.restoreFactoryDefaults();
        motorTopRight.restoreFactoryDefaults();

        motorTopRight.follow(motorTopLeft, true);
        motorBottom.setInverted(true);
    }

    public void startMotorBottom(double speed) {
        motorBottom.set(speed);
    }

    public void startMotorTop(double speed) {
        motorTopLeft.set(speed);
    }
}
