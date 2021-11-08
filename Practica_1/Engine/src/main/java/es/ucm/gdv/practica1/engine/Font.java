package es.ucm.gdv.practica1.engine;

//TODO
public class Font {
    public Font(String f, int s, boolean b){ _filename = f; _size = s; _bold = b;}

    public String getFileName(){return _filename ;}
    public int getSize(){return _size ;}
    public boolean isBold(){return _bold ;}

    private String _filename;
    private int _size;
    private boolean _bold;
}
