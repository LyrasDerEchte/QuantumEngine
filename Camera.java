package project.engine.quantum;

public class Camera {

    private Vector position;

    private float pitch;
    private float yaw;

    private Junction junction;

    public Camera ( Vector position , float pitch , float yaw , Junction junction ) {

        this.position = position;

        this.junction = junction;

        this.rotate( pitch , yaw );

    }

    public Vector getPosition () {

        return this.position;

    }

    public float getPitch () {

        return this.pitch;

    }

    public float getYaw () {

        return this.yaw;

    }

    public Junction getJunction () {

        return this.junction;

    }

    public void move ( Vector direction ) {

        this.position.adapt( this.position.add( direction ) );

        this.junction.getA().adapt( this.junction.getA().add( direction ) );
        this.junction.getB().adapt( this.junction.getB().add( direction ) );
        this.junction.getC().adapt( this.junction.getC().add( direction ) );

    }

    public void rotate ( float pitch , float yaw ) {

        this.pitch += pitch;
        this.yaw += yaw;

        float[][] x = Matrix.get( Axis.X , ( pitch * Math.cos( this.yaw ) ) );
        float[][] y = Matrix.get( Axis.Y , yaw );
        float[][] z = Matrix.get( Axis.Z , ( pitch * Math.sin( this.yaw ) ) );

        this.junction.getA().adapt( this.junction.getA().subtract( this.position ).transform( x , y , z ).add( this.position ) );
        this.junction.getB().adapt( this.junction.getB().subtract( this.position ).transform( x , y , z ).add( this.position ) );
        this.junction.getC().adapt( this.junction.getC().subtract( this.position ).transform( x , y , z ).add( this.position ) );

    }

    @Override
    public String toString () {

        return new String( "{position:" + this.position.toString() + ",pitch:" + this.pitch + ",yaw:" + this.yaw + ",junction:" + this.junction.toString() + "}" );

    }

}
