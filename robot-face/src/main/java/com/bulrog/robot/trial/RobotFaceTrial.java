package com.bulrog.robot.trial;


import com.bulrog.robot.Sprite;
import com.bulrog.robot.impl.SpriteImpl;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;

public class RobotFaceTrial {

    final static Dimension screenSize=Toolkit.getDefaultToolkit().getScreenSize();

    private static JLabel getImage(String fileName, float xPercent, float yPercent) throws Exception{
        BufferedImage image = ImageIO.read(new File(fileName));
        ImageIcon imageIcon = new ImageIcon(image);
        JLabel jLabel = new JLabel();
        jLabel.setIcon(imageIcon);
        jLabel.setSize(image.getWidth(),image.getHeight());
        jLabel.setLocation((int) (screenSize.getWidth() * xPercent),
                (int) (screenSize.getHeight()*yPercent));
        return jLabel;
    }

    public static void main(String[] args) throws Exception {


        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    JFrame frame=new JFrame("trial animation");
                    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

                    JPanel contentPane = new JPanel();
                    contentPane.setOpaque(true);
                    contentPane.setBackground(Color.BLACK);
                    contentPane.setLayout(null);

                    contentPane.add(getImage("LeftEye.png",0.2f,0.20f));
                    contentPane.add(getImage("RightEye.png",0.6f,0.20f));
                    JLabel mouth=getImage("Mouth.png",0.25f,0.60f);
                    contentPane.add(mouth);
                    contentPane.add(getImage("Nose.png",0.46f,0.50f));

                    frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
                    frame.setContentPane(contentPane);
                    frame.setLocationByPlatform(true);
                    frame.setVisible(true);
                    Sprite mouthSprite=new SpriteImpl("MouthSpeak.png",900,400);
                    ActionListener actionListener=new ActionListener() {
                        int index =0;
                        @Override
                        public void actionPerformed(ActionEvent e) {

                            mouth.setIcon(mouthSprite.getFrame(index++%3));
                        }
                    };
                    new Timer(500,actionListener).start();
                }
                catch (Exception e){
                    System.out.println(e);
                    System.exit(1);
                }
            }
        });



    }
}
