package com.bulrog.robot.steps;


import com.bulrog.robot.Animation;
import com.bulrog.robot.RobotFace;
import com.bulrog.robot.impl.AnimationImpl;
import com.bulrog.robot.impl.SpriteImpl;

public class SpeakStep extends AnimationStep {
    private Animation speak;

    public SpeakStep(RobotFace robotFace, int timeOfStepInMs) throws Exception {
        super(timeOfStepInMs);
        speak=new AnimationImpl(new SpriteImpl("MouthSpeak.png",900,400)
                ,500,robotFace.getMouth());

    }

    @Override
    public void updateAnimation() {
        speak.update();
    }
}
