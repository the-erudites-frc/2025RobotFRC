package frc.robot.subsystems;

import com.revrobotics.spark.SparkLowLevel.MotorType;
import com.revrobotics.spark.SparkMax;

// import com.revrobotics.spark.SparkLowLevel.MotorType;
// import com.revrobotics.spark.SparkMax;

import edu.wpi.first.wpilibj.motorcontrol.*;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
// import frc.robot.Robot;
import frc.robot.RobotMap;

public class CoralWheels extends SubsystemBase{
    SparkMax motorTC = new SparkMax(RobotMap.MOTOR_TC_ID, MotorType.kBrushless);

    public void moveMotors(double speed) {
        motorTC.set(speed); // ideally countercw for positive speed
    }

     /** Creates a new Coral. */
    public CoralWheels() {}
        
    @Override
    public void periodic() {
        // This method will be called once per scheduler run
    }
}
