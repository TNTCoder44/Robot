package frc.robot;

import javax.sql.rowset.JoinRowSet;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.InstantCommand;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import frc.robot.commands.pickup.PickupCommand;
import frc.robot.commands.pickup.PickupCommandGroup;
import frc.robot.commands.thrower.MotorBottomCommand;
import frc.robot.commands.thrower.ShooterCommandGroup;
import frc.robot.commands.thrower2.ThrowerCommandGroup;
import frc.robot.commands.tunnel.TunnelCommand;
import frc.robot.subsystems.Thrower2Subsystem;

public class Controller {
    private static Controller instance;
    
    private Joystick controller;
  
    private JoystickButton buttonShoot;
    // private JoystickButton buttonPickup;
    // private JoystickButton buttonTunnel;

    private Controller() {
        controller = new Joystick(0);
        
        buttonShoot = new JoystickButton(controller, 1);

        buttonShoot.onTrue(new ThrowerCommandGroup());
        
        // buttonPickup = new JoystickButton(controller, 2);
       
        // buttonShoot.onTrue(new ShooterCommandGroup());
        // buttonPickup.toggleOnTrue(new PickupCommandGroup());

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
