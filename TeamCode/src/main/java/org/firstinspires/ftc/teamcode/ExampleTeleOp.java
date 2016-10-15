package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.*;
import com.qualcomm.robotcore.hardware.ColorSensor;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.GyroSensor;
import com.qualcomm.robotcore.hardware.Servo;

/**
 * Created by Conno on 9/24/2016.
 */

@TeleOp(name = "Example TeleOp", group = "TeleOp")

public class ExampleTeleOp extends OpMode {

    DcMotor RightWheel;
    DcMotor LeftWheel;

    Servo Claw;

    ColorSensor color;
    GyroSensor gyro;

    @Override
    public void init() {
        RightWheel = hardwareMap.dcMotor.get("Right Wheel");
        LeftWheel = hardwareMap.dcMotor.get("Left Wheel");

        LeftWheel.setDirection(DcMotor.Direction.REVERSE);

        Claw = hardwareMap.servo.get("Claw");

        color = hardwareMap.colorSensor.get("Color");
    }

    /*
       * Code to run when the op mode is first enabled goes here
       * @see com.qualcomm.robotcore.eventloop.opmode.OpMode#start()
       */
    @Override
    public void init_loop() {

    }

    /*
     * This method will be called ONCE when start is pressed
     * @see com.qualcomm.robotcore.eventloop.opmode.OpMode#loop()
     */
    @Override
    public void start() {
        Claw.setPosition(0.4);
    }

    /*
     * This method will be called repeatedly in a loop
     * @see com.qualcomm.robotcore.eventloop.opmode.OpMode#loop()
     */
    @Override
    public void loop() {
        RightWheel.setPower(gamepad1.right_trigger);
        LeftWheel.setPower(gamepad1.left_stick_y);

        if(gamepad2.a)
        {
            Claw.setPosition(0.3);
        }

        if(gamepad1.b)
        {
            Claw.setPosition(0.8);
        }


    }
}