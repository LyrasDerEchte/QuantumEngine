package project.engine.quantum;

import java.lang.Math;

public class Vector {

    private float x;
    private float y;
    private float z;
    private float w;

    public Vector ( float x , float y , float z ) {

        this.x = x;
        this.y = y;
        this.z = z;
        this.w = 1F;

    }

    public float getX () {

        return this.x;

    }

    public float getY () {

        return this.y;

    }

    public float getZ () {

        return this.z;

    }

    public float getW () {

        return this.w;

    }

    public void setX ( float x ) {

        this.x = x;

    }

    public void setY ( float y ) {

        this.y = y;

    }

    public void setZ ( float z ) {

        this.z = z;

    }

    public void setW ( float w ) {

        this.w = w;

    }

    public Vector normalize () {

        float magnitude = this.getMagnitude();

        return new Vector( ( this.x / magnitude ) , ( this.y / magnitude ) , ( this.z / magnitude ) );

    }

    public Vector add ( Vector vector ) {

        return new Vector( ( this.x + vector.getX() ) , ( this.y + vector.getY() ) , ( this.z + vector.getZ() ) );

    }

    public Vector subtract ( Vector vector ) {

        return new Vector( ( this.x - vector.getX() ) , ( this.y - vector.getY() ) , ( this.z - vector.getZ() ) );

    }

    public Vector multiply ( float value ) {

        return new Vector( ( this.x * value ) , ( this.y * value ) , ( this.z * value ) );

    }

    /**
     * Replaces the current coordinates with the ones from the given vector.
     * Can be used to update coordinates while not removing the pointer of this
     * object by overriding it with another.
     */
    public void adapt ( Vector vector ) {

        this.x = vector.getX();
        this.y = vector.getY();
        this.z = vector.getZ();

    }

    public float getMagnitude () {

        return ( float ) Math.sqrt( ( this.x * this.x ) + ( this.y * this.y ) + ( this.z * this.z ) );

    }

    public Vector getCrossProduct ( Vector vector ) {

        return new Vector( ( ( this.y * vector.z ) - ( this.z * vector.y ) ) , ( ( this.z * vector.x ) - ( this.x * vector.z ) ) , ( ( this.x * vector.y ) - ( this.y * vector.x ) ) );

    }

    public float getDotProduct ( Vector vector ) {

        return ( ( this.x * vector.getX() ) + ( this.y * vector.getY() ) + ( this.z * vector.getZ() ) );

    }

    public Vector transform ( float[][] matrix ) {

        if ( matrix.length == 3 && matrix[ 0 ].length == 4 ) {

            return new Vector( ( ( matrix[ 0 ][ 0 ] * this.x ) + ( matrix[ 0 ][ 1 ] * this.y ) + ( matrix[ 0 ][ 2 ] * this.z ) + ( matrix[ 0 ][ 3 ] * this.w ) ) , ( ( matrix[ 1 ][ 0 ] * this.x ) + ( matrix[ 1 ][ 1 ] * this.y ) + ( matrix[ 1 ][ 2 ] * this.z ) + ( matrix[ 1 ][ 3 ] * this.w ) ) , ( ( matrix[ 2 ][ 0 ] * this.x ) + ( matrix[ 2 ][ 1 ] * this.y ) + ( matrix[ 2 ][ 2 ] * this.z ) + ( matrix[ 2 ][ 3 ] * this.w ) ) );

        }

        return null;

    }

    @Override
    public boolean equals ( Object other ) {

        if ( other instanceof Vector ) {

            Vector vector = ( Vector ) other;

            if ( this.x == vector.getX() && this.y == vector.getY() && this.z == vector.getZ() ) {

                return true;

            }

        }

        return false;

    }

    @Override
    public String toString () {

        return new String( "[" + this.x + "," + this.y + "," + this.z + "," + this.getMagnitude() + "]" );

    }

}