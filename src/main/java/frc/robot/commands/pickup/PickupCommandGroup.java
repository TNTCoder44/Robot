package frc.robot.commands.pickup;

import edu.wpi.first.wpilibj2.command.InstantCommand;
import edu.wpi.first.wpilibj2.command.ParallelCommandGroup;
import edu.wpi.first.wpilibj2.command.WaitCommand;
import frc.robot.commands.tunnel.TunnelCommand;
import frc.robot.subsystems.PickupSubsystem;
import frc.robot.subsystems.TunnelSubsystem;

public class PickupCommandGroup extends ParallelCommandGroup {
    public PickupCommandGroup() {
        addCommands(
            new PickupCommand(),
            new TunnelCommand()
        );
    }
}
