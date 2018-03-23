package project.quantum.lwjgl;

public abstract class LWJGLObject {

    protected int ID;

    public LWJGLObject(int ID ) {

        this.ID = ID;

    }

    public int getID () {

        return this.ID;

    }

}
