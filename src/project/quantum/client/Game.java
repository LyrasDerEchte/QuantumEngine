package project.quantum.client;

import org.lwjgl.opengl.GL11;
import org.lwjgl.opengl.GL20;
import project.quantum.lwjgl.*;

public class Game {

    private static Window window;

    private static VBO vbo;
    private static VAO vao;

    private static ShaderProgram program;

    private static boolean running;

    public static void main ( String[] arguments ) {

        Game.start();

    }

    public static Window getWindow () {

        return Game.window;

    }

    public static VBO getVBO () {

        return Game.vbo;

    }

    public static VAO getVAO () {

        return Game.vao;

    }

    public static ShaderProgram getShader () {

        return Game.program;

    }

    public static boolean isRunning () {

        return Game.running;

    }

    public static void start () {

        if ( ! Game.running ) {

            Game.running = true;

            //LWJGL
            LWJGL.enable();

            //Window
            Game.window = new Window();
            Game.window.open( true , 600 , 600 , "Big Shaq: The Game" , false );

            //Buffer
            Game.vbo = new VBO();
            Game.vbo.bind();

            Game.vao = new VAO( () -> {

                GL20.glVertexAttribPointer( 0 , 3 , GL11.GL_FLOAT , false , ( 3 * 4 ) , 0 );

            } );

            Game.vao.bind();
            Game.vao.assign();

            //Shader
            ShaderLoader.load();

            Game.program = new ShaderProgram( ShaderLoader.getCardfile().toArray( new Shader[ ShaderLoader.getCardfile().size() ] ) );
            Game.program.use();

            for ( Shader shader : ShaderLoader.getCardfile() ) {

                shader.delete();

            }

            //Run
            Ticker.run();
            Renderer.run();

        }

    }

    public static void stop () {

        try {

            if ( Game.running ) {

                Game.running = false;

                Ticker.getThread().interrupt();

                Game.program.delete();

                Game.vbo.delete();
                Game.vao.delete();

                Game.window.close();

            }

        } catch ( Exception exception ) {

            exception.printStackTrace();

        }

    }

}
