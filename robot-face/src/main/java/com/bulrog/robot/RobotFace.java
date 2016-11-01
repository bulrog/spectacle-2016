package com.bulrog.robot;


import com.bulrog.robot.impl.SpriteImpl;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;

public class RobotFace {
    private JLabel leftEye;
    private JLabel rightEye;
    private JLabel mouth;
    private JLabel nose;
    private JLabel leftEyeBrow;
    private JLabel rightEyeBrow;
    private final JPanel contentPanel;
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

    public void setEyeBrows(float yPosition){
        int yPos=(int)(screenSize.getHeight()*yPosition);
        leftEyeBrow.setLocation((int) (screenSize.getWidth() * 0.2f),yPos);
        rightEyeBrow.setLocation((int) (screenSize.getWidth() * 0.6f),yPos);

    }
    public void init() throws Exception{
        leftEye.setIcon(new SpriteImpl("LeftEye.png",300,300).getFrame(0));
        rightEye.setIcon(new SpriteImpl("RightEye.png",300,300).getFrame(0));
        mouth.setIcon(new SpriteImpl("Mouth.png",900,400).getFrame(0));
        setEyeBrows(0.1f);
    }

    public RobotFace(JPanel contentPanel) throws Exception{
        this.contentPanel=contentPanel;
        leftEye=getImage("LeftEye.png",0.2f,0.20f);
        leftEyeBrow=getImage("eyebrow.png",0.2f,0.1f);
        rightEye=getImage("RightEye.png",0.6f,0.20f);
        rightEyeBrow=getImage("eyebrow.png",0.6f,0.1f);
        mouth=getImage("Mouth.png",0.25f,0.60f);
        nose=getImage("Nose.png",0.46f,0.50f);
        contentPanel.add(leftEye);
        contentPanel.add(rightEye);
        contentPanel.add(mouth);
        contentPanel.add(nose);
        contentPanel.add(leftEyeBrow);
        contentPanel.add(rightEyeBrow);

    }

    public JLabel getLeftEye() {
        return leftEye;
    }

    public JLabel getRightEye() {
        return rightEye;
    }

    public JLabel getMouth() {
        return mouth;
    }

    public JLabel getNose() {
        return nose;
    }

    public JLabel getLeftEyeBrow() {
        return leftEyeBrow;
    }

    public JLabel getRightEyeBrow() {
        return rightEyeBrow;
    }

}
