package org.firstinspires.ftc.robotcontroller.internal;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.Disabled;

/**
 * Updated by Alex on 11/5/2017.
 */
@Autonomous(name = "AutoTemplate", group = "default")
@Disabled
public class AutoTemplate extends RangerOp {
    //Declare and Initialize any variables needed for this specific autonomous program


    public AutoTemplate() {}

    @Override
    public void loop(){
        //Display Data to be displayed throughout entire Autonomous
        telemetry.addData(stateName, state);
        telemetry.addData("current time", String.format("%.1f", this.time));
        telemetry.addData("state time", String.format("%.1f", this.time - setTime));

        //Use Switch statement to proceed through Autonomous strategy (only use even cases for steps)
        switch(state){
            case 0: //Use this state to reset all hardware devices
                stateName = "Initial Calibration";
                resetSensors();
                resetEncoders();
                state++;
                break;

            case 2: //Describe the Robot’s Goals & Actions in this state
                stateName = "First State Goal";
                //Display any current data needed to be seen during this state (if none is needed, omit this comment)


                if (true) { //Use a boolean value that reads true when state goal is completed
                    state++;
                }
                break;

            case 1000: //Run When Autonomous is Complete
                stateName = "Autonomous Complete";
                //Set all motors to zero and servos to initial positions
                resetSensors();
                resetEncoders();
                break;

            default://Default state used to reset all hardware devices to ensure no errors
                stateName = "Calibrating";
                resetSensors();
                resetEncoders();
                if (waitSec(1)) {
                    state++;
                    setTime = this.time;
                }
                break;
        }
    }

    //Create any methods needed for this specific autonomous program

}