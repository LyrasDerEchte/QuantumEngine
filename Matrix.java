package project.engine.quantum;

public class Matrix {

    public static float[][] get ( Axis axis , float angle ) {

        float[][] matrix = new float[ 3 ][ 3 ];
        float alpha = Math.toRadians( angle );

        if ( axis.equals( Axis.X ) ) {

            matrix[ 0 ][ 0 ] = 1F;
            matrix[ 0 ][ 1 ] = 0F;
            matrix[ 0 ][ 2 ] = 0F;

            matrix[ 1 ][ 0 ] = 0F;
            matrix[ 1 ][ 1 ] = Math.cos( alpha );
            matrix[ 1 ][ 2 ] = - Math.sin( alpha );

            matrix[ 2 ][ 0 ] = 0F;
            matrix[ 2 ][ 1 ] = Math.sin( alpha );
            matrix[ 2 ][ 2 ] = Math.cos( alpha );

        } else if ( axis.equals( Axis.Y ) ) {

            matrix[ 0 ][ 0 ] = Math.cos( alpha );
            matrix[ 0 ][ 1 ] = 0F;
            matrix[ 0 ][ 2 ] = Math.sin( alpha );

            matrix[ 1 ][ 0 ] = 0F;
            matrix[ 1 ][ 1 ] = 1F;
            matrix[ 1 ][ 2 ] = 0F;

            matrix[ 2 ][ 0 ] = - Math.sin( alpha );
            matrix[ 2 ][ 1 ] = 0F;
            matrix[ 2 ][ 2 ] = Math.cos( alpha );

        } else if ( axis.equals( Axis.Z ) ) {

            matrix[ 0 ][ 0 ] = Math.cos( alpha );
            matrix[ 0 ][ 1 ] = - Math.sin( alpha );
            matrix[ 0 ][ 2 ] = 0F;

            matrix[ 1 ][ 0 ] = Math.sin( alpha );
            matrix[ 1 ][ 1 ] = Math.cos( alpha );
            matrix[ 1 ][ 2 ] = 0F;

            matrix[ 2 ][ 0 ] = 0F;
            matrix[ 2 ][ 1 ] = 0F;
            matrix[ 2 ][ 2 ] = 1F;

        }

        return matrix;

    }

}