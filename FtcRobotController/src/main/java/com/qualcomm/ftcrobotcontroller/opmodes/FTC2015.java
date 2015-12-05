package com.qualcomm.ftcrobotcontroller.opmodes;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.util.Range;

/**
 * Created by 997robotics1 on 12/1/2015.
 */

// Mia did the conveyor belt and holds no accountability for any future assassinations of the robot because this code is perfectly fine

public class FTC2015 extends OpMode {

    private DcMotor conveyorbelt;

    public FTC2015 (){


    }

        ///////////////////////////////////////

        @Override public void init () {

            conveyorbelt = hardwareMap.dcMotor.get("conveyorbelt"); //sets conveyorbelt as physical conveyor belt motor

    }

        ///////////////////////////////////////

        @Override public void loop () {

            float leftStick = gamepad2.left_stick_y; //makes variable for position of left stick
            leftStick = Range.clip(leftStick, -1, 1); //sets limits on control output
            conveyorbelt.setPower(leftStick); //assigning conveyor belt motor to output from left stick

            if (gamepad2.a) { //if "a" button is pressed
                conveyorbelt.setPower(1); //makes conveyor belt move forward
            }

            if (gamepad2.b) { //if "b" button is pressed
                conveyorbelt.setPower(-1); //makes conveyor belt move backwards
            }

    }

}
