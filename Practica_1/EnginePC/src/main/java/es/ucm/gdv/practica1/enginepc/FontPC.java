package es.ucm.gdv.practica1.enginepc;

import es.ucm.gdv.practica1.engine.Font;

public class FontPC implements Font {
    public FontPC(String f, int s, boolean b){ _filename = f; _size = s; _bold = b;}
    public FontPC(String f, int s, boolean b,java.awt.Font pcf){
        _filename = f; _size = s; _bold = b; setPCFont(pcf);
    }
    @Override
    public String getFileName() {
        return _filename;
    }

    @Override
    public int getSize() {
        return _size;
    }

    @Override
    public boolean isBold() {
        return _bold;
    }

    @Override
    public void setSize(int s) {
        _size = s;
    }

    @Override
    public void setBold(boolean b) {
        _bold = b;
    }

    public void setPCFont(java.awt.Font f){_pcFont = f;}
    public java.awt.Font getPCFont(){return _pcFont;}

    private java.awt.Font _pcFont;
    private String _filename;
    private int _size;
    private boolean _bold;
}
