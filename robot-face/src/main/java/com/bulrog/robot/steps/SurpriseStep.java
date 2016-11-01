package com.bulrog.robot.steps;

import com.bulrog.robot.RobotFace;
import com.bulrog.robot.impl.SpriteImpl;

/**
 * Created by jem on 31/10/16.
 */
public class SurpriseStep extends AnimationStep {
    RobotFace robotFace;
    public SurpriseStep(RobotFace robotFace, int timeOfStepinMs) {
        super(timeOfStepinMs);
        this.robotFace=robotFace;
    }

    @Override
    public void updateAnimation() throws Exception {
        if (robotFace!=null){
            robotFace.init();
            robotFace.setEyeBrows(0.0f);
            robotFace.getMouth().setIcon(new SpriteImpl("MouthSurprise.png",900,400).getFrame(0));
            robotFace=null;
        }

    }
}
