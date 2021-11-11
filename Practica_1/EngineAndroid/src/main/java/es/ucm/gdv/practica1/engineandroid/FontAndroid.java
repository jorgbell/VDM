package es.ucm.gdv.practica1.engineandroid;

import android.graphics.Typeface;

import es.ucm.gdv.practica1.engine.Font;

public class FontAndroid implements Font {
    FontAndroid(String f, int s, boolean b, Typeface tf){
        _filename = f;
        _size = s;
        _bold = b;
        _androidFont = tf;
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
    public void setBold(boolean b) {
        _bold=b;
    }

    @Override
    public void setSize(int s) {
        _size=s;
    }

    public Typeface getAndroidFont(){
        return _androidFont;
    }

    private Typeface _androidFont;
    private String _filename;
    private int _size;
    private boolean _bold;
}
