package project.engine.quantum;

public abstract class Primitive {

    protected Vector a;
    protected Vector b;
    protected Vector c;

    public Primitive ( Vector a , Vector b , Vector c ) {

        this.a = a;
        this.b = b;
        this.c = c;

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

    public void transform ( float[][] x , float[][] y , float[][] z ) {

        this.a.adapt( this.a.transform( x , y , z ) );
        this.b.adapt( this.b.transform( x , y , z ) );
        this.c.adapt( this.c.transform( x , y , z ) );

    }

    public void transform ( float[][] matrix ) {

        this.a.adapt( this.a.transform( matrix ) );
        this.b.adapt( this.b.transform( matrix ) );
        this.c.adapt( this.c.transform( matrix ) );

    }

    @Override
    public String toString () {

        return new String( "{a:" + this.a.toString() + ",b:" + this.b.toString() + ",c:" + this.c.toString() + "}" );

    }

}
