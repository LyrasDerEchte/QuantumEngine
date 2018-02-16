package project.engine.quantum;

import java.util.Random;

public class Math {

    public static final Random RANDOM = new Random();

    public static float getDouble () {

        return ( RANDOM.nextFloat() * ( RANDOM.nextBoolean() ? 1F : -1F ) );

    }

    /**
     * Returns a random normalized vector.
     */
    public static Vector getRandomVector () {

        return new Vector( Math.getDouble() , Math.getDouble() , Math.getDouble() ).normalize();

    }

    public static boolean isFloat ( Object object ) {

        try {

            Float.parseFloat( String.valueOf( object ) );

        } catch ( NumberFormatException exception ) {

            return false;

        }

        return true;

    }

    public static float toFloat ( Object object ) {

        return Float.parseFloat( String.valueOf( object ) );

    }

    public static float sin ( float angle ) {

        return ( float ) java.lang.Math.sin( angle );

    }

    public static float cos ( float angle ) {

        return ( float ) java.lang.Math.cos( angle );

    }

}