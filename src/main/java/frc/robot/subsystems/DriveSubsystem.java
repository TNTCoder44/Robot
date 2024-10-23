package frc.robot.subsystems;

import edu.wpi.first.util.sendable.SendableBuilder;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.drive.MecanumDrive;
import edu.wpi.first.wpilibj.motorcontrol.Talon;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;



public class DriveSubsystem extends SubsystemBase {

    private static DriveSubsystem instance;

    private Talon motorControllerFrontRight;
    private Talon motorControllerFrontLeft;
    private Talon motorControllerBackRight;
    private Talon motorControllerBackLeft;

    private MecanumDrive driveControler;

    public DriveSubsystem () {

        motorControllerFrontRight = new Talon(Constants.Drive.FRONT_RIGHT_ID);
        motorControllerFrontLeft = new Talon(Constants.Drive.FRONT_LEFT_ID);
        motorControllerBackRight = new Talon(Constants.Drive.BACK_RIGHT_ID);
        motorControllerBackLeft = new Talon(Constants.Drive.BACK_LEFT_ID);
    
        motorControllerFrontLeft.setInverted(true); // invert

        driveControler = new MecanumDrive(motorControllerFrontLeft, motorControllerBackLeft, motorControllerFrontRight, motorControllerBackRight);
    }    

    public static DriveSubsystem get_instance() {
        if (instance == null) {
            System.out.println("drive init");
            instance = new DriveSubsystem();
        }
        return instance;
    }

    public void drive_c(double x, double y, double z) {
        driveControler.driveCartesian(x, y, z);
    }

    @Override
    public void initSendable(SendableBuilder builder) {
        // TODO Auto-generated method stub
        builder.addStringProperty("Name", ()->"poasdpofij", null);
        super.initSendable(builder);
    }
}
