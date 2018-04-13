package container;

public class XPDMSet {

    private XPDMCommand type;

    private String token;
    private String value;

    public XPDMSet ( String token , String value ) {

        this.type = XPDMCommand.MAP;

        this.token = token;
        this.value = value;

    }

    public XPDMSet ( XPDMCommand type , String token , String value ) {

        this.type = type;

        this.token = token;
        this.value = value;

    }

    public XPDMCommand getType () {

        return this.type;

    }

    public String getToken () {

        return this.token;

    }

    public String getValue () {

        return this.value;

    }

    @Override
    public String toString () {

        return ( token + ":" + value );

    }

    @Override
    public boolean equals ( Object object ) {

        if ( object instanceof XPDMSet ) {

            XPDMSet set = ( ( XPDMSet ) object );

            if ( set.toString().equals( this.toString() ) ) {

                return true;

            }

        }

        return false;

    }

}
