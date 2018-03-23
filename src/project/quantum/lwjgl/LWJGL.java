package project.quantum.lwjgl;

import org.lwjgl.opengl.*;

import org.lwjgl.Version;
import org.lwjgl.glfw.GLFW;

public abstract class LWJGL {

    private static boolean enabled;

    public static String getVersion () {

        return Version.getVersion();

    }

    public static void enable () {

        try {

            LWJGL.enabled = GLFW.glfwInit();

            if ( ! LWJGL.isEnabled() ) {

                throw new IllegalStateException( "GLFW couldn't be initialized." );

            }

        } catch ( Exception exception ) {

            exception.printStackTrace();

        }

    }

    public static boolean isEnabled () {

        return LWJGL.enabled;

    }

    public static void draw () {

        GL11.glDrawArrays( GL11.GL_TRIANGLES , 0 , 3 );

    }

}
