package project.quantum.client;

import org.lwjgl.glfw.GLFW;
import org.lwjgl.opengl.GL11;
import org.lwjgl.opengl.GL20;

public class Renderer {

    public static void run () {

        GL11.glClearColor( 1F , 1F , 1F , 1F );

        while ( Game.isRunning() ) {

            GL11.glClear( GL11.GL_COLOR_BUFFER_BIT );

            Game.getVAO().bind();

            GL20.glEnableVertexAttribArray( 0 );
            GL11.glDrawArrays( GL11.GL_TRIANGLES , 0 , Game.getVBO().getData().length / 3 );
            GL20.glDisableVertexAttribArray( 0 );

            Game.getVAO().unbind();

            GLFW.glfwSwapBuffers( Game.getWindow().getID() );
            GLFW.glfwPollEvents();

        }

        Game.stop();

    }

}