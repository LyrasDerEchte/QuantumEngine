package project.quantum;

public class WorldObject {

    private Vector position;

    public WorldObject () {

        this.position = new Vector( 0 , 0 , 0 );

    }

    public WorldObject ( Vector position ) {

        this.position = position;

    }

    public Vector getPosition () {

        return this.position;

    }

}
