package project.engine.lwjgl.wrapper;

import org.lwjgl.glfw.Callbacks;
import org.lwjgl.glfw.GLFW;
import org.lwjgl.glfw.GLFWErrorCallback;
import org.lwjgl.glfw.GLFWVidMode;
import org.lwjgl.system.MemoryStack;
import org.lwjgl.system.MemoryUtil;

import java.nio.IntBuffer;

public class Window extends OpenGLObject {

    private boolean opened;

    public Window () {

        super ( -1L );

    }

    public boolean isOpened () {

        return this.opened;

    }

    public boolean isHaunted () {

        try {

            if ( this.ID != -1 ) {

                return GLFW.glfwWindowShouldClose( this.ID );

            } else {

                throw new IllegalStateException( "Window has not been buffered yet." );

            }

        } catch ( Exception exception ) {

            exception.printStackTrace();

        }

        return false;

    }

    public void show () {

        try {

            if ( this.ID != -1 ) {

                GLFW.glfwShowWindow( this.getID() );

            } else {

                throw new IllegalStateException( "Window has not been buffered yet." );

            }

        } catch ( Exception exception ) {

            exception.printStackTrace();

        }

    }

    public void hide () {

        try {

            if ( this.ID != -1 ) {

                GLFW.glfwHideWindow( this.getID() );

            } else {

                throw new IllegalStateException( "Window has not been buffered yet." );

            }

        } catch ( Exception exception ) {

            exception.printStackTrace();

        }

    }

    public void open ( boolean resizable , int width , int height , String title , boolean sync ) {

        try {

            if ( ! this.isOpened() ) {

                GLFWErrorCallback.createPrint( System.out ).set();

                if ( LWJGL.isEnabled() ) {

                    GLFW.glfwWindowHint( GLFW.GLFW_VISIBLE , GLFW.GLFW_FALSE );
                    GLFW.glfwWindowHint( GLFW.GLFW_RESIZABLE , ( resizable ? GLFW.GLFW_TRUE : GLFW.GLFW_FALSE ) );

                    this.ID =  GLFW.glfwCreateWindow( width , height , title , MemoryUtil.NULL , MemoryUtil.NULL );

                    if ( this.ID != MemoryUtil.NULL ) {

                        try ( MemoryStack stack = MemoryStack.stackPush() ) {

                            IntBuffer a = stack.mallocInt( 1 );
                            IntBuffer b = stack.mallocInt( 1 );

                            GLFW.glfwGetWindowSize( this.ID , a , b );

                            GLFWVidMode mode = GLFW.glfwGetVideoMode( GLFW.glfwGetPrimaryMonitor() );

                            GLFW.glfwSetWindowPos( this.ID , ( ( mode.width() - a.get( 0 ) ) / 2 ) , ( ( mode.height() - b.get( 0 ) ) / 2 ) );

                        }

                        GLFW.glfwMakeContextCurrent( this.ID );

                        if ( sync ) {

                            LWJGL.VSync.enable();

                        } else {

                            LWJGL.VSync.disable();

                        }

                        this.show();

                        this.opened = true;

                    } else {

                        throw new IllegalStateException( "GLFW has failed to create window." );

                    }

                } else {

                    throw new IllegalStateException( "GLFW has to be initialized before using members." );

                }

            } else {

                throw new IllegalStateException( "Window must be closed before opening it again." );

            }

        } catch ( Exception exception ) {

            exception.printStackTrace();

        }

    }

    public void close () {

        try {

            if ( this.ID != -1 ) {

                Callbacks.glfwFreeCallbacks( this.ID );

                GLFW.glfwDestroyWindow( this.ID );
                GLFW.glfwTerminate();
                GLFW.glfwSetErrorCallback( null ).free();

            } else {

                throw new IllegalStateException( "Window has not been buffered yet." );

            }

        } catch ( Exception exception ) {

            exception.printStackTrace();

        }

    }

}
