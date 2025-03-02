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

    //Set motor speed
    public void moveElevator(double speed) {
        if(speed < 0 && !limitSwitch.get()){
            currentHeight = 0;
            motorElevator.set(0);
            return;
        }

        timer.reset();
        timer.start();
        motorElevator.set(speed);

    }

    //Stop motors and calculate current height
    public void stop(int direction, double moveTime){
        if(direction == 1){
            currentHeight += moveTime * HEIGHT_PER_SEC;
        }else{
            currentHeight -= moveTime * HEIGHT_PER_SEC;
        }
        motorElevator.set(0);
        timer.stop();
    }


    public double getHeight(){
        return currentHeight;
    }

    //Get next height upwards
    public double nextHeight() {
        for(int i = 0; i < heightLevels.length; i++){
            if(currentHeight < heightLevels[i]){
                currentIndex = i - 1;
            }
        }
        if(currentIndex < heightLevels.length - 1){
            currentIndex++;
        }
        return heightLevels[currentIndex];

    }

    //Get next height downwards
    public double prevHeight() {
        for(int i = 0; i < heightLevels.length; i++){
            if(currentHeight < heightLevels[i]){
                    currentIndex = i + 1;
            }
        }
        if(currentIndex > 0){
            currentIndex--;
        }
        return heightLevels[currentIndex];
    }
}
