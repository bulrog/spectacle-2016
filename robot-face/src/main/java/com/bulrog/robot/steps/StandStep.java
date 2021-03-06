package com.bulrog.robot.steps;


import com.bulrog.robot.RobotFace;
import com.bulrog.robot.impl.SpriteImpl;

public class StandStep extends AnimationStep{
    RobotFace robotFace;
    public StandStep(RobotFace robotFace,int timeOfStepInMs) throws Exception{
        super(timeOfStepInMs);
        this.robotFace=robotFace;
    }

    @Override
    public void updateAnimation() throws Exception{
        if (robotFace!=null){
            robotFace.init();
            robotFace.getMouth().setIcon(new SpriteImpl("MouthSpeak.png",900,400).getFrame(0));
            robotFace=null;
        }

    }
}
