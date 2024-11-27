package frc.robot.subsystems;

import javax.security.sasl.RealmCallback;

import com.revrobotics.CANSparkMax;
import com.revrobotics.RelativeEncoder;
import com.revrobotics.CANSparkLowLevel.MotorType;

import edu.wpi.first.math.geometry.Pose2d;
import edu.wpi.first.math.geometry.Rotation2d;
import edu.wpi.first.math.geometry.Translation2d;
import edu.wpi.first.math.kinematics.DifferentialDriveOdometry;
import edu.wpi.first.util.sendable.SendableBuilder;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.drive.MecanumDrive;
import edu.wpi.first.wpilibj.motorcontrol.Talon;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;



public class DriveSubsystem extends SubsystemBase {

    private static DriveSubsystem instance;

    private CANSparkMax motorControllerFrontRight;
    private CANSparkMax motorControllerFrontLeft;
    private CANSparkMax motorControllerBackRight;
    private CANSparkMax motorControllerBackLeft;

    private DifferentialDrive driveController;
    
    private RelativeEncoder encoderRight;
    private RelativeEncoder encoderLeft;

    private DifferentialDriveOdometry odometry;

    public DriveSubsystem () {
        initializeMotors();

        odometry = new DifferentialDriveOdometry(new Rotation2d(0), 0, 0);

        driveController = new DifferentialDrive(motorControllerFrontLeft, motorControllerFrontRight);
    } 

    public static DriveSubsystem getInstance() {
        if (instance == null) {
            System.out.println("drive init");
            instance = new DriveSubsystem();
        }
        return instance;
    }

    public void initializeMotors() {
        motorControllerFrontRight = new CANSparkMax(Constants.Drive.FRONT_RIGHT_ID, MotorType.kBrushless);
        motorControllerFrontLeft = new CANSparkMax(Constants.Drive.FRONT_LEFT_ID, MotorType.kBrushless);
        motorControllerBackRight = new CANSparkMax(Constants.Drive.BACK_RIGHT_ID, MotorType.kBrushless);
        motorControllerBackLeft = new CANSparkMax(Constants.Drive.BACK_LEFT_ID, MotorType.kBrushless);

        motorControllerBackLeft.restoreFactoryDefaults();
        motorControllerBackRight.restoreFactoryDefaults();
        motorControllerFrontLeft.restoreFactoryDefaults();
        motorControllerFrontRight.restoreFactoryDefaults();

        motorControllerBackLeft.follow(motorControllerFrontLeft);
        motorControllerBackRight.follow(motorControllerFrontRight);
        
        motorControllerFrontRight.setInverted(true);

        encoderLeft = motorControllerFrontLeft.getEncoder();
        encoderRight = motorControllerFrontRight.getEncoder();

        encoderRight.setPositionConversionFactor(Constants.Drive.DRIVE_MOTOR_ROTATION_M);
        encoderLeft.setPositionConversionFactor(Constants.Drive.DRIVE_MOTOR_ROTATION_M);

    }

    public void drive(double x, double y) {
        driveController.arcadeDrive(-x, y, true);
    }

    @Override
    public void initSendable(SendableBuilder builder) {
        builder.addDoubleProperty("Right Position in m", ()->{
            return encoderRight.getPosition();
        }, null);
        builder.addDoubleProperty("Left Position in m", ()->{
            return encoderLeft.getPosition();
        }, null);
        super.initSendable(builder);
    }
}
