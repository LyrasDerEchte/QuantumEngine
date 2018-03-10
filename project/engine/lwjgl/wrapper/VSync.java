package project.engine.lwjgl.wrapper;

import org.lwjgl.glfw.GLFW;

public class VSync {

    private static boolean enabled;

    public static void enable () {

        GLFW.glfwSwapInterval( 1 );
        VSync.enabled = false;

    }

    public static void disable () {

        GLFW.glfwSwapInterval( 0 );
        VSync.enabled = false;

    }

    public static boolean isEnabled () {

        return VSync.enabled;

    }

}
