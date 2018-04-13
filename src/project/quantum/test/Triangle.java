package container;

public class Triangle {

    private Vector a;
    private Vector b;
    private Vector c;

    private int color;

    public Triangle ( float[] data ) {

        this.a = new Vector( data[ 0 ] , data[ 1 ] , data[ 2 ] );
        this.b = new Vector( data[ 3 ] , data[ 4 ] , data[ 5 ] );
        this.c = new Vector( data[ 6 ] , data[ 7 ] , data[ 8 ] );

        this.color = ( ( int ) data[ 9 ] );

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

    public int getColor () {

        return this.color;

    }

}
