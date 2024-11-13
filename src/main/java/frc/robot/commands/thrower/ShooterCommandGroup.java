package frc.robot.commands.thrower;

import edu.wpi.first.wpilibj2.command.InstantCommand;
import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import edu.wpi.first.wpilibj2.command.WaitCommand;
import frc.robot.subsystems.ThrowerSubsystem;

public class ShooterCommandGroup extends SequentialCommandGroup {
    public ShooterCommandGroup() {
        addCommands(
            new MotorTopCommand(),
            new WaitCommand(1),
            new MotorBottomCommand(),
            new WaitCommand(1),
            new InstantCommand(() -> {
                // System.out.println("Stop Motors");
                ThrowerSubsystem.getInstance().startMotorBottom(0);
                ThrowerSubsystem.getInstance().startMotorTop(0);
            }));
    }
}
