package com.bulrog.robot.steps;


import com.bulrog.robot.Animation;
import com.bulrog.robot.RobotFace;
import com.bulrog.robot.impl.AnimationImpl;
import com.bulrog.robot.impl.SpriteImpl;

public class SpeakStep extends AnimationStep {
    private final Animation speak;
    private RobotFace robotFace;

    public SpeakStep(RobotFace robotFace, int timeOfStepInMs) throws Exception {
        super(timeOfStepInMs);
        speak=new AnimationImpl(new SpriteImpl("MouthSpeak.png",900,400)
                ,300,robotFace.getMouth());
        this.robotFace=robotFace;

    }

    @Override
    public void updateAnimation() throws Exception{
        speak.update();
        if (robotFace!=null){
            robotFace.init();
            robotFace=null;
        }
    }
}
