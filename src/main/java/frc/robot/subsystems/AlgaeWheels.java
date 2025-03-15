package frc.robot.subsystems;

import com.revrobotics.spark.SparkLowLevel.MotorType;
import com.revrobotics.spark.SparkMax;

import edu.wpi.first.wpilibj.motorcontrol.Spark;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.RobotMap;

public class AlgaeWheels extends SubsystemBase{
    private SparkMax motorTA = new SparkMax(RobotMap.MOTOR_TA_ID, MotorType.kBrushless);

    public void moveMotors(double speed) {
        motorTA.set(speed); // ideally countercw for positive speed
    }

     /** Creates a new Coral. */
    public AlgaeWheels() {}
        
    @Override
    public void periodic() {
        // This method will be called once per scheduler run
    }
}
