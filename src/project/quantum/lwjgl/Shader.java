package project.quantum.lwjgl;

import org.lwjgl.opengl.GL20;
import project.quantum.cradle.Utilities;

import java.io.File;

/**
 * "Shader" is a wrapper for a shader source.
 */
public class Shader extends LWJGLObject {

    private String source;
    private ShaderType type;

    public Shader ( String source , int type ) {

        super( GL20.glCreateShader( type ) );

        this.source = source;
        this.type = ShaderType.get( type );

        GL20.glShaderSource( this.ID , Utilities.IO.toString( new File( source ) ) );
        GL20.glCompileShader( this.ID );

    }

    public String getSource () {

        return this.source;

    }

    public ShaderType getType () {

        return this.type;

    }

    public void delete () {

        GL20.glDeleteShader( this.ID );

    }

}
