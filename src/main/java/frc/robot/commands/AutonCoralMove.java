// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.Robot;
import frc.robot.RobotMap;

public class AutonCoralMove extends Command {
  /** Creates a new TankDrive. */
  public AutonCoralMove() {
    // Use addRequirements() here to declare subsystem dependencies.
    addRequirements(Robot.coralHinge);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {}

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    Robot.coralHinge.moveHinge(-0.3);
    
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    Robot.coralHinge.moveHinge(RobotMap.CORAL_HOLD_SPEED);
  }
}

