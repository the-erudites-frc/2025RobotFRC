package frc.robot.subsystems;
import com.revrobotics.spark.SparkMax;
import com.revrobotics.spark.SparkLowLevel.MotorType;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.RobotMap;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Timer;


public class Elevator extends SubsystemBase{
    SparkMax motorElevator = new SparkMax(RobotMap.MOTOR_ELV_ID, MotorType.kBrushless);
    DigitalInput limitSwitch = new DigitalInput(6);

    private double currentHeight = 0;
    private final double HEIGHT_PER_SEC = 5;
    private Timer timer = new Timer();

    public void moveElevator(double speed) {
        if(speed < 0 && limitSwitch.get()){
            currentHeight = 0;
            motorElevator.set(0);
            return;
        }

        timer.reset();
        timer.start();
        motorElevator.set(speed);


    }

    public void stop(){
        double elapsedTime = timer.get();
        currentHeight += elapsedTime * HEIGHT_PER_SEC;
        motorElevator.set(0);
        timer.stop();
    }

    public double getHeight(){
        return currentHeight;
    }

}
