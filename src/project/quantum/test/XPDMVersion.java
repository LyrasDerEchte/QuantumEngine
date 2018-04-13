package container;

public enum XPDMVersion {

    UNDEFINED ( "611d94c8-6b1a-4c71-a3c5-5ff81c839fb2" ) ,
    ALPHA ( "alpha" );

    private XPDMVersion ( String depiction ) {

        this.depiction = depiction;

    }

    private String depiction;

    public String getDepiction () {

        return this.depiction;

    }

    public static XPDMVersion get ( String version ) {

        for ( XPDMVersion element : XPDMVersion.values() ) {

            if ( element.getDepiction().equals( version.replaceAll( ( XPDMCommand.VERSION.getDepiction() + " " ) , "" ) ) ) {

                return element;

            }

        }

        return XPDMVersion.UNDEFINED;

    }

}
