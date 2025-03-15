// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.CommandScheduler;
import edu.wpi.first.wpilibj2.command.Commands;
import edu.wpi.first.wpilibj2.command.Subsystem;
import frc.robot.commands.AutonDrive;
import frc.robot.commands.TankDrive;
import frc.robot.commands.AutonCoralMove;
import frc.robot.commands.AutonDrive;
import frc.robot.commands.CoralHingeMove;
import frc.robot.commands.CoralIntakeShooter;
import frc.robot.commands.ElevatorManual;
import frc.robot.subsystems.AlgaeHinge;
import frc.robot.subsystems.AlgaeWheels;
import frc.robot.commands.AlgaeHingeMove;
import frc.robot.commands.AlgaeIntakeShooter;
import frc.robot.subsystems.CoralHinge;
import frc.robot.subsystems.CoralWheels;
// import frc.robot.subsystems.Algae;
import frc.robot.subsystems.DriveTrain;
import frc.robot.subsystems.Elevator;

/**
 * The methods in this class are called automatically corresponding to each mode, as described in
 * the TimedRobot documentation. If you change the name of this class or the package after creating
 * this project, you must also update the Main.java file in the project.
 */
public class Robot extends TimedRobot {
  private Command m_autonomousCommand;
  public static RobotContainer m_robotContainer;

  //Drive base initializations
  public static DriveTrain driveTrain = new DriveTrain();
  public static TankDrive tankDrive = new TankDrive();

  //Elevators initializations
  public static Elevator elevator = new Elevator();
  public static ElevatorManual elevatorManual = new ElevatorManual();
  public static boolean troubleshooting = false;

  //Coral's initializations
  public static CoralHinge coralHinge = new CoralHinge();
  public static CoralHingeMove coralHingeMove = new CoralHingeMove();

  public static CoralWheels coralWheels = new CoralWheels();
  public static CoralIntakeShooter coralIntakeShooter = new CoralIntakeShooter();

  //Algae's initializations
  public static AlgaeHinge algaeHinge = new AlgaeHinge();
  public static AlgaeHingeMove algaeHingeMove = new AlgaeHingeMove();

  public static AlgaeWheels algaeWheels = new AlgaeWheels();
  public static AlgaeIntakeShooter algaeIntakeShooter = new AlgaeIntakeShooter();

  // // //Autos initializations
  public static AutonDrive autonDrive = new AutonDrive();
  // public static AutonCoralMove autonCoralMove = new AutonCoralMove();


  /**
   * This function is run when the robot is first started up and should be used for any
   * initialization code.
   */
  public Robot() {
    // Instantiate our RobotContainer.  This will perform all our button bindings, and put our
    // autonomous chooser on the dashboard.
    m_robotContainer = new RobotContainer();
  }

  /**
   * This function is called every 20 ms, no matter the mode. Use this for items like diagnostics
   * that you want ran during disabled, autonomous, teleoperated and test.
   *
   * <p>This runs after the mode specific periodic functions, but before LiveWindow and
   * SmartDashboard integrated updating.
   */
  @Override
  public void robotPeriodic() {
    // Runs the Scheduler.  This is responsible for polling buttons, adding newly-scheduled
    // commands, running already-scheduled commands, removing finished or interrupted commands,
    // and running subsystem periodic() methods.  This must be called from the robot's periodic
    // block in order for anything in the Command-based framework to work.
    CommandScheduler.getInstance().run();
  }

  /** This function is called once each time the robot enters Disabled mode. */
  @Override
  public void disabledInit() {
  }

  @Override
  public void disabledPeriodic() {}

  /** This autonomous runs the autonomous command selected by your {@link RobotContainer} class. */
  @Override
  public void autonomousInit() {

    // driveTrain.autonDriveTest();
    // coralHinge.autonHingeMove();
    // autonDrive.schedule();
    // autonCoralMove.schedule();

  }

  /** This function is called periodically during autonomous. */
  @Override
  public void autonomousPeriodic() {
    Commands.parallel(new AutonDrive(), new AutonCoralMove());

  }

  @Override
  public void teleopInit() {
    // This makes sure that the autonomous stops running when
    // teleop starts running. If you want the autonomous to
    // continue until interrupted by another command, remove
    // this line or comment it out.
    if (m_autonomousCommand != null) {
      m_autonomousCommand.cancel();
    }

    tankDrive.schedule();

    elevatorManual.schedule();

    coralIntakeShooter.schedule();
    coralHingeMove.schedule();

    algaeIntakeShooter.schedule();
    algaeHingeMove.schedule();
    
  }

  /** This function is called periodically during operator control. */
  @Override
  public void teleopPeriodic() {
    
  }

  @Override
  public void testInit() {
    // Cancels all running commands at the start of test mode.
    CommandScheduler.getInstance().cancelAll();
    
  }

  /** This function is called periodically during test mode. */
  @Override
  public void testPeriodic() {
    // motorH.set(-0.6);
  }

  /** This function is called once when the robot is first started up. */
  @Override
  public void simulationInit() {}

  /** This function is called periodically whilst in simulation. */
  @Override
  public void simulationPeriodic() {}
}
