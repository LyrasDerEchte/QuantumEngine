package project.engine.quantum;

public class Vector {

    private float x;
    private float y;
    private float z;

    public Vector ( float x , float y , float z ) {

        this.x = x;
        this.y = y;
        this.z = z;

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

    public void setX ( float x ) {

        this.x = x;

    }

    public void setY ( float y ) {

        this.y = y;

    }

    public void setZ ( float z ) {

        this.z = z;

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

        this.x = ( ( vector.getX() > Math.THRESHOLD || vector.getX() < - Math.THRESHOLD ) ? vector.getX() : 0F );
        this.y = ( ( vector.getY() > Math.THRESHOLD || vector.getY() < - Math.THRESHOLD ) ? vector.getY() : 0F );
        this.z = ( ( vector.getZ() > Math.THRESHOLD || vector.getZ() < - Math.THRESHOLD ) ? vector.getZ() : 0F );

    }

    public float getMagnitude () {

        return Math.sqrt( ( this.x * this.x ) + ( this.y * this.y ) + ( this.z * this.z ) );

    }

    public Vector getCrossProduct ( Vector vector ) {

        return new Vector( ( ( this.y * vector.z ) - ( this.z * vector.y ) ) , ( ( this.z * vector.x ) - ( this.x * vector.z ) ) , ( ( this.x * vector.y ) - ( this.y * vector.x ) ) );

    }

    public float getDotProduct ( Vector vector ) {

        return ( ( this.x * vector.getX() ) + ( this.y * vector.getY() ) + ( this.z * vector.getZ() ) );

    }

    public Vector transform ( float[][] matrix ) {

        if ( matrix.length == 3 && matrix[ 0 ].length == 3 ) {

            return new Vector( ( ( matrix[ 0 ][ 0 ] * this.x ) + ( matrix[ 0 ][ 1 ] * this.y ) + ( matrix[ 0 ][ 2 ] * this.z ) ) , ( ( matrix[ 1 ][ 0 ] * this.x ) + ( matrix[ 1 ][ 1 ] * this.y ) + ( matrix[ 1 ][ 2 ] * this.z ) ) , ( ( matrix[ 2 ][ 0 ] * this.x ) + ( matrix[ 2 ][ 1 ] * this.y ) + ( matrix[ 2 ][ 2 ] * this.z )) );

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

        return new String( "[" + this.x + "," + this.y + "," + this.z + "]" );

    }

}