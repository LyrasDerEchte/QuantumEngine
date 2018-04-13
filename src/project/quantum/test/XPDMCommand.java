package container;

public enum XPDMCommand {

    UNDEFINED ( "099fcf2d-4fe2-454c-83e4-7c2b0874b08b" ) ,
    VERSION ( "#ver" ) ,
    TRIANGLE ( "#tri" ) ,
    MODEL ( "#mdl" ) ,
    MAP ( "#map" );

    XPDMCommand ( String depiction ) {

        this.depiction = depiction;

    }

    private String depiction;

    public String getDepiction () {

        return this.depiction;

    }

    public static XPDMCommand get ( String command ) {

        for ( XPDMCommand element : XPDMCommand.values() ) {

            if ( command.startsWith( element.getDepiction() ) ) {

                return element;

            }

        }

        return XPDMCommand.UNDEFINED;

    }

}
