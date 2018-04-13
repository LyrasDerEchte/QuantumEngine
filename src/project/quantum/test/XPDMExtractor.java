package container;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class XPDMExtractor {

    public static Object extract ( XPDMSet target , ExtractionMode mode ) {

        try {

            if ( target.getValue().startsWith( "{" ) && target.getValue().startsWith( "}" ) ) {

                String[] raw = target.getValue().substring( 1 , ( target.getValue().length() - 1 ) ).split( "," );

                if ( mode.equals( ExtractionMode.FLOAT ) ) {

                    List< Float > result = new ArrayList<>();

                    for ( int i = 0; i < raw.length; i++ ) {

                        result.add( Float.parseFloat( raw[ i ] ) );

                    }

                    return result;

                } else if ( mode.equals( ExtractionMode.STRING ) ) {

                    return Arrays.asList( raw );

                }

            } else {

                throw new IllegalStateException( "No obvious limiting of data." );

            }

        } catch ( IllegalStateException exception ) {

            exception.printStackTrace();

        }

        return null;

    }

    public enum ExtractionMode {

        FLOAT () ,
        STRING ();

    }

}
