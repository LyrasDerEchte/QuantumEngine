package project.quantum.cradle;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class XPDM {

    private File source;

    private XPDMVersion version;
    private List< XPDMSet > data;

    public XPDM ( File source ) {

        this.source = source;

        this.version = XPDMVersion.UNDEFINED;
        this.data = new ArrayList< XPDMSet >();

    }

    public File getSource () {

        return this.source;

    }

    public XPDMVersion getVersion () {

        return this.version;

    }

    public List < XPDMSet > getData () {

        return this.data;

    }

    public void put ( XPDMSet data ) {

        Iterator iterator = this.data.iterator();

        while ( iterator.hasNext() ) {

            XPDMSet set = ( ( XPDMSet ) iterator.next() );

            if ( set.getToken().equals( data.getToken() ) ) {

                iterator.remove();

            }

        }

        this.data.add( data );

    }

    public void remove ( XPDMSet set ) {

        this.data.remove( set );

    }

    public void remove ( String token ) {

        Iterator iterator = this.data.iterator();

        while ( iterator.hasNext() ) {

            XPDMSet set = ( ( XPDMSet ) iterator.next() );

            if ( set.getToken().equals( token ) ) {

                iterator.remove();

            }

        }

    }

    public void load () {

        this.load( XPDMCommand.values() );

    }

    public void load ( XPDMCommand ... filter ) {

        //LOAD WITH FILTER

        out:
        for ( String element : Utilities.IO.getContent( this.source ) ) {

            if ( element.startsWith( "#" ) ) {

                XPDMCommand command = XPDMCommand.get( element );

                if ( ! command.equals( XPDMCommand.UNDEFINED ) ) {

                    if ( Arrays.asList( filter ).contains( command ) ) {

                        if ( command.equals( XPDMCommand.VERSION ) ) {

                            if ( this.version.equals( XPDMVersion.UNDEFINED ) ) {

                                this.version = XPDMVersion.get( element );

                            } else {

                                throw new IllegalStateException( "Setting version multiple times." );

                            }

                        } else if ( command.equals( XPDMCommand.TRIANGLE ) || command.equals( XPDMCommand.MAP ) ) {

                            XPDMSet set = new XPDMSet( command , element.substring( command.getRepresentation().length() + 1 , element.indexOf( ":" ) ) , element.substring( element.indexOf( ":" ) + 1 , element.length() ) );

                            for ( XPDMSet member : this.data ) {

                                if ( set.equals( member ) ) {

                                    continue out;

                                }

                            }

                            this.data.add( set );

                        }

                    }

                } else {

                    throw new IllegalStateException( "Command undefined." );

                }

            }

        }

    }

    public void save () {

        List< String > pool = new ArrayList< String >();

        for ( XPDMSet set : this.data ) {

            pool.add( ( set.getType().getRepresentation() + " " + set.toString() ) );

        }

        Utilities.IO.write( false , this.source , ( XPDMCommand.VERSION.getRepresentation() + " " + this.version.getRepresentation() ) );
        Utilities.IO.write( true , this.source , pool.toArray( new String[ pool.size() ] ) );

    }

}
