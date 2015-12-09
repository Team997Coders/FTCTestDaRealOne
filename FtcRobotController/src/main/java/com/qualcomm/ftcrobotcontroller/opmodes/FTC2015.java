package com.qualcomm.ftcrobotcontroller.opmodes;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.util.Range;

import com.qualcomm.robotcore.hardware.Servo;

/**
 * Created by 997robotics1 on 12/1/2015.
 */

// Mia did the conveyor belt and holds no accountability for any future assassinations of the robot because this code is perfectly fine

public class FTC2015 extends OpMode {

    private DcMotor conveyorbelt;

    private DcMotor leftmotor;
    private DcMotor rightmotor;

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

        ///////////////////////////////////////

        @Override public void init () {

            conveyorbelt = hardwareMap.dcMotor.get("conveyorbelt"); //sets conveyorbelt as physical conveyor belt motor

            //tell the computer where to find the servo
            doorservo = hardwareMap.servo.get("door_servo");

            //assign a value to the door position variable
            doorPosition = 0.2;

            //Curse your sudden but inevitable betrayal!
            leftmotor = hardwareMap.dcMotor.get("leftmotor");
            rightmotor = hardwareMap.dcMotor.get("rightmotor");

            //KIRITO <3
            rightmotor.setDirection(DcMotor.Direction.REVERSE); //Sebastian totally did this

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


            //If your hand touches metal I swear by my pretty floral bonnet I will end you.
            float rightstickx = gamepad1.right_stick_x;
            float rightsticky = gamepad1.right_stick_y;

            //Jump START!! #NerveGear
            rightstickx = Range.clip(rightstickx,1,-1);
            rightsticky = Range.clip(rightsticky,1,-1);

            //Morbid and creepifying
            leftmotor.setPower(rightstickx - rightsticky);
            rightmotor.setPower(rightstickx + rightsticky);

            telemetry.addData("01", "GoingOneDirectionThisAmount");
            telemetry.addData("02", "GoingTheOppositeDirectionThisAmount");

        }
}