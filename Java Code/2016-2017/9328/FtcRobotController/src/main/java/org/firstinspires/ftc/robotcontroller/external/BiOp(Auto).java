/* Copyright (c) 2014 Qualcomm Technologies Inc

All rights reserved.

Redistribution and use in source and binary forms, with or without modification,
are permitted (subject to the limitations in the disclaimer below) provided that
the following conditions are met:

Redistributions of source code must retain the above copyright notice, this list
of conditions and the following disclaimer.

Redistributions in binary form must reproduce the above copyright notice, this
list of conditions and the following disclaimer in the documentation and/or
other materials provided with the distribution.

Neither the name of Qualcomm Technologies Inc nor the names of its contributors
may be used to endorse or promote products derived from this software without
specific prior written permission.

NO EXPRESS OR IMPLIED LICENSES TO ANY PARTY'S PATENT RIGHTS ARE GRANTED BY THIS
LICENSE. THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS
"AS IS" AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO,
THE IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE
ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT OWNER OR CONTRIBUTORS BE LIABLE
FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL
DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR
SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER
CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY,
OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE
OF THIS SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE. */

package org.firstinspires.ftc.robotcontroller.external;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.util.ElapsedTime;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.util.Range;
import com.qualcomm.robotcore.util.ElapsedTime;


/**
 * TeleOp Mode
 * <p>
 * Enables control of the robot via the gamepad
 */

@Autonomous(name="BiOpLeft")


public class BiOp extends LinearOpMode {

	/*
     * Note: the configuration of the servos is such that
     * as the arm servo approaches 0, the arm position moves up (away from the floor).
     * Also, as the claw servo approaches 0, the claw opens up (drops the game element).
     */

    // TETRIX VALUES.
    final static double ARM_MIN_RANGE  = 0;
    final static double ARM_MAX_RANGE  = 1;
    // position of the arm servo.
    // amount to change the arm servo position.
    double armDelta = 0.02;
    double speedThing = 0.2;
    DcMotor motorRight;
    DcMotor motorLeft;
    DcMotor motorArmRight;
    DcMotor motorArmLeft;
    DcMotor motorJackMovementR;
    DcMotor motorJackMovementL;
    DcMotor motorSuck;
    DcMotor motorShoot;
    double servo1Position;
    double servo2Position;
    double armRightPosition;
    double armLeftPosition;
    Servo servo1;
    Servo servo2;
    /**
     * Constructor
     */

    //Runtime to keep time in autonomous
    ElapsedTime     runtime = new ElapsedTime();


    @Override
    public void runOpMode() {
		/*
		 * Use the hardwareMap to get the dc motors and servos by name. Note
		 * that the names of the devices must match the names used when you
		 * configured your robot and created the configuration file.
		 */

		/*
		 * For the demo Tetrix K9 bot we assume the following,
		 *   There are two motors "motor_1" and "motor_2"
		 *   "motor_1" is on the right side of the bot.
		 *   "motor_2" is on the left side of the bot.
		 *
		 * We also assume that there are two servos "servo_1" and "servo_6"
		 *    "servo_1" controls the arm joint of the manipulator.
		 *    "servo_6" controls the claw joint of the manipulator.
		 */

        motorRight = hardwareMap.dcMotor.get("motorRight");
        motorLeft = hardwareMap.dcMotor.get("motorLeft");
        motorArmRight = hardwareMap.dcMotor.get("motorArmRight");
        motorArmLeft = hardwareMap.dcMotor.get("motorArmLeft");
        motorJackMovementR = hardwareMap.dcMotor.get("motorJackMovementR");
        motorJackMovementL = hardwareMap.dcMotor.get("MotorJackMovementL");
        motorShoot = hardwareMap.dcMotor.get("motorShoot");
        motorSuck = hardwareMap.dcMotor.get("motorSuck");
        servo1 = hardwareMap.servo.get("servo_1");
        servo2 = hardwareMap.servo.get("servo_4");
        motorLeft.setDirection(DcMotor.Direction.REVERSE);
        motorArmLeft.setDirection(DcMotor.Direction.REVERSE);

        //START AUTONOMOUS CODE
        armLeftPosition = 0.5;
        armRightPosition = 0.5;

        waitForStart();

        runtime.reset();

        //drive forward 3
        motorRight.setPower(1);
        motorLeft.setPower(1);

        while (opModeIsActive() && (runtime.seconds() < 3.0)) {
            telemetry.addData("Path", "Leg 1: %2.5f S Elapsed", runtime.seconds());
            telemetry.update();
        }

        runtime.reset();

        //shoot 5
        motorRight.setPower(0);
        motorLeft.setPower(0);

        motorShoot.setPower(1);

        while (opModeIsActive() && (runtime.seconds() < 5.0)) {
            telemetry.addData("Path", "Leg 1: %2.5f S Elapsed", runtime.seconds());
            telemetry.update();
        }

        runtime.reset();
        //forward 5
        motorShoot.setPower(0);

        motorRight.setPower(1);
        motorLeft.setPower(1);

        while (opModeIsActive() && (runtime.seconds() < 5.0)) {
            telemetry.addData("Path", "Leg 1: %2.5f S Elapsed", runtime.seconds());
            telemetry.update();
        }

        runtime.reset();
        //left 90 degrees
        motorRight.setPower(1);
        motorLeft.setPower(-1);

        while (opModeIsActive() && (runtime.seconds() < 3.0)) {
            telemetry.addData("Path", "Leg 1: %2.5f S Elapsed", runtime.seconds());
            telemetry.update();
        }

        runtime.reset();
        //forward 5
        motorRight.setPower(1);
        motorLeft.setPower(1);

        while (opModeIsActive() && (runtime.seconds() < 5.0)) {
            telemetry.addData("Path", "Leg 1: %2.5f S Elapsed", runtime.seconds());
            telemetry.update();
        }

        runtime.reset();
        //stop
        motorRight.setPower(0);
        motorLeft.setPower(0);

        //End code with this
        sleep(1000);
    }
    }
