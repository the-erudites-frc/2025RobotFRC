package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.Robot;
import frc.robot.RobotMap;

public class CoralIntakeShooter extends Command{

    public CoralIntakeShooter(){
        addRequirements(Robot.coralWheels);
    }

    // Called when the command is initially scheduled.
    @Override
    public void initialize() {
        
    }

    // Called every time the scheduler runs while the command is scheduled.
    @Override
    public void execute() {
        if (Robot.m_robotContainer.getOperatorkX() && !Robot.m_robotContainer.getOperatorkB()) {        
            Robot.coralWheels.moveMotors(RobotMap.CORAL_SPEED);
            System.out.println("MOVE W X");
        } 
        
        
        if (Robot.m_robotContainer.getOperatorkB() && !Robot.m_robotContainer.getOperatorkX()){
            Robot.coralWheels.moveMotors(-RobotMap.CORAL_SPEED);
            System.out.println("MOVE W B");
        }

        if (!Robot.m_robotContainer.getOperatorkX() &&!Robot.m_robotContainer.getOperatorkB()){
            Robot.coralWheels.moveMotors(0);
        }   

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
