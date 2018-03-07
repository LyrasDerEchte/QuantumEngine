package project.engine.quantum;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

public class Window extends Canvas {

    private int width;
    private int height;

    private JFrame frame;

    public Window ( int width , int height , String title ) {

        this.width = width;
        this.height = height;

        this.frame = new JFrame();

        this.frame.setTitle( title );
        this.frame.setSize( new Dimension( width , height ) );
        this.frame.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
        this.frame.setResizable( true );
        this.frame.setVisible( true );
        this.frame.add( this );
        this.frame.setLocationRelativeTo( null );

        this.requestFocus();

    }

    public int getWidth () {

        return this.width;

    }

    public int getHeight () {

        return this.height;

    }

    public JFrame getFrame () {

        return this.frame;

    }

    public void render ( BufferedImage image ) {

        if ( this.getBufferStrategy() == null ) {

            this.createBufferStrategy( 3 );

        }

        ( ( Graphics2D ) this.getBufferStrategy().getDrawGraphics() ).drawImage( image , null , 0 , 0 );
        this.getBufferStrategy().show();

    }

}
