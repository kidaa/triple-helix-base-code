
package edu.wpi.first.wpilibj.templates.subsystems;

import edu.wpi.first.wpilibj.CANJaguar;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.can.CANTimeoutException;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.templates.RobotMap;
import edu.wpi.first.wpilibj.templates.commands.JoystickDrive;

/**
 *
 */
public class DriveTrain extends Subsystem {
    private CANJaguar frontLeft, frontRight, rearLeft, rearRight;
    private RobotDrive rDrive;
    private Solenoid high, low;
    public DriveTrain() {
        try {
            frontLeft = new CANJaguar(RobotMap.frontLeftChannel);
            frontRight = new CANJaguar(RobotMap.frontRightChannel);
            rearLeft = new CANJaguar(RobotMap.rearLeftChannel);
            rearRight = new CANJaguar(RobotMap.rearRightChannel);
            
            frontLeft.configNeutralMode(CANJaguar.NeutralMode.kCoast);
            frontRight.configNeutralMode(CANJaguar.NeutralMode.kCoast);
            rearLeft.configNeutralMode(CANJaguar.NeutralMode.kCoast);
            rearRight.configNeutralMode(CANJaguar.NeutralMode.kCoast);
            
            rDrive = new RobotDrive(frontLeft, rearLeft, frontRight, rearRight);
            rDrive.setSafetyEnabled(false);
            
            rDrive.setInvertedMotor(RobotDrive.MotorType.kFrontLeft, RobotMap.frontLeftInvert);
            rDrive.setInvertedMotor(RobotDrive.MotorType.kRearLeft, RobotMap.rearLeftInvert);
            rDrive.setInvertedMotor(RobotDrive.MotorType.kFrontRight, RobotMap.frontRightInvert);
            rDrive.setInvertedMotor(RobotDrive.MotorType.kRearRight, RobotMap.rearRightInvert);
            
            high = new Solenoid(RobotMap.highGearChannel);
            low = new Solenoid(RobotMap.lowGearChannel);
           
                    
                   
        } catch (CANTimeoutException ex) {
            ex.printStackTrace();
        }
        
    }
    // Put methods for controlling this subsystem
    // here. Call these from Commands.

    public void initDefaultCommand() {
        setDefaultCommand(new JoystickDrive());
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
    public void drive(double left, double right)
    {
        if(left > 1)
            left = 1;
        else if(left < -1)
            left = -1;
        if(right > 1)
            right = 1;
        else if(right < -1)
            right = -1;
        //System.out.println("Left = " + left);
       // System.out.println("Right = " + right);
        //if(rDrive != null)   // for now to make sure we can test the code
        rDrive.tankDrive(left, right);
    }
    public void shift(boolean shiftUp){
        if(shiftUp){
            high.set(true);
            low.set(false);
        }
        else{
            high.set(false);
            low.set(true);
        }
    }
            
}

