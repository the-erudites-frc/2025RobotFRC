// // Copyright (c) FIRST and other WPILib contributors.
// // Open Source Software; you can modify and/or share it under the terms of
// // the WPILib BSD license file in the root directory of this project.

// package frc.robot.commands;
// import frc.robot.Robot;
// import frc.robot.RobotMap;
// import edu.wpi.first.wpilibj2.command.Command;

// public class ElevatorControl extends Command {
//     /** Creates a new elevatorControl. */
//     public double targetHeight;
//     private int direction; // 1 is up, -1 is down

//     public ElevatorControl() {
//         // Use addRequirements() here to declare subsystem dependencies.
//         addRequirements(Robot.elevator);
//     }

  
//     // Called when the command is initially scheduled.
//     @Override
//     public void initialize() {
//         boolean isRightBumperPressed = Robot.m_robotContainer.GetDriverRightBumper();
//         boolean isLeftBumperPressed = Robot.m_robotContainer.GetDriverLeftBumper();
//         if (isRightBumperPressed) {
//             this.targetHeight = Robot.elevator.nextHeight(); // Move to previous height level
//         } else if (isLeftBumperPressed) {
//             this.targetHeight = Robot.elevator.prevHeight(); // Move to next height level
//         }
//         System.out.print("RIGHT: " + isRightBumperPressed + "LEFT: " + isLeftBumperPressed);
        
//     }
  
//     // Called every time the scheduler runs while the com  mand is scheduled.
//     @Override
//     public void execute() {
//         System.out.println("elevator entered");

//         // Calculate direction based on the current height and target height
//         if(Robot.elevator.getHeight() < targetHeight){
//             direction = -1;
//         } else{
//             direction = 1;
//         }
//        Robot.elevator.moveElevator(RobotMap.SPEED_ELEVATOR * direction, targetHeight);
//     }

//   // Called once the command ends or is interrupted.
//   @Override
//     public void end(boolean interrupted) {
//         Robot.elevator.stop();
//     }

//   // Returns true when the command should end.
//   @Override
//     public boolean isFinished() {
//         return Math.abs(Robot.elevator.getHeight() - targetHeight) < 0.5; // Stop when within 0.5 units
//     }
// }
