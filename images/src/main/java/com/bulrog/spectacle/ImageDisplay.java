package com.bulrog.spectacle;


import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;

public class ImageDisplay {
    public static void main(String[] args) throws Exception{
        System.out.println(Toolkit.getDefaultToolkit().getScreenSize());
        imageDemo("/tmp/TheVoice.png");
    }
    public static void imageDemo(final String filename) throws Exception
    {
        SwingUtilities.invokeLater(new Runnable()
        {
            public void run()
            {
                JFrame editorFrame = new JFrame("Image Demo");
                editorFrame.setExtendedState(JFrame.MAXIMIZED_BOTH);
                editorFrame.setUndecorated(true);
                editorFrame.setResizable( true );

                editorFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

                BufferedImage image = null;
                try
                {
                    image = ImageIO.read(new File(filename));
                    image=image.getSubimage(0,0,1000,500);
                }
                catch (Exception e)
                {
                    e.printStackTrace();
                    System.exit(1);
                }
                ImageIcon imageIcon = new ImageIcon(image);
                JLabel jLabel = new JLabel();
                jLabel.setIcon(imageIcon);
                editorFrame.getContentPane().add(jLabel, BorderLayout.CENTER);

                editorFrame.pack();
                editorFrame.setLocationRelativeTo(null);
                editorFrame.setVisible(true);
            }
        });
    }
}
