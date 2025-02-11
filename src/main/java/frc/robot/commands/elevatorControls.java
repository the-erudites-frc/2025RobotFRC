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
    public void initialize() {}
  
    // Called every time the scheduler runs while the command is scheduled.
    @Override
    public void execute() {
      double currentHeight = elevator.getHeight();
      moveTime = Math.abs((currentHeight - targetHeight) / HEIGHT_PER_SEC);
      timer.reset();
      timer.start();

    if(currentHeight < targetHeight){
      elevator.moveElevator(speed);
      
      elevator.moveElevator(0);
      
    } else if (currentHeight > targetHeight) {
      elevator.moveElevator(-speed);
      
      elevator.moveElevator(0);
    }


  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    elevator.stop();
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return timer.get() >= moveTime;
  }
}
