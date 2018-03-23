package project.quantum.lwjgl;

import org.lwjgl.opengl.GL20;

public class ShaderProgram extends LWJGLObject {

    public ShaderProgram ( Shader ... shaders ) {

        super ( GL20.glCreateProgram() );

        for ( Shader shader : shaders ) {

            GL20.glAttachShader( this.ID , shader.getID() );

        }

        GL20.glLinkProgram( this.ID );
        GL20.glValidateProgram( this.ID );

    }

    public void use () {

        GL20.glUseProgram( this.ID );

    }

    public void delete () {

        GL20.glDeleteProgram( this.ID );

    }

}
