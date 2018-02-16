package project.engine.quantum;

public class Application {

    /**
     * TODO:
     *
     *          Convert 3x3 rotation matrix to 3x4
     *          Get intersection algorithm to working
     *
     */

    public static void main ( String[] arguments ) {

        Face face = new Face( new Vector( 0 , 0, 0 ) , new Vector( 0 , 0 , 0  ) , new Vector( 1 , 0 , 0 ) , new Vector( 0 , 0 , 1 ) );

        Beam beam = new Beam( new Vector( 0.1F , -0.1F , 0.1F ) , new Vector( 0F , 1F , 0F ) );

        System.out.println( "Intersection: " + beam.intersects( face ) );

    }

}