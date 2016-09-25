package com.bulrog.spectacle;
import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;

public class AbsoluteLayoutExample
{
    private void displayGUI()
    {
        JFrame frame = new JFrame("Absolute Layout Example");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel contentPane = new JPanel();
        contentPane.setOpaque(true);
        contentPane.setBackground(Color.WHITE);
        contentPane.setLayout(null);


        BufferedImage image = null;
        try
        {
            image = ImageIO.read(new File("TheVoice.png"));
            image=image.getSubimage(300,300,300,200);
        }
        catch (Exception e)
        {
            e.printStackTrace();
            System.exit(1);
        }
        ImageIcon imageIcon = new ImageIcon(image);
        JLabel jLabel = new JLabel();
        jLabel.setIcon(imageIcon);
        jLabel.setSize(300,200);
        jLabel.setLocation(200,200);


        contentPane.add(jLabel);

        frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        frame.setContentPane(contentPane);
//        frame.setSize(310, 125);
        frame.setLocationByPlatform(true);
        frame.setVisible(true);
    }

    public static void main(String... args)
    {
        SwingUtilities.invokeLater(new Runnable()
        {
            public void run()
            {
                new AbsoluteLayoutExample().displayGUI();
            }
        });
    }
}