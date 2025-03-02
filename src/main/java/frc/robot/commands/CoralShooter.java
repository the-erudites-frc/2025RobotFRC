// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.Coral;


public class CoralShooter extends Command {
    private final Coral coral;
    private final double speed = 0.3; //Speed at which the shooter operates
    private final double time = 5; //Duration (in seconds) before stopping the shooter 
    private Timer timer = new Timer(); //Tracks how long the shooter runs


  /** Creates a new coralshooter. */
  public CoralShooter(Coral coral) {
    this.coral = coral;
    addRequirements(this.coral);
    // Use addRequirements() here to declare subsystem dependencies.
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    coral.Shooter(speed);
    timer.start(); // Starts the timer to track shooter runtime
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {

    if (timer.get() > time) {
        timer.reset();
        coral.Shooter(0);
    }
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    coral.Shooter(0); // Ensure the shooter stops when the command ends
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
