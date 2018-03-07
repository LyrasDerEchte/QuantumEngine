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

        Vector alpha = face.getB().subtract( face.getA() );
        Vector beta = face.getC().subtract( face.getA() );
        Vector gamma = this.direction.getCrossProduct( beta );

        float a = ( 1F / alpha.getDotProduct( gamma ) );

        Vector delta = this.origin.subtract( face.getA() );

        float b = ( a * delta.getDotProduct( gamma ) );

        if ( b >= 0F && b <= 1F ) {

            Vector epsilon = delta.getCrossProduct( alpha );

            float c = ( a * this.direction.getDotProduct( epsilon ) );

            if ( c >= 0F ) {

                if ( ( b + c ) <= 1F ) {

                    return true;

                }

            }

        }

        return false;

    }

    public boolean intersects ( Mesh mesh ) {

        return mesh.intersects( this );

    }

    @Override
    public String toString () {

        return new String( "{origin:" + this.origin.toString() + ",direction:" + this.direction.toString() + "}" );

    }

}