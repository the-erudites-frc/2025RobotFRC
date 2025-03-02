// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;
import frc.robot.subsystems.Elevator;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj2.command.Command;

public class elevatorControls extends Command {
  private final double HEIGHT_PER_SEC = 5;
    /** Creates a new elevatorControl. */
  
    private final Elevator elevator;
    private final double targetHeight;
    private final double speed = 0.3;
    private final Timer timer = new Timer();
    private double moveTime;
    private double currentHeight;
    private int direction; // 1 is up, 0 is down
  
    //Set elevator to move down or up
    public elevatorControls(Elevator elevator, String upDown) {
      this.elevator = elevator;

      if(upDown.equals("up")){
        this.targetHeight = elevator.nextHeight();
      } else{
        this.targetHeight = elevator.prevHeight();
      }
      // Use addRequirements() here to declare subsystem dependencies.
    }
  
    // Called when the command is initially scheduled.
    @Override
    //Calculate time to move elevator based on difference in current and target.
    //Start timer
    public void initialize() {
      currentHeight = elevator.getHeight();
      moveTime = Math.abs((currentHeight - targetHeight) / HEIGHT_PER_SEC);
      timer.reset();
      timer.start();

    }
  
    // Called every time the scheduler runs while the command is scheduled.
    //Set speed based on direction up/down
    @Override
    public void execute() {
      
    if(currentHeight < targetHeight){
      direction = 1;
      elevator.moveElevator(speed);

    } else if (currentHeight > targetHeight) {
      direction = 0;
      elevator.moveElevator(-speed);
    }


  }

  // Called once the command ends or is interrupted.
  //Return time and direction to recalculate current height after command is done
  @Override
  public void end(boolean interrupted) {
    elevator.stop(direction, moveTime);
  }

  // Returns true when the command should end.
  //Stop when time exceeds movetime
  @Override
  public boolean isFinished() {
    return timer.get() >= moveTime;
  }
}
