package edu.wpi.first.wpilibj.templates;

/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap {
    public static final int leftJoystickUSB = 1;
    public static final int rightJoystickUSB = 2;
    
    public static final int frontLeftChannel = 2;
    public static final int frontRightChannel = 3;
    public static final int rearLeftChannel = 4;
    public static final int rearRightChannel = 5;
    
    public static final boolean frontLeftInvert = false;
    public static final boolean frontRightInvert = false;
    public static final boolean rearLeftInvert = false;
    public static final boolean rearRightInvert = false;
    
    
    public static final int highGearChannel = 3;
    public static final int lowGearChannel = 4;
    
    public static final int compressorSpike = 3;
    public static final int compressorSwitch = 1;
    
    public static final double maxTurn = 0.5;
    public static final double minTurn = 0.1;
    
    // For example to map the left and right motors, you could define the
    // following variables to use with your drivetrain subsystem.
    // public static final int leftMotor = 1;
    // public static final int rightMotor = 2;
    
    // If you are using multiple modules, make sure to define both the port
    // number and the module. For example you with a rangefinder:
    // public static final int rangefinderPort = 1;
    // public static final int rangefinderModule = 1;
}
