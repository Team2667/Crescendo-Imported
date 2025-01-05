package frc.robot.subsystems;

import com.revrobotics.spark.SparkFlex;
import com.revrobotics.spark.SparkBase.ControlType;
import com.revrobotics.spark.SparkBase.PersistMode;
import com.revrobotics.spark.SparkBase.ResetMode;
import com.revrobotics.RelativeEncoder;
import com.revrobotics.spark.SparkLowLevel.MotorType;
import com.revrobotics.spark.config.SparkFlexConfig;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class Launcher extends SubsystemBase{
    private SparkFlex frontWheel;
    private SparkFlex backWheel;
    private RelativeEncoder frontEncoder;
    private RelativeEncoder backEncoder;
    private SparkFlexConfig frontConfig;
    private SparkFlexConfig rearConfig;

    private double pV = 0.0008;
	private double iV = 0.0000004;
    private double dV = 0;
    public double rearspeed=1960;
    public double frontspeed=1960;

    public Launcher() {
        frontWheel=new SparkFlex(Constants.LAUNCHER_WHEEL_FRONT, MotorType.kBrushless);
        backWheel=new SparkFlex(Constants.LAUNCHER_WHEEL_BACK, MotorType.kBrushless);
        frontEncoder=frontWheel.getEncoder();
        backEncoder=backWheel.getEncoder();
        frontConfig = new SparkFlexConfig();
        rearConfig = new SparkFlexConfig();
        setPIDvals();
    }

    public void setPIDvals()
    {
        frontConfig.closedLoop.pid(pV,iV,dV);
        frontWheel.configure(frontConfig, ResetMode.kResetSafeParameters, PersistMode.kPersistParameters);
        rearConfig.closedLoop.pid(pV,iV,dV);
        backWheel.configure(rearConfig, ResetMode.kResetSafeParameters, PersistMode.kPersistParameters);
    }

    public void setSpeedPid(double front, double rear)
    {
        frontWheel.getClosedLoopController().setReference(front, ControlType.kVelocity);
        backWheel.getClosedLoopController().setReference(rear, ControlType.kVelocity);
    }

    public void launchToSpeaker() {
        //front is top
        //rear is bottom
    setSpeedPid(4000,3500);
        //setSpeedPid(4000,1600);

    }
    public void frenchMode()
    {
        frontWheel.set(1);
        backWheel.set(1);
    }
    public void romanian()
    {
         frontWheel.set(0.1);
        backWheel.set(0.1);
    }

    public double getFrontVelocity()
    {
        return frontEncoder.getVelocity();
    }
    public double getBackVelocity()
    {
        return backEncoder.getVelocity();
    }
    public void stop() {
        frontWheel.stopMotor();
        backWheel.stopMotor();
    }
    @Override
    public void periodic()
    {
        if(Constants.debuggymodey)
        {

            double sp=SmartDashboard.getNumber("pV",pV);
            double si=SmartDashboard.getNumber("iV", iV);
            double sd=SmartDashboard.getNumber("dV", dV);
            double vfront=SmartDashboard.getNumber("front velocity", frontspeed);
            double vrear=SmartDashboard.getNumber("rear velocity", rearspeed);


            if(sp!=pV || si!=iV || sd!=dV || vfront!=frontspeed || vrear!=rearspeed)
            {
                pV=sp;
                iV=si;
                dV=sd;
                rearspeed=vrear;
                frontspeed=vfront;
                setPIDvals();
            }
            SmartDashboard.putNumber("pV", pV);
            SmartDashboard.putNumber("iV", iV);
            SmartDashboard.putNumber("dV", dV);
            SmartDashboard.putNumber("front velocity", frontspeed);
            SmartDashboard.putNumber("rear velocity", rearspeed);
            SmartDashboard.putNumber("front velocity real", frontEncoder.getVelocity());
            SmartDashboard.putNumber("rear velocity real", backEncoder.getVelocity());
        }
    }
}
