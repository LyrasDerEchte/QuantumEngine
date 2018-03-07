package project.engine.quantum;

import java.awt.image.BufferedImage;
import java.awt.image.DataBufferInt;
import java.util.Arrays;

public class Application {

    private static Window window;
    private static BufferedImage image;

    private static Junction junction;
    private static Camera camera;

    private static Face[] faces;
    private static Mesh mesh;

    private static long time;
    private static long FPS;

    public static void main ( String[] arguments ) {

        window = new Window( 500 , 500 , "Big Shaq: The Game" );
        image = new BufferedImage ( 500 , 500 , BufferedImage.TYPE_INT_RGB );

        junction = new Junction( new Vector( -1 , 1 , 1 ) , new Vector( 1 , 1 , 1 ) , new Vector( -1 , -1 , 1 ) , 500 , 500 );

        System.out.println( junction.toString() );

        camera = new Camera( new Vector( 0 , 0F , 0 ) , 0F , 0F , junction );

        faces = new Face[]{ new Face( new Vector( -1 , 1 , 2 ) , new Vector( 1 , 1 , 2 ) , new Vector( -1 , -1 ,2 ) , new Vector( 0 , 0 , 0 ) , 0xFF7788 ) ,
                new Face( new Vector( 1 , -1 , 2 ) , new Vector( 1 , 1 , 2 ) , new Vector( -1 , -1 ,2 ) , new Vector( 0 , 0 , 0 ) , 0xFF7788 ) ,
                new Face( new Vector( -1 , 1 , 3 ) , new Vector( 1 , 1 , 3 ) , new Vector( -1 , -1 , 3 ) , new Vector( 0 , 0 ,0 ) , 0xFFFF88 ) ,
                new Face( new Vector( 1 ,  -1 , 3 ) , new Vector( 1 , 1 , 3 ) , new Vector( -1 , -1 , 3 ) , new Vector( 0 , 0 , 0 ) , 0xFFFF88 ) ,
        };

        mesh = new Mesh( new Vector( 0 , 0 , 0 ) , Arrays.asList( faces ) );

        render();

    }

    public static void render () {

        time = System.currentTimeMillis();

        while ( true ) {

//            mesh.rotate( Axis.Y , 0.5F );

            FPS++;

            for ( int y = 0; y < junction.getHeight(); y++ ) {

                for ( int x = 0; x < junction.getWidth(); x++ ) {

                    int index = ( y * junction.getWidth() ) + x;

                    Vector position = junction.getPosition( x , y );
                    Beam beam = new Beam( camera.getPosition() , position.subtract( camera.getPosition() ) );

                    ( ( DataBufferInt ) image.getRaster().getDataBuffer() ).getData()[ index ] = 0x000000;

                    for ( Face face : mesh.getFaces() ) {

                        if ( beam.intersects( face ) ) {

                            ( ( DataBufferInt ) image.getRaster().getDataBuffer() ).getData()[ index ] = face.getColor();

                        }

                    }

                }

            }

            window.render( image );

            if ( System.currentTimeMillis() - time >= 1000 ) {

                System.out.println( "FPS: " + FPS );
                time = System.currentTimeMillis();

                FPS = 0;

            }

        }

    }

}