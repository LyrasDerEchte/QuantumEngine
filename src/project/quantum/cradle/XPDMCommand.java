package project.quantum.cradle;

public enum XPDMCommand {

    UNDEFINED ( "099fcf2d-4fe2-454c-83e4-7c2b0874b08b" ) ,
    VERSION ( "#ver" ) ,
    TRIANGLE ( "#tri" ) ,
    MAP ( "#map" );

    private XPDMCommand ( String representation ) {

        this.representation = representation;

    }

    private String representation;

    public String getRepresentation () {

        return this.representation;

    }

    public static XPDMCommand get ( String command ) {

        for ( XPDMCommand element : XPDMCommand.values() ) {

            if ( command.startsWith( element.getRepresentation() ) ) {

                return element;

            }

        }

        return XPDMCommand.UNDEFINED;

    }

}
