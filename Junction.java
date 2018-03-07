package project.engine.quantum;

public class Junction extends Primitive {

    private int width;
    private int height;

    public Junction ( Vector a , Vector b , Vector c , int width , int height ) {

        super( a , b , c );

        this.width = width;
        this.height = height;

    }

    public int getWidth () {

        return this.width;

    }

    public int getHeight () {

        return this.height;

    }

    public Vector getPosition ( int x , int y ) {

        return this.a.add( this.b.subtract( this.a ).multiply( ( 1F / ( ( float ) this.width ) ) ).multiply( ( ( float ) x ) ).add( this.c.subtract( this.a ).multiply( ( 1F / ( ( float ) this.height ) ) ).multiply( ( ( float ) y ) ) ) );

    }

    @Override
    public String toString () {

        return new String( "{a:" + this.a.toString() + ",b:" + this.b.toString() + ",c:" + this.c.toString() + ",width:" + this.width + ",height:" + this.height + "}" );

    }

}
