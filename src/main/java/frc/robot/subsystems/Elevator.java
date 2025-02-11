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
    private final double[] heightLevels = {0, 10 , 20, 30};
    private int currentIndex = 0;

    public void moveElevator(double speed) {
        if(speed < 0 && !limitSwitch.get()){
            currentHeight = 0;
            stop();
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

    public double nextHeight() {
        if(currentIndex < heightLevels.length - 1){
            currentIndex++;
        }
        return heightLevels[currentIndex];

    }

    public double prevHeight() {
        if(currentIndex > 0){
            currentIndex--;
        }
        return heightLevels[currentIndex];
    }
}
