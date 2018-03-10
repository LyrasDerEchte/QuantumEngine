package project.engine.lwjgl.wrapper;

import org.lwjgl.Version;
import org.lwjgl.glfw.Callbacks;
import org.lwjgl.glfw.GLFW;
import org.lwjgl.glfw.GLFWErrorCallback;
import org.lwjgl.glfw.GLFWVidMode;
import org.lwjgl.system.MemoryStack;
import org.lwjgl.system.MemoryUtil;

import java.nio.IntBuffer;

public class LWJGL {

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

    public static class VSync {

        private static boolean enabled;

        public static void enable () {

            GLFW.glfwSwapInterval( 1 );
            VSync.enabled = true;

        }

        public static void disable () {

            GLFW.glfwSwapInterval( 0 );
            VSync.enabled = false;

        }

        public static boolean isEnabled () {

            return VSync.enabled;

        }

    }

    public static class Window {

        public static project.engine.lwjgl.wrapper.Window open ( boolean resizable , int width , int height , String title ) {

//            try {
//
//                project.engine.lwjgl.wrapper.Window window;
//
//                GLFWErrorCallback.createPrint( System.out ).set();
//
//                if ( LWJGL.isEnabled() ) {
//
//                    GLFW.glfwWindowHint( GLFW.GLFW_VISIBLE , GLFW.GLFW_FALSE );
//                    GLFW.glfwWindowHint( GLFW.GLFW_RESIZABLE , ( resizable ? GLFW.GLFW_TRUE : GLFW.GLFW_FALSE ) );
//
//                    window = new project.engine.lwjgl.wrapper.Window( GLFW.glfwCreateWindow( width , height , title , MemoryUtil.NULL , MemoryUtil.NULL ) );
//
//                    if ( window.getID() != MemoryUtil.NULL ) {
//
//                        GLFW.glfwSetKeyCallback( window.getID() , ( ID , key , scancode , action , modifications ) -> {
//
//                            if ( key == GLFW.GLFW_KEY_ESCAPE && action == GLFW.GLFW_RELEASE ) {
//
//                                GLFW.glfwSetWindowShouldClose( window.getID() , true );
//
//                            }
//
//                        } );
//
//                        try ( MemoryStack stack = MemoryStack.stackPush() ) {
//
//                            IntBuffer a = stack.mallocInt( 1 );
//                            IntBuffer b = stack.mallocInt( 1 );
//
//                            GLFW.glfwGetWindowSize( window.getID() , a , b );
//
//                            GLFWVidMode mode = GLFW.glfwGetVideoMode( GLFW.glfwGetPrimaryMonitor() );
//
//                            GLFW.glfwSetWindowPos( window.getID() , ( ( mode.width() - a.get( 0 ) ) / 2 ) , ( ( mode.height() - b.get( 0 ) ) / 2 ) );
//
//                        }
//
//                        GLFW.glfwMakeContextCurrent( window.getID() );
//
//                        LWJGL.VSync.disable();
//
//                        LWJGL.Window.show( window );
//
//                        return window;
//
//                    } else {
//
//                        throw new IllegalStateException( "GLFW has failed to create window." );
//
//                    }
//
//                } else {
//
//                    throw new IllegalStateException( "GLFW has to be initialized before using members." );
//
//                }
//
//            } catch ( Exception exception ) {
//
//                exception.printStackTrace();
//
//            }

            return null;

        }

        public static void close ( project.engine.lwjgl.wrapper.Window window ) {

            Callbacks.glfwFreeCallbacks( window.getID() );

            GLFW.glfwDestroyWindow( window.getID() );

            GLFW.glfwTerminate();

            GLFW.glfwSetErrorCallback( null ).free();

        }

        public static boolean isClosing ( project.engine.lwjgl.wrapper.Window window ) {

            return GLFW.glfwWindowShouldClose( window.getID() );

        }

    }

}
