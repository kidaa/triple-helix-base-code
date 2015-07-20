
package edu.wpi.first.wpilibj.templates.commands;

import edu.wpi.first.wpilibj.templates.RobotMap;

/**
 *
 * @author bradmiller
 */
public class JoystickDrive extends CommandBase {

    public JoystickDrive() {
        requires(driveTrain);
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
        double slope; 
      
        slope = (RobotMap.maxTurn - (1.0 - RobotMap.minTurn)) / -1.0; 
       
        double throttle, turn, leftPower, rightPower;
        throttle = oi.getLeftJoystick().getY();
        turn = oi.getRightJoystick().getX();
        
        leftPower = throttle - ((slope * Math.abs(throttle) - RobotMap.maxTurn)*turn);
        rightPower = throttle + ((slope * Math.abs(throttle) - RobotMap.maxTurn)*turn);
        
        driveTrain.drive(leftPower, rightPower);
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
