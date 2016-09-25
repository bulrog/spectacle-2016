package com.bulrog.robot.steps;


import org.joda.time.DateTime;

public abstract class AnimationStep {
    private AnimationStep nextStep;
    private final int timeofStepInMs;
    private DateTime timeOut;

    public abstract void updateAnimation() throws Exception;


    public AnimationStep(int timeofStepInMs){
        this.timeofStepInMs=timeofStepInMs;
    }
    public void setNextStep(AnimationStep nextStep) {
        this.nextStep = nextStep;

    }

    public AnimationStep update() throws Exception{
        if (timeOut==null){
            timeOut=new DateTime().plus(timeofStepInMs);
        }
        if (timeOut.isAfterNow()){
            updateAnimation();
            return this;
        }
        return nextStep;
    }
}
