package project.quantum.lwjgl;

import org.lwjgl.BufferUtils;
import org.lwjgl.opengl.GL15;

import java.nio.FloatBuffer;

public class VBO extends Buffer {

    public VBO () {

        super( GL15.glGenBuffers() );

    }

    @Override
    public void bind () {

        GL15.glBindBuffer( GL15.GL_ARRAY_BUFFER , this.ID );

    }

    @Override
    public void unbind () {

        GL15.glBindBuffer( GL15.GL_ARRAY_BUFFER , 0 );

    }

    @Override
    public void push ( float ... data ) {

        float[] buffer = new float[ this.data.length + data.length ];

        for ( int i = 0; i < this.data.length; i++ ) {

            buffer[ i ] = this.data[ i ];

        }

        for ( int j = this.data.length; j < this.data.length + data.length; j++ ) {

            buffer[ j ] = data[ j - this.data.length ];

        }

        this.data = buffer;

        FloatBuffer wrapper = BufferUtils.createFloatBuffer( buffer.length );
        wrapper.put( buffer );
        wrapper.flip();

        GL15.glBufferData( GL15.GL_ARRAY_BUFFER , data , GL15.GL_STATIC_DRAW );

    }

    @Override
    public void delete () {

        GL15.glDeleteBuffers( this.ID );

    }

}
