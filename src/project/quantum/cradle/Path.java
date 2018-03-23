package project.quantum.cradle;

public enum Path {

    SHADER ( "res/shader/" );

    private Path ( String description ) {

        this.description = description;

    }

    private String description;

    public String getDescription () {

        return this.description;

    }

}
