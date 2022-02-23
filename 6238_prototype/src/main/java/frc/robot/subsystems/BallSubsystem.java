package frc.robot.subsystems;


import edu.wpi.first.wpilibj2.command.SubsystemBase;
import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import frc.robot.Constants;

public class BallSubsystem extends SubsystemBase {
    private final CANSparkMax extendMotor;
    private final CANSparkMax upperMotor;
    private final CANSparkMax lowerMotor;
    private final boolean subsystemEnabled = false;

    private double extendSpeed = 0.0;
    private double upperSpeed = 0.0;
    private double lowerSpeed = 0.0;

    public BallSubsystem() {
        if(subsystemEnabled){
            extendMotor = new CANSparkMax(Constants.BALL_EXTEND_ID, MotorType.kBrushless);
            upperMotor = new CANSparkMax(Constants.BALL_UPPER_ID, MotorType.kBrushless);
            lowerMotor = new CANSparkMax(Constants.BALL_LOWER_ID, MotorType.kBrushless);
        } else{
            extendMotor = null;
            upperMotor = null;
            lowerMotor = null;
        }

    }

    public void setSpeed(double extendSpeed, double upperSpeed, double lowerSpeed) {
        this.extendSpeed = extendSpeed;
        this.upperSpeed = upperSpeed;
        this.lowerSpeed = lowerSpeed;
    }

    @Override
    public void periodic() {
        if (subsystemEnabled) {
            extendMotor.set(extendSpeed);
            upperMotor.set(upperSpeed);
            lowerMotor.set(lowerSpeed);
        }
    }
}
