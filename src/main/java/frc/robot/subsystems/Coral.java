// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.revrobotics.spark.SparkMax;
import com.revrobotics.spark.SparkLowLevel.MotorType;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.RobotMap;

public class Coral extends SubsystemBase {

    SparkMax motorL = new SparkMax(RobotMap.MOTOR_SHOOTER_INTAKE_L, MotorType.kBrushless);
    SparkMax motorR = new SparkMax(RobotMap.MOTOR_SHOOTER_INTAKE_R, MotorType.kBrushless);
    SparkMax motorH = new SparkMax(RobotMap.MOTOR_SHOOTER_HINGE, MotorType.kBrushless);

    public void Intake(double speed) {
        motorL.set(speed);
        motorR.set(-speed);
    }

    public void Shooter(double speed) {
        motorL.set(-speed);
        motorR.set(speed);
    } 

    public void Hinge(double speed) {
        motorH.set(speed);
    }




  /** Creates a new Coral. */
  public Coral() {}
    



  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
