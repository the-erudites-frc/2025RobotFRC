package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.Robot;
import frc.robot.RobotMap;

public class ElevatorManual extends Command{
    

    public ElevatorManual() {
        addRequirements(Robot.coralHinge); // Declare that this command requires the Coral subsystem
    }
    
    // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    // timer.start();

  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    if (Robot.m_robotContainer.GetDriverRightBumper()) {
        System.out.println("RB");
        Robot.elevator.moveElevator(-RobotMap.SPEED_ELEVATOR);
    } else if (Robot.m_robotContainer.GetDriverLeftBumper()) {
        Robot.elevator.moveElevator(RobotMap.SPEED_ELEVATOR);
        System.out.println("LB");
    } else {
        Robot.elevator.moveElevator(RobotMap.SPEED_ELEVATOR);
    }

    // if (timer.get() > time) {
    //     //If the hinge has moved for the specified time, stop it
    //     timer.reset();
    //     coral.Hinge(0);

    // }

    
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}