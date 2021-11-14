package es.ucm.gdv.practica1.enginepc;

import java.io.FileInputStream;
import java.io.InputStream;

import es.ucm.gdv.practica1.engine.Font;

public class FontPC implements Font {
    public FontPC(String f, int s, boolean b){
        _filename = f; _size = s; _bold = b; _pcFont = null; load();
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

    @Override
    public void load(){
        java.awt.Font baseFont;
        try (InputStream is = new FileInputStream(_filename)) {
            baseFont = java.awt.Font.createFont(java.awt.Font.TRUETYPE_FONT, is);
            _pcFont = baseFont.deriveFont(java.awt.Font.BOLD, 40);
        }
        catch (Exception e) {
            // Ouch. No está.
            System.err.println("Error cargando la fuente: " + e);
        }
    }
    public java.awt.Font getPCFont(){return _pcFont;}

    private java.awt.Font _pcFont;
    private String _filename;
    private int _size;
    private boolean _bold;
}
