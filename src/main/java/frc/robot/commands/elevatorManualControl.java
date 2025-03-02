// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.Elevator;

/* You should consider using the more terse Command factories API instead https://docs.wpilib.org/en/stable/docs/software/commandbased/organizing-command-based.html#defining-commands */
public class elevatorManualControl extends Command {
    private final Elevator elevator;
    private final double speed = 0.3;
    private final Timer timer = new Timer();
    private double moveTime;
    private double currentHeight;
    private int direction; // 1 is up, 0 is down
  /** Creates a new elevatorManualControl. */
  public elevatorManualControl(Elevator elevator, String upDown) {
    // Use addRequirements() here to declare subsystem dependencies.
    this.elevator = elevator;
    if(upDown.equals("up")){
      direction = 1;
    } else{
      direction = 0;
    }

  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    currentHeight = elevator.getHeight();
    timer.reset();
    timer.start();
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    if(direction == 1){
      elevator.moveElevator(speed);
    }else{
    elevator.moveElevator(-speed);
    }
}

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    elevator.stop(direction, moveTime);
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
