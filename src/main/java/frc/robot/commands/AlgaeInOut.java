// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.Robot;
import frc.robot.subsystems.Algae;

/* You should consider using the more terse Command factories API instead https://docs.wpilib.org/en/stable/docs/software/commandbased/organizing-command-based.html#defining-commands */
public class AlgaeInOut extends Command {
  // boolean variable which will be used to tell the program if the algae frame is raised or not
  private boolean isRaised;
  private boolean isInput;
  private double speed;
  private Timer timer;
  private double time;
  private final Algae algae;

  /** Creates a new AlgaeIntake. */
  public AlgaeInOut(Algae algae, boolean isInput) {
    this.algae = algae;
    //find out if this is input/outputting through parameter passed by controller button
    this.isInput = isInput;
    addRequirements(this.algae);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    // determining if the frame is raised using the boolean variable isRaised from AlgaeHinge
    isRaised = AlgaeHinge.getIsRaised();
  
    if (isRaised){
      // if the frame is raised (vertical), the motors will push the ball from the top face to the bottom face of the frame.
      // since the ball is infront of the frame
      //if outputting, opposite speed
      speed = isInput ? -1 : 1; //if isRaised, speed = -1, else speed = 1
      time = 2.0;
    } else {
      // if the frame is flat (nearly horizontal), the motors will push the ball from the bottom face to the top face of the frame.
      // since the ball is beneath the frame to input
      // if outputting, opposite
      speed = isInput ? 1 : -1; //if isRaised, speed = 1, else speed = -1
      time = 5.0;
    }

    // creating a timer
    timer = new Timer();
    // starting the timer when the button is pressed
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
    return timer.get() >= time;
  }
}