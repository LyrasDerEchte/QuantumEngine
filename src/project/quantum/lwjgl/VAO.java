package project.quantum.lwjgl;

import org.lwjgl.opengl.GL30;

public class VAO extends Buffer {

    private Assigner assigner;

    public VAO () {

        super( GL30.glGenVertexArrays() );

    }

    public VAO ( Assigner assigner ) {

        super( GL30.glGenVertexArrays() );

        this.assigner = assigner;

    }

    public Assigner getAssigner () {

        return this.assigner;

    }

    @Override
    public void bind () {

        GL30.glBindVertexArray( this.ID );

    }

    @Override
    public void unbind () {

        GL30.glBindVertexArray( 0 );

    }

    @Deprecated
    @Override
    public void push ( float ... data ) {

        return;

    }

    @Override
    public void delete () {

        GL30.glDeleteVertexArrays( this.ID );

    }

    public void assign () {

        this.assigner.assign();

    }

}
