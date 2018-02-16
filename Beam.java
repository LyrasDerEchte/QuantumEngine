package project.engine.quantum;

public class Beam {

    private Vector origin;
    private Vector direction;

    public Beam ( Vector origin , Vector direction ) {

        this.origin = origin;
        this.direction = direction;

    }

    public Vector getOrigin () {

        return this.origin;

    }

    public Vector getDirection () {

        return this.direction;

    }

    public void setOrigin ( Vector origin ) {

        this.origin = origin;

    }

    public void setDirection ( Vector direction ) {

        this.direction = direction;

    }

    public Vector getPoint ( float alpha ) {

        return this.origin.add( this.direction.multiply( alpha ) );

    }

    public boolean intersects ( Face face ) {

        Beam transformed = this.transform( face.getMatrix() );

        float t = - ( transformed.getOrigin().getZ() / transformed.getDirection().getZ() );
        float alpha = ( transformed.getOrigin().getX() + ( t * transformed.getDirection().getX() ) );
        float beta = ( transformed.getOrigin().getY() + ( t * transformed.getDirection().getY() ) );

        return ( ( alpha >= 0 ) && ( alpha <= 1 ) ) && ( ( beta >= 0 ) && ( beta <= 1 ) ) && ( ( alpha + beta ) <= 1 );

    }

    public boolean intersects ( Mesh mesh ) {

        return mesh.intersects( this );

    }

    public Beam transform ( float[][] matrix ) {

        return new Beam( this.origin.transform( matrix ) , this.direction.transform( matrix ) );

    }

}