// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.Robot;
import frc.robot.subsystems.Algae;

//need to figure out motor stop conditions (elapsed time + trial?)
public class AlgaeHinge extends Command {
  private static boolean isRaised = false;
  //THEORETICALLY would only be false at start, then be determined by button controls?
  private double speed;
  private Timer timer;
  //placeholder time for hinge to reach rest + raised positions
  private final double hingeTime = 3.0;
  private final Algae algae;

  /** Creates a new AlgaeHinge. */
  public AlgaeHinge(Algae algae) {
    this.algae = algae;
    addRequirements(this.algae);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    //have to check motor directions
    if (isRaised){
      //currently raised --> going down
      speed = -1;
    } else {
      //currently down --> going up
      speed = 1;
    }

    Timer timer = new Timer();
    timer.start();
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    Robot.algae.setHingeSpeed(speed);
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    //once finished, update isRaised
    isRaised = !isRaised;
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return timer.get() >= hingeTime;
  }

  //return isRaised for intake/output to know whether it is reef/ground
  public static boolean getIsRaised(){
    return isRaised;
  }
}
