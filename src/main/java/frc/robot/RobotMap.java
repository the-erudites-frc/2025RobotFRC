package frc.robot;

public class RobotMap {

    public static final int DRIVER_CONTROLLER = 0;
    public static final int OPERATOR_CONTROLLER = 1;

    public static final int LEFT_STICK_Y = 1;
    public static final int RIGHT_STICK_Y = 5;

    public static final int MOTOR_LF_ID = 1;
    public static final int MOTOR_LB_ID = 2;
    public static final int MOTOR_RF_ID = 3;
    public static final int MOTOR_RB_ID = 4;
    
    public static final int MOTOR_ELV_ID = 5; //elevator can id
    
    //All algae constants 
    public static final int MOTOR_TA_ID = 11; // changed from 7 to 11
    public static final int MOTOR_ALGAE_HINGE_ID = 10;  // changed from 6 to 10

    public static final double ALGAE_SPEED = 0.2;
    public static final double ALGAE_HOLD_SPEED = -0.01;
    public static final double ALGAE_HOLD_SPEED_HINGE = -0.05;
    

    //All coral constants
    public static final int MOTOR_TC_ID = 6;
    public static final int MOTOR_CORAL_HINGE_ID = 8;

    public static final double CORAL_SPEED = 0.4;
    public static final double CORAL_HOLD_SPEED = -0.01;

    public static final double CORAL_HINGE_SPEED = 0.5;
    //All Elevator constants

    //Elevator height
    public static final double ELEVATOR_H1 = 0;
    public static final double ELEVATOR_H2 = 6;
    public static final double ELEVATOR_H3 = 10;
    public static final double ELEVATOR_H4 = 15;

    public static final double SPEED_ELEVATOR = 0.4; //Elevator Motor Speed
    public static final double HEIGHT_PER_ROTATION = 1/250; //for elevator encoder
    public static final double ELEVATOR_HOLD_V = -0.05; //Elevator Motor Velocity to hold the elevator in place 
    
    
    
    
    
}
