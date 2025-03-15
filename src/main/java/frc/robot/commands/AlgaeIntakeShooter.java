package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.Robot;
import frc.robot.RobotMap;

public class AlgaeIntakeShooter extends Command{

    public AlgaeIntakeShooter(){
        addRequirements(Robot.algaeWheels);
    }

    // Called when the command is initially scheduled.
    @Override
    public void initialize() {
        
    }

    // Called every time the scheduler runs while the command is scheduled.
    @Override
    public void execute() {

        if (Robot.m_robotContainer.getOperatorkA() && !Robot.m_robotContainer.getOperatorkY()) {
            Robot.algaeWheels.moveMotors(RobotMap.ALGAE_SPEED);
        } 
        else if (Robot.m_robotContainer.getOperatorkY() && !Robot.m_robotContainer.getOperatorkA()){
            Robot.algaeWheels.moveMotors(-RobotMap.ALGAE_SPEED);
        }
        else{
            Robot.algaeWheels.moveMotors(0);
        }
        // } (!Robot.m_robotContainer.getOperatorkX() && !Robot.m_robotContainer.getOperatorkB()){
            
        // }   

    }

    // Called once the command ends or is interrupted.
    @Override
    public void end(boolean interrupted) {}

    // Returns true when the command should end.
    @Override
    public boolean isFinished() {
        return false;
    }
    
}
