package es.ucm.gdv.practica1.engine;

public abstract class AbstractFont implements Font{
    protected AbstractFont(String f, int s, boolean b){
        _filename = f;
        _size = s;
        _bold = b;
    }


    public int get_size() {
        return _size;
    }
    public boolean is_bold(){
        return _bold;
    }

    //VARIABLES
    protected String _filename;
    protected int _size;
    protected boolean _bold;
}
