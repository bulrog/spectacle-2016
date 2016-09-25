package com.bulrog.robot.steps;


import com.bulrog.robot.RobotFace;
import com.bulrog.robot.impl.SpriteImpl;

import javax.swing.*;

public class StandStep extends AnimationStep{
    JLabel mouth;
    public StandStep(RobotFace robotFace,int timeOfStepInMs) throws Exception{
        super(timeOfStepInMs);
        mouth=robotFace.getMouth();

    }

    @Override
    public void updateAnimation() throws Exception{
        if (mouth!=null){

            mouth.setIcon(new SpriteImpl("Mouth.png",900,400).getFrame(0));
            mouth=null;
        }

    }
}
