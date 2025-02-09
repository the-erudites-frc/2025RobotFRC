// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.revrobotics.spark.SparkMax;
import com.revrobotics.spark.SparkLowLevel.MotorType;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.RobotMap;


public class DriveTrain extends SubsystemBase {
  SparkMax motorLeftF = new SparkMax(RobotMap.MOTOR_LF_ID, MotorType.kBrushless);
  SparkMax motorLeftB = new SparkMax(RobotMap.MOTOR_LB_ID, MotorType.kBrushless);
  SparkMax motorRightF = new SparkMax(RobotMap.MOTOR_RF_ID, MotorType.kBrushless);
  SparkMax motorRightB = new SparkMax(RobotMap.MOTOR_RB_ID, MotorType.kBrushless);

  public void setLeftMotors(double speed){
    motorLeftF.set(-speed);
    motorLeftB.set(-speed);
  }

  public void setRightMotors(double speed){
    motorRightF.set(speed);
    motorRightB.set(speed);
  }

  /** Creates a new DriveTrain. */
  public DriveTrain() {}

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
