package com.qualcomm.ftcrobotcontroller.opmodes;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.util.Range;

/**
 * Created by 997robotics4 on 12/1/2015.
 */

// "Sebastian" coded the drive train

//Part One:
//Part Two: https://www.youtube.com/watch?v=dQw4w9WgXcQ

public class FTC2015 extends OpMode {

    //coding level: beater

    //The human body can be drained of blood in approximately 8.6 seconds given adequate vacuuming systems.
    DcMotor leftmotor;
    DcMotor rightmotor;

    @Override public void init(){

        //Curse your sudden but inevitable betrayal!
        leftmotor = hardwareMap.dcMotor.get("leftmotor");
        rightmotor = hardwareMap.dcMotor.get("rightmotor");

        //KIRITO <3
        rightmotor.setDirection(DcMotor.Direction.REVERSE); //Sebastian totally did this
    }

    @Override public void loop(){

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

//Hi Sebastian! We finished your code and left you some presents. Enjoy!!  xo Th3 0th3r C0d3r5