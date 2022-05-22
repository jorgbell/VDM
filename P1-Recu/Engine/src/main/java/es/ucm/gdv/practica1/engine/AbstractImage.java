package es.ucm.gdv.practica1.engine;

public abstract class AbstractImage implements Image{
    protected AbstractImage(String name){
        _filename = name;
    }

    @Override
    public int getWidth() {
        return _width;
    }

    @Override
    public int getHeight() {
        return _height;
    }

    protected String _filename;
    protected int _width = -1;
    protected int _height = -1;
}
