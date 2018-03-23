package project.quantum.lwjgl;

import project.quantum.cradle.Path;
import project.quantum.cradle.XPDM;
import project.quantum.cradle.XPDMCommand;
import project.quantum.cradle.XPDMSet;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class ShaderLoader {

    private static final List< Shader > CARDFILE = new ArrayList< Shader >();

    public static List< Shader > getCardfile () {

        return ShaderLoader.CARDFILE;

    }

    public static void load () {

        XPDM source = new XPDM( new File( Path.SHADER.getDescription() + "mapping.xpdm" ) );
        source.load( XPDMCommand.MAP );

        for ( XPDMSet set : source.getData() ) {

            ShaderLoader.CARDFILE.add( new Shader( ( Path.SHADER.getDescription() + set.getValue() ) , ShaderType.get( set.getToken() ).getValue() ) );

        }

    }

}
