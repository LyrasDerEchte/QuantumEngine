package project.quantum.cradle;

public enum XPDMVersion {

    UNDEFINED ( "611d94c8-6b1a-4c71-a3c5-5ff81c839fb2" ) ,
    ALPHA ( "alpha" );

    private XPDMVersion ( String representation ) {

        this.representation = representation;

    }

    private String representation;

    public String getRepresentation () {

        return this.representation;

    }

    public static XPDMVersion get ( String version ) {

        for ( XPDMVersion element : XPDMVersion.values() ) {

            if ( element.getRepresentation().equals( version.replaceAll( ( XPDMCommand.VERSION.getRepresentation() + " " ) , "" ) ) ) {

                return element;

            }

        }

        return XPDMVersion.UNDEFINED;

    }

}
