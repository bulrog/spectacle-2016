package com.bulrog.spectacle;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class Squares extends JFrame
{
    public static void main ( String [] args ) throws Exception
    {
        Squares myframe = new Squares();
        myframe.setExtendedState(JFrame.MAXIMIZED_BOTH);
        myframe.setUndecorated(true);
//        myframe.setSize( 3000, 3000 );
        myframe.setResizable( true );
//        myframe.setLocationRelativeTo( null );
        myframe.setLayout( new GridLayout(3,3) );

        Container container = myframe.getContentPane();
        ArrayList< JPanel > components = new ArrayList < JPanel >();
        JPanel temp;

        // Populating Arraylist object.
        for ( int i = 0; i < 9; i++ )
        {
            temp = new JPanel();
            temp.setSize( 3,3 );
            components.add( temp );
            container.add(temp);
        }

        myframe.pack();
        myframe.setVisible( true );

        // Accessing components via index.
        components.get( 5 ).setBackground( Color.BLUE );
        components.get( 1 ).setBackground( Color.RED );
        components.get( 8 ).setBackground( Color.GREEN );
        for (int i=0;i<1000;i++){
            components.get( 1 ).setBackground( Color.BLACK );
            Thread.sleep(500);
            components.get( 1 ).setBackground( Color.RED );
            Thread.sleep(500);

        }
    }

}
