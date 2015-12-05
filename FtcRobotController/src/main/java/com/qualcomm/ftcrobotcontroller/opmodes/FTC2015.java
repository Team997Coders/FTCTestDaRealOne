package com.qualcomm.ftcrobotcontroller.opmodes;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.util.Range;

/**
 * Created by 999 on 12/1/2015.
 */

//JULIA did the doorthingy servo
public class FTC2015 extends OpMode {

    //put minimum and max values for servo in variables
    final static double DOOR_MIN_RANGE = 0.2;
    final static double DOOR_MAX_RANGE = 0.9;

   //declare the door position and door change variable
    double doorPosition;
    double doorChange = 0.7;

    //declare the servo
    private Servo doorservo;

public FTC2015() {

    }

    @Override public void init() {

        //tell the computer where to find the servo
        doorservo = hardwareMap.servo.get("door_servo");

        //assign a value to the door position variable
        doorPosition = 0.2;
    }

    @Override public void loop() {

        //if x button is pressed, make the door open
        if (gamepad1.x) {

            doorPosition += doorChange;
        }


        //if y button is pressed, make the door close
        if (gamepad1.y) {

            doorPosition -= doorChange;
        }

        //set min and max values of servo
        doorPosition = Range.clip(doorPosition, DOOR_MIN_RANGE, DOOR_MAX_RANGE);

        //set the servo's position
        doorservo.setPosition(doorPosition);


    }




}
