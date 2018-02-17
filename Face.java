package project.engine.quantum;

public class Face {

    // Reference point for converting theoretical to absolute positions.
    private Vector reference;

    private Vector a;
    private Vector b;
    private Vector c;

    public Face ( Vector reference , Vector a , Vector b , Vector c ) {

        this.reference = reference;

        this.a = a;
        this.b = b;
        this.c = c;

    }

    public Face ( Vector a , Vector b , Vector c ) {

        this.reference = new Vector( 0 , 0 , 0 );

        this.a = a;
        this.b = b;
        this.c = c;

    }

    public Vector getReference () {

        return this.reference;

    }

    public Vector getA () {

        return this.a;

    }

    public Vector getB () {

        return this.b;

    }

    public Vector getC () {

        return this.c;

    }

    public void setReference ( Vector reference ) {

        this.reference = reference;

    }

    public void setA ( Vector a ) {

        this.a = a;

    }

    public void setB ( Vector b ) {

        this.b = b;

    }

    public void setC ( Vector c ) {

        this.c = c;

    }

    /**
     * Returning the face's normal.
     */
    public Vector getNormal () {

        return this.reference.add( this.b ).subtract( this.reference.add( this.a ) ).getCrossProduct( this.reference.add( this.c ).subtract( this.reference.add( this.a ) ) );

    }

    public boolean intersects ( Beam beam ) {

        return beam.intersects( this );

    }

    public boolean intersects ( Face face ) {

        return ( ( new Beam( this.a , this.b.subtract( this.a ) ).intersects( face ) && new Beam( this.b , this.a.subtract( this.b ) ).intersects( face ) ) || ( new Beam( this.a , this.c.subtract( this.a ) ).intersects( face ) && new Beam( this.c , this.a.subtract( this.c ) ).intersects( face ) ) || ( new Beam( this.c , this.b.subtract( this.c ) ).intersects( face ) && new Beam( this.b , this.c.subtract( this.b ) ).intersects( face ) ) );

    }

    public boolean intersects ( Mesh mesh ) {

        return mesh.intersects( this );

    }

    @Override
    public String toString () {

        return new String( "[" + this.a.toString() + "," + this.b.toString() + "," + this.c.toString() + "]" );

    }

}