package project.engine.quantum;

public class Face {

    // Reference point for converting theoretical to absolute positions.
    private Vector reference;

    private Vector a;
    private Vector b;
    private Vector c;

    private float matrix[][];

    public Face ( Vector reference , Vector a , Vector b , Vector c ) {

        this.reference = reference;

        this.a = a;
        this.b = b;
        this.c = c;

        this.matrix = new float[ 3 ][ 3 ];

        this.update();

    }

    public Face ( Vector a , Vector b , Vector c ) {

        this.reference = new Vector( 0 , 0 , 0 );

        this.a = a;
        this.b = b;
        this.c = c;

        this.matrix = new float[ 3 ][ 3 ];

        this.update();

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

    public float[][] getMatrix () {

        return this.matrix;

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

    /**
     * Updates every necessary variable.
     * In this case just the transformation matrix that depends on the current vertices.
     */
    public void update () {

        this.matrix = Matrix.get( Matrix.Type.INTERSECTION , this.getNormal().normalize() , this.b.subtract( this.a ) , this.b.subtract( this.c ) , this.a , this.b , this.c );

    }

    public boolean intersects ( Beam beam ) {

        return beam.intersects( this );

    }

    public boolean intersects ( Face face ) {

        if ( this.intersects( new Beam( face.getA() , face.getB().subtract( face.getA() ) ) ) || this.intersects( new Beam( face.getB() , face.getA().subtract( face.getB() ) ) ) || this.intersects( new Beam( face.getA() , face.getC().subtract( face.getA() ) ) ) || this.intersects( new Beam( face.getC() , face.getA().subtract( face.getC() ) ) ) || this.intersects( new Beam( face.getB() , face.getC().subtract( face.getB() ) ) ) || this.intersects( new Beam( face.getC() , face.getB().subtract( face.getC() ) ) ) ) {

            return true;

        }

        return false;

    }

    public boolean intersects ( Mesh mesh ) {

        return ( mesh.getFaces().parallelStream().filter( face -> this.intersects( face ) ).findFirst().orElse( null ) != null );

    }

    @Override
    public String toString () {

        return new String( "[" + this.a.toString() + "," + this.b.toString() + "," + this.c.toString() + "]" );

    }

}