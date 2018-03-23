package project.quantum.cradle;

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

    /**
     * Extract nested values from "value" member.
     */
    public float[] extract () {

        try {

            if ( this.value.startsWith( "{" ) && this.value.endsWith( "}" ) ) {

                String[] containers = this.value.substring( 1 , ( this.value.length() - 1 ) ).split( ";" );

                if ( containers.length == 3 ) {

                    float[] data = new float[ 9 ];

                    for ( int i = 0; i < containers.length; i++ ) {

                        String container = containers[ i ];
                        String[] values = container.substring( 1 , ( container.length() - 1 ) ).split( "," );

                        for ( int j = 0; j < values.length; j++ ) {

                            String value = values[ j ];

                            if ( value.length() > 0 ) {

                                data[ ( 3 * i ) + j ] = Utilities.Number.toFloat( values[ j ] );

                            } else {

                                throw new IllegalStateException( "Not providing enough data." );

                            }

                        }

                    }

                    return data;

                } else {

                    throw new IllegalStateException( "Not providing three data containers." );

                }

            } else {

                throw new IllegalStateException( "Not using '{' and '}' for marking data containers." );

            }

        } catch ( Exception exception ) {

            exception.printStackTrace();

        }

        return new float[ 9 ];

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
