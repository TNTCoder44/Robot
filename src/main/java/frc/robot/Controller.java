package frc.robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import frc.robot.commands.thrower.MotorBottomCommand;
import frc.robot.commands.thrower.ShooterCommandGroup;

public class Controller {
    private static Controller instance;
    
    private Joystick controller;

    private JoystickButton buttonShoot;

    public Controller() {
        controller = new Joystick(0);
        buttonShoot = new JoystickButton(controller, 1);

        buttonShoot.onTrue(new ShooterCommandGroup());
    } 
    
    public static Controller getInstance() {
        if (instance == null) {
            System.out.println("joysticks init");
            instance = new Controller();
        }
        return instance;
    }

    public Joystick getController() {
        return controller;
    }

}
