package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.Robot;
import frc.robot.RobotMap;

public class AlgaeHingeMove extends Command{

    public AlgaeHingeMove() {
        addRequirements(Robot.algaeHinge); // Declare that this command requires the Coral subsystem
    }
    
    // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    // timer.start();

  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    if (Robot.m_robotContainer.getOperatorBackLeftBumper()!=0) {
        // System.out.println("LB");
        Robot.algaeHinge.moveHinge(Robot.m_robotContainer.getOperatorBackLeftBumper());
    } else if (Robot.m_robotContainer.getOperatorBackRightBumper()!=0) {
        Robot.algaeHinge.moveHinge(-Robot.m_robotContainer.getOperatorBackRightBumper());
        // System.out.println("RB");
    } else {
        Robot.algaeHinge.moveHinge(RobotMap.ELEVATOR_HOLD_V);
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