// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.Ultrasonic;
import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.RobotMap;
import frc.robot.subsystems.Coral;

/* You should consider using the more terse Command factories API instead https://docs.wpilib.org/en/stable/docs/software/commandbased/organizing-command-based.html#defining-commands */
public class CoralIntake extends Command {
    private Timer timer = new Timer(); // start intake after 1s
    private final double speed = 0.3;
    private final Coral coral;
    Boolean sensor = sensorAccepted(RobotMap.CORAL_TRIGGER_PIN, RobotMap.CORAL_ECHO_PIN);

    // returns true if sensor is within distance threshold
    public Boolean sensorAccepted(int triggerPin, int echoPin) {
    final int limitMM = 25; // 25 millimeters for limit


    Ultrasonic ultrasonicMeasure = new Ultrasonic(triggerPin, echoPin);
    double measurementMM = ultrasonicMeasure.getRangeMM();

    return measurementMM > limitMM;
  }  


    /** Creates a new coralintake. */
    public CoralIntake(Coral coral) {
        this.coral = coral;
        addRequirements(this.coral);
    }

    // Called when the command is initially scheduled.
    @Override
    public void initialize() {
        coral.Intake(speed);

        if (sensor) {
            timer.start();
        }

        while (sensor) {
            if (timer.get() > 1) { // if sensor detects object for more than 1 second -> start auto thing
                // stuff
                break;
            }
        }

        timer.reset();
    }

    // Called every time the scheduler runs while the command is scheduled.
    @Override
    public void execute() {

        

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
