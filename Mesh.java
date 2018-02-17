package project.engine.quantum;

import java.util.List;

public class Mesh {

    private Vector origin;
    private List < Face > faces;

    private float pitch;
    private float yaw;

    public Mesh ( Vector origin , List < Face > faces ) {

        this.origin = origin;
        this.faces = faces;

        this.pitch = 0F;
        this.yaw = 0F;

    }

    public Vector getOrigin () {

        return this.origin;

    }

    public List < Face > getFaces () {

        return this.faces;

    }

    public float getPitch () {

        return this.pitch;

    }

    public float getYaw () {

        return this.yaw;

    }

    public void teleport ( Vector origin ) {

        this.origin.adapt( origin );

    }

    /**
     * Rotates the mesh around a given axis and the origin as a reference point.
     */
    public void rotate ( Axis axis , float angle ) {

        if ( axis.equals( Axis.Y ) ) {

            this.yaw += angle;

        } else {

            this.pitch += angle;

        }

        float[][] matrix = Matrix.get( axis , angle );

        for ( Face face : this.faces ) {

            face.getA().adapt( face.getA().transform( matrix ) );
            face.getB().adapt( face.getB().transform( matrix ) );
            face.getC().adapt( face.getC().transform( matrix ) );

        }

    }

    /**
     * Rotates the mesh around the origin of a cartesian coordinate system using yaw and a calculated ratio between pitch and roll
     * for the maximum of simplicity for rotating an object.
     */
    public void rotate ( float pitch , float yaw ) {

        this.pitch += pitch;
        this.yaw += yaw;

        float alpha = ( pitch * Math.cos( this.yaw ) );
        float beta = ( pitch * Math.sin( this.yaw ) );

        float[][] x = Matrix.get( Axis.X , alpha );
        float[][] y = Matrix.get( Axis.Y , yaw );
        float[][] z = Matrix.get( Axis.Z , beta );

        for ( Face face : this.faces ) {

            face.getA().adapt( face.getA().transform( y ) );
            face.getB().adapt( face.getB().transform( y ) );
            face.getC().adapt( face.getC().transform( y ) );

            face.getA().adapt( face.getA().transform( x ) );
            face.getB().adapt( face.getB().transform( x ) );
            face.getC().adapt( face.getC().transform( x ) );

            face.getA().adapt( face.getA().transform( z ) );
            face.getB().adapt( face.getB().transform( z ) );
            face.getC().adapt( face.getC().transform( z ) );

        }
    }

    public void expand ( float alpha ) {

        this.faces.parallelStream().forEach( face -> {

            face.getA().adapt( face.getA().multiply( alpha ) );
            face.getB().adapt( face.getB().multiply( alpha ) );
            face.getC().adapt( face.getC().multiply( alpha ) );

        } );

    }

    public void shrink ( float alpha ) {

        this.expand( ( 1F / alpha ) );

    }

    public boolean contains ( Vector point ) {

        Beam beam = new Beam( point , Math.getRandomVector() );

        return ( ( this.faces.parallelStream().filter( face -> beam.intersects( face ) ).count() % 2 ) != 0 );

    }

    public boolean intersects ( Beam beam ) {

        return ( this.faces.parallelStream().filter( face -> beam.intersects( face ) ).count() > 0 );

    }

    public boolean intersects ( Face face ) {

        return ( this.faces.parallelStream().filter( element -> element.intersects( face ) ).findFirst().orElse( null ) != null );

    }

    public boolean intersects ( Mesh mesh ) {

        return ( this.faces.parallelStream().filter( face -> ( mesh.faces.parallelStream().filter( element -> element.intersects( face ) ).count() >= 1 ) ).count() >= 1 );

    }

}