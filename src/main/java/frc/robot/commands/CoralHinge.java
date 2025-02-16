// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.Coral;


public class CoralHinge extends Command {
    private double speed = 0.3;
    private final Coral coral;
    private final double time = 2; // supposedly we will have a fixed time when toggling between both angles
    private Timer timer = new Timer();



  /** Creates a new coralhinge. */
  public CoralHinge(Coral coral) {
    this.coral = coral;
    addRequirements(this.coral); // Declare that this command requires the Coral subsystem
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    //Moves hinge at the specified speed
    coral.Hinge(speed);
    timer.start();

  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {

    if (timer.get() > time) {
        //If the hinge has moved for the specified time, stop it
        timer.reset();
        coral.Hinge(0);
        speed = -speed; // flip direction for next use
    }

    
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    coral.Hinge(0); //Double checks that the hinge has stopped
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
