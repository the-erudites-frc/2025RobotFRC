// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.Intake;

public class CoralIntake extends Command {
    //Sets up a timer which will be used for a one-second delay
    private final Timer timer = new Timer();

    //Allows us to access the intake subsystem
    private final Intake intake;

    //Tracks if a coral has been detected in the intake
    private boolean coralDetected = false; 

    public CoralIntake(Intake intake) {

    }
    
}
