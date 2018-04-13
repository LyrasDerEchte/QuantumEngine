package project.quantum;

import project.quantum.cradle.storage.Path;
import container.XPDM;
import container.XPDMCommand;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class World {

    private XPDM xpdm;

    private List<Model> matter;
    private String name;

    public World ( String label ) {

        this.xpdm = new XPDM( new File( Path.WORLD.getDescription() + label ) );
        this.xpdm.load( XPDMCommand.MAP , XPDMCommand.TRIANGLE , XPDMCommand.MODEL );

        this.matter = new ArrayList<>();

        this.load();

    }

    public XPDM getXPDM () {

        return this.xpdm;

    }

    public List<Model> getMatter () {

        return this.matter;

    }

    public String getName () {

        return this.name;

    }

    public void load () {

        this.xpdm.getData().stream().forEach( set -> {

            if ( set.getType().equals( XPDMCommand.MODEL ) ) {

                

            }

        } );

    }

//    public void load () {
//
//        this.xpdm.getResources().stream().forEach( set -> {
//
//            if ( set.getType().equals( XPDMCommand.TRIANGLE ) ) {
//
//                float[] extracted = set.extract();
//
//                if ( extracted.length == 9 ) {
//
//                    matter.add( new Triangle( new Vector( extracted[ 0 ] , extracted[ 1 ] , extracted[ 2 ] ) ,
//                                              new Vector( extracted[ 3 ] , extracted[ 4 ] , extracted[ 5 ] ) ,
//                                              new Vector( extracted[ 6 ] , extracted[ 7 ] , extracted[ 8 ] ) ) );
//
//                }
//
//            }
//
//        } );
//
//        System.out.println( this.matter.size() );
//
//    }

}
