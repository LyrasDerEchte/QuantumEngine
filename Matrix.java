package project.engine.quantum;

public class Matrix {

    public static float[][] get ( Type type , Object ... parameters ) {

        float[][] matrix = new float[ 3 ][ 4 ];

        if ( type.equals( Type.ROTATION ) ) {

            if ( parameters.length == 2 ) {

                if ( parameters[ 0 ] instanceof Axis ) {

                    Axis axis = ( Axis ) parameters[ 0 ];

                    if ( Math.isFloat( parameters[ 1 ] ) ) {

                        float angle = - Math.toFloat( parameters[ 1 ] );

                        if ( axis.equals( Axis.X ) ) {

                            matrix[ 0 ][ 0 ] = 1F;
                            matrix[ 0 ][ 1 ] = 0F;
                            matrix[ 0 ][ 2 ] = 0F;

                            matrix[ 1 ][ 0 ] = 0F;
                            matrix[ 1 ][ 1 ] = Math.cos( angle );
                            matrix[ 1 ][ 2 ] = - Math.sin( angle );

                            matrix[ 2 ][ 0 ] = 0F;
                            matrix[ 2 ][ 1 ] = Math.sin( angle );
                            matrix[ 2 ][ 2 ] = Math.cos( angle );

                        } else if ( axis.equals( Axis.Y ) ) {

                            matrix[ 0 ][ 0 ] = Math.cos( angle );
                            matrix[ 0 ][ 1 ] = 0F;
                            matrix[ 0 ][ 2 ] = Math.sin( angle );

                            matrix[ 1 ][ 0 ] = 0F;
                            matrix[ 1 ][ 1 ] = 1F;
                            matrix[ 1 ][ 2 ] = 0F;

                            matrix[ 2 ][ 0 ] = - Math.sin( angle );
                            matrix[ 2 ][ 1 ] = 0F;
                            matrix[ 2 ][ 2 ] = Math.cos( angle );

                        } else if ( axis.equals( Axis.Z ) ) {

                            matrix[ 0 ][ 0 ] = Math.cos( angle );
                            matrix[ 0 ][ 1 ] = - Math.sin( angle );
                            matrix[ 0 ][ 2 ] = 0F;

                            matrix[ 1 ][ 0 ] = Math.sin( angle );
                            matrix[ 1 ][ 1 ] = Math.cos( angle );
                            matrix[ 1 ][ 2 ] = 0F;

                            matrix[ 2 ][ 0 ] = 0F;
                            matrix[ 2 ][ 1 ] = 0F;
                            matrix[ 2 ][ 2 ] = 1F;

                        }

                    }

                }

            }

        } else if ( type.equals( Type.INTERSECTION ) ) {

            if ( parameters.length == 6 ) {

                if ( parameters[ 0 ] instanceof Vector && parameters[ 1 ] instanceof Vector && parameters[ 2 ] instanceof Vector && parameters[ 3 ] instanceof Vector && parameters[ 4 ] instanceof Vector && parameters[ 5 ] instanceof Vector ) {

                    Vector normal = ( Vector ) parameters[ 0 ];

                    Vector alpha = ( Vector ) parameters[ 1 ];
                    Vector beta = ( Vector ) parameters[ 2 ];

                    Vector gamma = ( Vector ) parameters[ 3 ];
                    Vector delta = ( Vector ) parameters[ 4 ];
                    Vector epsilon = ( Vector ) parameters[ 5 ];

                    if ( normal.getX() >= normal.getY() && normal.getX() >= normal.getZ() ) {

                        matrix[ 0 ][ 0 ] = 0F;
                        matrix[ 0 ][ 1 ] = ( beta.getZ() / normal.getX() );
                        matrix[ 0 ][ 2 ] = - ( beta.getY() / normal.getX() );
                        matrix[ 0 ][ 3 ] = ( epsilon.getCrossProduct( gamma ).getX() / normal.getX() );

                        matrix[ 1 ][ 0 ] = 0F;
                        matrix[ 1 ][ 1 ] = - ( alpha.getZ() / normal.getX() );
                        matrix[ 1 ][ 2 ] = ( alpha.getY() / normal.getX() );
                        matrix[ 1 ][ 3 ] = - ( delta.getCrossProduct( gamma ).getX() / normal.getX() );

                        matrix[ 2 ][ 0 ] = 1F;
                        matrix[ 2 ][ 1 ] = ( normal.getY() / normal.getX() );
                        matrix[ 2 ][ 2 ] = ( normal.getZ() / normal.getX() );
                        matrix[ 2 ][ 3 ] = - ( normal.getDotProduct( gamma ) / normal.getX() );

                    } else if ( normal.getY() >= normal.getZ() ) {

                        matrix[ 0 ][ 0 ] = - ( beta.getZ() / normal.getY() );
                        matrix[ 0 ][ 1 ] = 0F;
                        matrix[ 0 ][ 2 ] = ( beta.getX() / normal.getY() );
                        matrix[ 0 ][ 3 ] = ( epsilon.getCrossProduct( gamma ).getY() / normal.getY() );

                        matrix[ 1 ][ 0 ] = ( alpha.getZ() / normal.getY() );
                        matrix[ 1 ][ 1 ] = 0F;
                        matrix[ 1 ][ 2 ] = - ( alpha.getX() / normal.getY() );
                        matrix[ 1 ][ 3 ] = - ( delta.getCrossProduct( gamma ).getY() / normal.getY() );

                        matrix[ 2 ][ 0 ] = ( normal.getX() / normal.getY() );
                        matrix[ 2 ][ 1 ] = 1F;
                        matrix[ 2 ][ 2 ] = ( normal.getZ() / normal.getY() );
                        matrix[ 2 ][ 3 ] = - ( normal.getDotProduct( gamma ) / normal.getY() );

                    } else {

                        matrix[ 0 ][ 0 ] = ( beta.getY() / normal.getZ() );
                        matrix[ 0 ][ 1 ] = - ( beta.getX() / normal.getZ() );
                        matrix[ 0 ][ 2 ] = 0F;
                        matrix[ 0 ][ 3 ] = ( epsilon.getCrossProduct( gamma ).getZ() / normal.getZ() );

                        matrix[ 1 ][ 0 ] = - ( alpha.getY() / normal.getZ() );
                        matrix[ 1 ][ 1 ] = ( alpha.getX() / normal.getZ() );
                        matrix[ 1 ][ 2 ] = 0F;
                        matrix[ 1 ][ 3 ] = - ( delta.getCrossProduct( gamma ).getZ() / normal.getZ() );

                        matrix[ 2 ][ 0 ] = ( normal.getX() / normal.getZ() );
                        matrix[ 2 ][ 1 ] = ( normal.getY() / normal.getZ() );
                        matrix[ 2 ][ 2 ] = 1F;
                        matrix[ 2 ][ 3 ] = - ( normal.getDotProduct( gamma ) / normal.getZ() );

                    }

                }

            }

        }

        return matrix;

    }

    public enum Type {

        ROTATION () ,
        INTERSECTION ();

    }

}