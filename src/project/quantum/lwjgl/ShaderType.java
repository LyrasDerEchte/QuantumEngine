package project.quantum.lwjgl;

import org.lwjgl.opengl.GL20;

public enum ShaderType {

    UNDEFINED ( "d2aeda8c-9b4a-45a4-86eb-13c6caadf37c" , 0 ) ,
    VERTEX ( "vertex" , GL20.GL_VERTEX_SHADER ) ,
    FRAGMENT ( "fragment" , GL20.GL_FRAGMENT_SHADER );

    private ShaderType ( String representation , int value ) {

        this.representation = representation;
        this.value = value;

    }

    private String representation;
    private int value;

    public String getRepresentation () {

        return this.representation;

    }

    public int getValue () {

        return this.value;

    }

    public static ShaderType get ( String representation ) {

        for ( ShaderType element : ShaderType.values() ) {

            if ( element.getRepresentation().equals( representation ) ) {

                return element;

            }

        }

        return ShaderType.UNDEFINED;

    }

    public static ShaderType get ( int value ) {

        for ( ShaderType element : ShaderType.values() ) {

            if ( element.getValue() == value ) {

                return element;

            }

        }

        return ShaderType.UNDEFINED;

    }

}
