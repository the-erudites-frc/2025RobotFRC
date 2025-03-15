package frc.robot.subsystems;
import com.revrobotics.spark.SparkMax;
import com.revrobotics.RelativeEncoder;
import com.revrobotics.spark.SparkLowLevel.MotorType;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.RobotMap;
import edu.wpi.first.networktables.BooleanPublisher;
import edu.wpi.first.networktables.BooleanSubscriber;
import edu.wpi.first.networktables.DoublePublisher;
import edu.wpi.first.networktables.DoubleSubscriber;
import edu.wpi.first.networktables.NetworkTable;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.networktables.NetworkTableInstance;


public class Elevator extends SubsystemBase{
    public static SparkMax ELEVATOR_Motor = new SparkMax(RobotMap.MOTOR_ELV_ID, MotorType.kBrushless);
    private static RelativeEncoder elevatorEncoder = ELEVATOR_Motor.getEncoder();
    // SparkMaxConfig config = new SparkMaxConfig();

    // // Configure the encoder to convert rotations into real-world height
    // config.encoder.positionConversionFactor(RobotMap.HEIGHT_PER_ROTATION);

    private final double[] heightLevels = {RobotMap.ELEVATOR_H1, RobotMap.ELEVATOR_H2, 
                                            RobotMap.ELEVATOR_H3, RobotMap.ELEVATOR_H4};
    private int currentIndex = 0;
    // final DoubleSubscriber targetSub;
    // final DoubleSubscriber currentSub;
    // final BooleanSubscriber buttonPressSub;
    // final DoublePublisher targetPub;
    // final DoublePublisher currentPub;
    // final BooleanPublisher buttonPressPub;


    public Elevator() {

        // Reset encoder if limit switch is pressed at startup

        // NetworkTableInstance inst = NetworkTableInstance.getDefault();
        // NetworkTable dataTable = inst.getTable("dataTable");
        // targetSub = dataTable.getDoubleTopic("targetHeight").subscribe(0.0);
        // currentSub = dataTable.getDoubleTopic("CurrentHeight").subscribe(0.0);
        // buttonPressSub = dataTable.getBooleanTopic("ButtonPress").subscribe(false);
        // targetPub = dataTable.getDoubleTopic("Target Out").publish();
        // currentPub = dataTable.getDoubleTopic("Current Out").publish();
        // buttonPressPub = dataTable.getBooleanTopic("Button Out").publish();

        }
    
    //Set motor speed
    public void moveElevator(double speed) {
        ELEVATOR_Motor.set(speed);
    }

    //Stop motors and calculate current height
    public void stop() {
        ELEVATOR_Motor.set(RobotMap.ELEVATOR_HOLD_V);
    }


    public int getHeight() {
        // System.out.println("get hieght" + elevatorEncoder.getPosition());
        // System.out.println(elevatorEncoder.getPosition()*RobotMap.HEIGHT_PER_ROTATION);
        return (int)(elevatorEncoder.getPosition()*-1);
    }

    public void resetEncoder() {
        elevatorEncoder.setPosition(0);
    }

    //Get next height upwards
    public double nextHeight() {
        try{
        for (int i = 0; i < heightLevels.length; i++) {
            if (getHeight() < heightLevels[i]) {
                currentIndex = i;
                break;
            }
        }
        // i.f (currentIndex < heightLevels.length - 1) {
        //     currentIndex++;
        // }a
        return heightLevels[currentIndex];
    } catch(Exception e){
        e.printStackTrace();
        return 0.0;
    }
    }

    //Get next height downwards
    public double prevHeight() {
        try{
        for (int i = (heightLevels.length - 1); i >= 0; i--) {
            if (getHeight() > heightLevels[i]) {
                currentIndex = i;
                break;
            }
        }

        return heightLevels[currentIndex];
    }catch(Exception e){
        e.printStackTrace();
        return 0.0;
    }
    }
}
