package es.ucm.gdv.practica1.engineandroid;

import android.content.res.AssetManager;
import android.graphics.Typeface;

import es.ucm.gdv.practica1.engine.Font;

public class FontAndroid implements Font {
    FontAndroid(String f, int s, boolean b, AssetManager ass){
        _filename = f;
        _size = s;
        _bold = b;
        _assetManager = ass;
        _androidFont = null;
        load();
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

    private void load(){
        try{
            _androidFont = Typeface.createFromAsset(_assetManager, _filename);
        } catch (Exception e) {
            System.err.println("Error cargando la fuente: " + e);
        }
    }

    public Typeface getAndroidFont(){
        return _androidFont;
    }

    private Typeface _androidFont;
    private String _filename;
    private AssetManager _assetManager;
    private int _size;
    private boolean _bold;
}
