// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.math.geometry.Rotation3d;
import edu.wpi.first.math.geometry.Transform3d;

/**
 * The Constants c`
 * <p>It is advised to statically import this class (or one of its inner classes) wherever the
 * constants are needed, to reduce verbosity.
 */
public final class Constants {
  public static class OperatorConstants {
    public static final int kDriverControllerPort = 0;
  }

  public static final double DRIVETRAIN_TRACKWIDTH_METERS = 1.0;
  /**
   * The front-to-back distance between the drivetrain wheels.
   *
   * Should be measured from center to center.
   */
  private static final double pi=3.141592;
   public static final int PigeonId=31;
  public static final double DRIVETRAIN_WHEELBASE_METERS = 1.0;
  public static final double MAX_INPUT_SPEED = 1; //4.14528;

  // CANIDS
  public static final int FRONT_LEFT_MODULE_DRIVE_MOTOR = 7;
  public static final int FRONT_LEFT_MODULE_STEER_MOTOR = 8;
  public static final int FRONT_LEFT_MODULE_STEER_ENCODER = 13;
    //public static final double FRONT_LEFT_MODULE_STEER_OFFSET = -0.9521484375;
    public static final double FRONT_LEFT_MODULE_STEER_OFFSET = -0.45166015625;
  
  public static final int FRONT_RIGHT_MODULE_DRIVE_MOTOR = 3;
  public static final int FRONT_RIGHT_MODULE_STEER_MOTOR = 4;
  public static final int FRONT_RIGHT_MODULE_STEER_ENCODER = 11; 
   //public static final double FRONT_RIGHT_MODULE_STEER_OFFSET = -0.798583984375;
    public static final double FRONT_RIGHT_MODULE_STEER_OFFSET = 0.35400390625;

  public static final int BACK_LEFT_MODULE_DRIVE_MOTOR = 5;
  public static final int BACK_LEFT_MODULE_STEER_MOTOR = 6;
  public static final int BACK_LEFT_MODULE_STEER_ENCODER = 12;
    //public static final double BACK_LEFT_MODULE_STEER_OFFSET = -0.6484375;
    public static final double BACK_LEFT_MODULE_STEER_OFFSET = 0.443603515625;

  public static final int BACK_RIGHT_MODULE_DRIVE_MOTOR = 1;
  public static final int BACK_RIGHT_MODULE_STEER_MOTOR = 2;
  public static final int BACK_RIGHT_MODULE_STEER_ENCODER = 14;
    //public static final double BACK_RIGHT_MODULE_STEER_OFFSET = -0.444580078125;
    public static final double BACK_RIGHT_MODULE_STEER_OFFSET = -0.203125;

  public static final double WHEEL_REVOLUTIONS_PER_METER = 3.0;
  public static final double PERCENTAGE_MAX_SPEED = 100.0;


  //Make stuff stop working so errors dont make the drivers whine
    public static final boolean DISABLE_DRIVETRAIN = false;
    public static final boolean DISABLE_POSE_ESTIMATOR=true;

  //stop blinding kent
    public static final int BRIGHTNESS_DIVISOR = 10;
    public static double spinuptime=0.5;

    public static boolean debuggymodey=true;
    public static double ArmStowStopCurrent=15;
    public static Transform3d CAMERA_TO_ROBOT = new Transform3d(0,0,0,new Rotation3d());
    public static Transform3d ROBOT_TO_CAMERA = new Transform3d(0,0,0,new Rotation3d());
}