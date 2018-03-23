package project.quantum.lwjgl;

public abstract class Buffer extends LWJGLObject {

    protected float[] data;

    public Buffer ( int ID ) {

        super( ID );

        this.data = new float[ 0 ];

    }

    public float[] getData () {

        return this.data;

    }

    public abstract void bind ();

    public abstract void unbind ();

    public abstract void push ( float ... data );

    public abstract void delete ();

}
