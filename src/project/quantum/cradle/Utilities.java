package project.quantum.cradle;

import java.io.FileWriter;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

public class Utilities {

    public static class Number {

        public static float toFloat ( String value ) {

            try {

                return Float.parseFloat( value );

            } catch ( Exception exception ) {

                exception.printStackTrace();

            }

            return 0F;

        }

    }

    public static class IO {

        public static String toString ( java.io.File source ) {

            try {

                StringBuilder builder = new StringBuilder();

                java.nio.file.Files.lines( source.toPath() , StandardCharsets.UTF_8 ).forEach(element -> {

                    builder.append( element ).append( "\n" );

                } );

                return builder.toString();

            } catch ( Exception exception ) {

                exception.printStackTrace();

            }

            return "";

        }

        public static List< String > getContent ( java.io.File source ) {

            try {

                return java.nio.file.Files.readAllLines( source.toPath() );

            } catch ( Exception exception ) {

                exception.printStackTrace();

            }

            return new ArrayList< String >();

        }

        public static void write ( boolean append , java.io.File source , String ... content ) {

            try {

                PrintWriter writer = new PrintWriter( new FileWriter( source , append ) );

                for ( String element : content ) {

                    writer.write( element );
                    writer.write( "\n" );

                }

                writer.flush();
                writer.close();

            } catch ( Exception exception ) {

                exception.printStackTrace();

            }

        }

    }

}
