package container;

import project.quantum.cradle.storage.Path;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class Model {

    private XPDM resource;

    private Vector position;
    private List< Triangle > faces;

    public Model ( String resource , Vector position , List< Triangle > faces ) {

        this.resource = new XPDM( new File( ( Path.MODEL.getDescription() + resource ) ) );
        this.resource.load( XPDMCommand.TRIANGLE , XPDMCommand.MODEL );

        this.position = position;
        this.faces = faces;

        for ( XPDMSet set : this.resource.getData() ) {

            if ( set.getType().equals( XPDMCommand.MODEL ) ) {
                List< String > references = ( ( List< String > ) XPDMExtractor.extract( set , XPDMExtractor.ExtractionMode.STRING ) );

                for ( String element : references ) {



                }

                this.resource.getData().stream().filter( element -> set.getType().equals( XPDMCommand.TRIANGLE ) ).forEach( element -> {

                    Triangle triangle = new Triangle

                } );

            }

        }

    }

    public XPDM getResource () {

        return this.resource;

    }

    public Vector getPosition () {

        return this.position;

    }

    public List< Triangle > getFaces () {

        return this.faces;

    }

    public void move ( Vector vector ) {

        this.position = new Vector( ( vector.getX() + this.position.getX() ) , ( vector.getY() + this.position.getY() ) , ( vector.getZ() + this.position.getZ() ) );

    }

    public void teleport ( Vector position ) {

        this.position = position;

    }

}
