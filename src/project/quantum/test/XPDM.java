package container;

import project.quantum.cradle.Utilities;
import project.quantum.cradle.exception.FileFormatException;
import project.quantum.cradle.storage.FileExtension;

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

        try {

            if ( source.getName().endsWith( FileExtension.XPDM.getDepiction() ) ) {

                this.source = source;

                this.version = XPDMVersion.UNDEFINED;
                this.data = new ArrayList<>();

            } else {

                throw new FileFormatException( source.getName() , FileExtension.XPDM );

            }

        } catch ( FileFormatException exception ) {

            exception.printStackTrace();

        }

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

    public String pull ( String token ) {

        return this.data.stream().filter( set -> set.getToken().equals( token ) ).findFirst().orElse( new XPDMSet( "" , "" ) ).getValue();

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

        //Actual Filter
        List< XPDMCommand > raster = Arrays.asList( filter );
        raster.add( XPDMCommand.VERSION );

        //Iterate
        outer:
        for ( String element : Utilities.IO.getContent( this.source ) ) {

            //Filter
            if ( element.startsWith( "#" ) ) {


                //Extract
                XPDMCommand command = XPDMCommand.get( element );

                if ( ! command.equals( XPDMCommand.UNDEFINED ) ) {

                    //Filter
                    if ( raster.contains( command ) ) {

                        if ( command.equals( XPDMCommand.VERSION ) ) {

                            if ( this.version.equals( XPDMVersion.UNDEFINED ) ) {

                                this.version = XPDMVersion.get( element );

                            }

                        } else if ( command.equals( XPDMCommand.MAP ) || command.equals( XPDMCommand.TRIANGLE ) || command.equals( XPDMCommand.MODEL ) ) {

                            XPDMSet set = new XPDMSet( command , element.substring( ( command.getDepiction().length() + 1 ) , element.indexOf( ":" ) ) , element.substring( ( element.indexOf( ":" ) + 1 ) , element.length() ) );

                            for ( XPDMSet member : this.data ) {

                                if ( set.equals( member ) ) {

                                    continue outer;

                                }

                            }

                            this.data.add( set );

                        }

                    }

                }

            }

        }

    }

    public void save () {

        List< String > pool = new ArrayList<>();

        this.data.stream().forEach( set -> {

            pool.add( ( set.getType().getDepiction() + " " + set.toString() ) );

        } );

        Utilities.IO.write( false , this.source , ( XPDMCommand.VERSION.getDepiction() + " " + this.version.getDepiction() ) );
        Utilities.IO.write( true , this.source , pool.toArray( new String[ pool.size() ] ) );

    }

}
