package frc.robot.commands.thrower2;

import edu.wpi.first.wpilibj2.command.InstantCommand;
import edu.wpi.first.wpilibj2.command.ParallelRaceGroup;
import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import edu.wpi.first.wpilibj2.command.WaitCommand;
import frc.robot.subsystems.Thrower2Subsystem;
import frc.robot.subsystems.ThrowerSubsystem;

public class ThrowerCommandGroup extends SequentialCommandGroup {
    public ThrowerCommandGroup() {
        addCommands(
                new InstantCommand(() -> System.out.println("Parallel")),
                new MotorTop2Command(0.3),

                new WaitCommand(0.3),
                new MotorLowerCommand(0.3),

                new WaitCommand(1),
                new MotorTop2Command(0),
                new MotorLowerCommand(0),
                new InstantCommand(() -> System.out.println("Stop Motors")));
    }
}
