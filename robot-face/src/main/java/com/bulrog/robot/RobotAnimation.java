package com.bulrog.robot;


import com.bulrog.robot.steps.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class RobotAnimation {

    private static AnimationStep animationStep;
    private static ActionListener MAIN_LOOP=e-> {
        try {

            animationStep=animationStep.update();
            if (animationStep==null){
                System.exit(0);
            }
        }
        catch (Exception e1){
            System.out.println(e1);
            System.exit(1);
        }
    };

    private static void setAnimation(RobotFace robotFace) throws Exception{
        animationStep=new AnimationStepBuilder()
                .add(new SpeakStep(robotFace,3000))
                .add(new SleepStep(robotFace,3000))
                .add(new StandStep(robotFace,2000))
                .add(new SurpriseStep(robotFace,2000))
                .add(new StandStep(robotFace,2000))
                .add(new SpeakStep(robotFace,3000))
                .build();

    }

    private static Timer ANIMATION=new Timer(100,MAIN_LOOP);

    public static void main(String[] args) throws Exception{
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    JFrame frame = new JFrame("trial animation");
                    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

                    JPanel contentPane = new JPanel();
                    contentPane.setOpaque(true);
                    contentPane.setBackground(Color.BLACK);
                    contentPane.setLayout(null);
                    setAnimation(new RobotFace(contentPane));
                    frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
                    frame.setContentPane(contentPane);
                    frame.setLocationByPlatform(true);
                    frame.setVisible(true);
                    ANIMATION.start();

                } catch (Exception e) {
                    System.out.println(e);
                    System.exit(1);
                }
            }
        });
    }
}
