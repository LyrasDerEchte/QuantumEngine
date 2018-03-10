package project.engine.lwjgl.wrapper;

public class OpenGLObject {

    protected long ID;

    public OpenGLObject ( long ID ) {

        this.ID = ID;

    }

    public long getID () {

        return this.ID;

    }

}
