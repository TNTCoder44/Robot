// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands.tunnel;

import frc.robot.Controller;
import frc.robot.subsystems.DriveSubsystem;
import frc.robot.subsystems.ThrowerSubsystem;
import frc.robot.subsystems.TunnelSubsystem;
import edu.wpi.first.wpilibj2.command.Command;

/** An example command that uses an example subsystem. */
public class TunnelCommand extends Command {
  @SuppressWarnings({"PMD.UnusedPrivateField", "PMD.SingularField"})
 
  /**
   * Creates a new DriveCommand.
   *
   * @param subsystem The subsystem used by this command.
   */
  public TunnelCommand() {
    addRequirements(TunnelSubsystem.getInstance());
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    TunnelSubsystem.getInstance().startMotor(0.5);
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {}

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    //ThrowerSubsystem.getInstance().startMotorBottom(0);
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return true;
  }
}
