package com.bulrog.robot.steps;

/**
 * Created by jem on 25/09/16.
 */
public class AnimationStepBuilder {
    private AnimationStep firstStep;
    private AnimationStep lastStep;


    public AnimationStepBuilder add(AnimationStep step){
        if (firstStep==null){
            firstStep=step;

        }
        else {
            lastStep.setNextStep(step);
        }
        lastStep=step;
        return this;
    }
    public AnimationStep build(){
        return firstStep;
    }
}
