package frc.robot.subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkLowLevel.MotorType;

import javax.management.loading.PrivateClassLoader;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.motorcontrol.Talon;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class PickupSubsystem extends SubsystemBase {
    private static PickupSubsystem instance;
    
    private TalonSRX pickupMotor;

    public PickupSubsystem () {
        initializeMotors();
    }

    public static PickupSubsystem getInstance() {
        if (instance == null) {
            System.out.println("pickup init");
            instance = new PickupSubsystem();
        }
        return instance;
    }

    public void initializeMotors() {
        pickupMotor = new TalonSRX(Constants.Pickup.PICKUP_ID);

        pickupMotor.setInverted(true);
    }

    public void startMotor(double speed) {
        pickupMotor.set(ControlMode.PercentOutput, speed);
    }
}
