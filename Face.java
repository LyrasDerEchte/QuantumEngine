package project.engine.quantum;

public class Face extends Primitive {

    private Vector transformer;

    private int color = 0xFFFFFFFF;

    public Face ( Vector a , Vector b , Vector c , Vector transformer , int color  ) {

        super( a , b , c );

        this.transformer = transformer;

        this.color = color;

    }

    public Vector getTransformer () {

        return this.transformer;

    }

    public int getColor () {

        return this.color;

    }

    public void setTransformer ( Vector transformer ) {

        this.transformer = transformer;

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

    public void setColor ( int color ) {

        this.color = color;

    }

    /**
     * Returning the face's normal.
     */
    public Vector getNormal () {

        return this.transformer.add( this.b ).subtract( this.transformer.add( this.a ) ).getCrossProduct( this.transformer.add( this.c ).subtract( this.transformer.add( this.a ) ) );

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

        return new String( "{a:" + this.a.toString() + ",b:" + this.b.toString() + ",c:" + this.c.toString() + ",transformer:" + this.transformer.toString() + ",color:" + this.color + "}" );

    }

}