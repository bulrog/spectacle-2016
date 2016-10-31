package com.bulrog.robot;


import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;

public class RobotFace {
    private final JLabel leftEye;
    private final JLabel rightEye;
    private final JLabel mouth;
    private final JLabel nose;
    private final JLabel leftEyeBrow;
    private final JLabel rightEyeBrow;
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
    public RobotFace(JPanel contentPanel) throws Exception{
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
