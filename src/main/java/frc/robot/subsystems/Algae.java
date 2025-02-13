// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.revrobotics.spark.SparkLowLevel.MotorType;
import com.revrobotics.spark.SparkMax;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.RobotMap;

public class Algae extends SubsystemBase {
  private SparkMax motorHinge = new SparkMax(RobotMap.MOTOR_HINGE_ID, MotorType.kBrushless);
  private SparkMax motorInner = new SparkMax(RobotMap.MOTOR_IN_ID, MotorType.kBrushless);
  private SparkMax motorOuter = new SparkMax(RobotMap.MOTOR_OUT_ID, MotorType.kBrushless);

  /** Creates a new Algae. */
  public Algae() {}

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }

  //set motor speeds
  public void setHingeSpeed(double speed){
    motorHinge.set(speed);
  }

  public void setInnerOuterSpeed(double speed){
    motorInner.set(speed);
    motorOuter.set(speed);
  }

}
