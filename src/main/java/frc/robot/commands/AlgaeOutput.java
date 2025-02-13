// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.Robot;
import frc.robot.subsystems.Algae;
import edu.wpi.first.wpilibj.Timer;

/* You should consider using the more terse Command factories API instead https://docs.wpilib.org/en/stable/docs/software/commandbased/organizing-command-based.html#defining-commands */
public class AlgaeOutput extends Command {
  private boolean isRaised;
  private double speed;
  private Timer timer;
  private double outputTime;
  private final Algae algae;
  
  /** Creates a new AlgaeIntake. */
  public AlgaeOutput(Algae algae) {
    this.algae = algae;
    addRequirements(this.algae);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    isRaised = AlgaeHinge.getIsRaised();
    //random outputTime + motor speed values for now 
    if (isRaised){
      //reef output
      speed = 1;
      outputTime = 2.0;
    } else {
      //ground output 
      speed = -1;
      outputTime = 5.0;
    }

    timer = new Timer();
    timer.start(); 
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    Robot.algae.setInnerOuterSpeed(speed);
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    Robot.algae.setInnerOuterSpeed(0);
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return timer.get() >= outputTime;
  }
}
