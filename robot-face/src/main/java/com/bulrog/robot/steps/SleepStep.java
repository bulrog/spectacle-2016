package com.bulrog.robot.steps;

import com.bulrog.robot.Animation;
import com.bulrog.robot.RobotFace;
import com.bulrog.robot.impl.AnimationImpl;
import com.bulrog.robot.impl.SpriteImpl;

/**
 * Created by jem on 01/11/16.
 */
public class SleepStep extends AnimationStep {
    private final Animation snoze;
    private RobotFace robotFace;
    public SleepStep(RobotFace robotFace,int timeofStepInMs)  throws Exception{
        super(timeofStepInMs);
        this.robotFace=robotFace;
        snoze=new AnimationImpl(new SpriteImpl("MouthSnoze.png",900,400)
                ,300,robotFace.getMouth());

    }

    @Override
    public void updateAnimation() throws Exception {
        if (robotFace!=null){
            robotFace.init();
            robotFace.getLeftEye().setIcon(new SpriteImpl("EyeClose.png",300,300).getFrame(0));
            robotFace.getRightEye().setIcon(new SpriteImpl("EyeClose.png",300,300).getFrame(0));
            robotFace=null;
        }
        snoze.update();
    }
}
