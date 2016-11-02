package com.bulrog.robot.impl;


import com.bulrog.robot.Animation;
import com.bulrog.robot.Sprite;
import org.joda.time.DateTime;

import javax.swing.*;

public class AnimationImpl implements Animation{
    private final Sprite sprite;
    private final long speedInMs;
    private final JLabel label;
    DateTime timeForNextFrame;
    int index=0;

    public AnimationImpl(Sprite sprite, long speedInMs, JLabel label) {
        this.sprite = sprite;
        this.speedInMs = speedInMs;
        this.label =label;
        timeForNextFrame=new DateTime().plus(speedInMs);

    }



    @Override
    public void update() {
        if (timeForNextFrame.isBeforeNow()){
            timeForNextFrame=timeForNextFrame.plus(speedInMs);
            label.setIcon(sprite.getFrame(index++));
        }
    }
}
