// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;


import edu.wpi.first.wpilibj.motorcontrol.*;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.RobotMap;

public class Coral extends SubsystemBase {

    Spark motorT = new Spark(RobotMap.MOTOR_SHOOTER_INTAKE_T);
    Spark motorB = new Spark(RobotMap.MOTOR_SHOOTER_INTAKE_B);
    Spark motorH = new Spark(RobotMap.MOTOR_SHOOTER_HINGE);

    public void moveMotors(double speed) {
        motorT.set(speed); // ideally countercw for positive speed
        motorB.set(-speed);
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
