package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

import com.revrobotics.spark.SparkBase.ResetMode;
import com.revrobotics.spark.SparkBase.PersistMode;
import com.revrobotics.spark.SparkLimitSwitch;
import com.revrobotics.spark.SparkLowLevel.MotorType;
import com.revrobotics.spark.config.SparkMaxConfig;
import com.revrobotics.spark.SparkMax;

import frc.robot.Constants;


public class Intake extends SubsystemBase{
    private SparkMax intakeMotor;

    // This is the constructor for the Intake subsystem. Its purpose is to initialize
    // class fields which will be used by other methods in this class.
    //
    public Intake(){
        intakeMotor= new SparkMax(Constants.INTAKE_MOTOR_CAN_ID, MotorType.kBrushless);        
    }
    public void start(double speed) {
        intakeMotor.set(-speed);
    }
    public void startReverse() {
        intakeMotor.set(0.5);
    }
    public void startReverseFull()
    {
        intakeMotor.set(1);
    }
    

    public void stop() {
        intakeMotor.stopMotor();
    }

    //Am I the Harvard Science Center or what because my code is fire
    public void enableLimitSwitch() { //make the feed start sneeding(detecting limit switch in normal human terms)
        SparkMaxConfig config = new SparkMaxConfig();
        config.limitSwitch.reverseLimitSwitchEnabled(true);
        intakeMotor.configure(config, ResetMode.kResetSafeParameters, PersistMode.kPersistParameters);
    }

    public void disableLimitSwitch() { //make the feed crippled
        SparkMaxConfig config = new SparkMaxConfig();
        config.limitSwitch.reverseLimitSwitchEnabled(true);
        intakeMotor.configure(config, ResetMode.kResetSafeParameters, PersistMode.kPersistParameters);
    }


    public boolean isLimitSwitchEngaged() { //Tell if pushed
        SparkLimitSwitch sneed = intakeMotor.getReverseLimitSwitch();
        return sneed.isPressed();
    }
}
