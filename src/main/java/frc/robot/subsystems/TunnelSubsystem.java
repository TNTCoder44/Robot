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

public class TunnelSubsystem extends SubsystemBase {
    private static TunnelSubsystem instance;
    
    private TalonSRX tunnelMotor;
    
    public TunnelSubsystem () {
        initializeMotors();
    }

    public static TunnelSubsystem getInstance() {
        if (instance == null) {
            System.out.println("pickup init");
            instance = new TunnelSubsystem();
        }
        return instance;
    }

    public void initializeMotors() {
        tunnelMotor = new TalonSRX(Constants.Tunnel.TUNNEL_ID);
    }

    public void startMotor(double speed) {
        tunnelMotor.set(ControlMode.PercentOutput, speed);
    }
}
