package com.bulrog.robot.impl;


import com.bulrog.robot.Sprite;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class SpriteImpl implements Sprite {
    private final List<Icon> images;

    public SpriteImpl(String fileName,int sizeX, int sizeY) throws Exception{
        images=new ArrayList<>();
        BufferedImage image = ImageIO.read(new File(fileName));
        int offsetX=0;
        int offsetY=0;
        while (offsetY+sizeY<=image.getHeight()){
            images.add(new ImageIcon(image.getSubimage(offsetX,offsetY,sizeX,sizeY)));
            offsetX+=sizeX;
            if (offsetX>=image.getWidth()){
                offsetX=0;
                offsetY+=sizeY;
            }
        }

    }

    @Override
    public Icon getFrame(int i) {
        return images.get(i%images.size());
    }
}
