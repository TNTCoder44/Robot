package frc.robot.subsystems;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class JoystickSubsystem extends SubsystemBase {
    private static JoystickSubsystem instance;
    
    private Joystick controller;

    public JoystickSubsystem () {
        controller = new Joystick(0);
    } 

    public static JoystickSubsystem get_instance() {
        if (instance == null) {
            System.out.println("joysticks init");
            instance = new JoystickSubsystem();
        }
        return instance;
    }

    public Joystick get_controller() {
        return controller;
    }

}
