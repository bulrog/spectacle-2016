package com.bulrog.robot;


import com.bulrog.robot.impl.AnimationImpl;
import com.bulrog.robot.impl.SpriteImpl;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class RobotAnimation {

    private static Animation speak;
    private static RobotFace robotFace;
    private static ActionListener MAIN_LOOP=e-> {
        speak.update();
    };


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
                    robotFace=new RobotFace(contentPane);
                    speak=new AnimationImpl(new SpriteImpl("MouthSpeak.png",900,400)
                            ,500,robotFace.getMouth());
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
