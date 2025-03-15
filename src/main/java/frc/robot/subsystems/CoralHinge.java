// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;


import com.revrobotics.spark.SparkLowLevel.MotorType;
import com.revrobotics.spark.SparkMax;

import edu.wpi.first.wpilibj.motorcontrol.*;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Robot;
import frc.robot.RobotMap;

public class CoralHinge extends SubsystemBase {
    SparkMax motorHC = new SparkMax(RobotMap.MOTOR_CORAL_HINGE_ID, MotorType.kBrushless);

    public void moveHinge(double speed) {
      motorHC.set(speed);
    }

    public void autonHingeMove(){
      Robot.coralHinge.moveHinge(-0.11);
    }

       /** Creates a new Coral. */
    public CoralHinge() {}
    
    @Override
    public void periodic() {
      // This method will be called once per scheduler run
    }
 
}
