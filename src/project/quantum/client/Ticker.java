package project.quantum.client;

public class Ticker {

    private static Thread thread;

    public static void run () {

        Ticker.thread = new Thread( () -> {

            long stamp = System.currentTimeMillis();

            while ( Game.isRunning() ) {

                if ( System.currentTimeMillis() - stamp >= 1 ) {

                    stamp = System.currentTimeMillis();

                    //TICK

                }

            }

            Game.stop();

        } );

        thread.start();

    }

    public static Thread getThread () {

        return Ticker.thread;

    }

}
