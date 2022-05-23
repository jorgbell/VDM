package es.ucm.gdv.practica1.engineandroid;

import android.content.res.AssetManager;
import android.graphics.Typeface;

import java.io.FileInputStream;
import java.io.InputStream;

import es.ucm.gdv.practica1.engine.AbstractFont;

//añadir un abstractFonts si fuera necesario, por ahora creo que no lo sera
public class FontAndroid extends AbstractFont {
    FontAndroid(String f, int s, boolean b, AssetManager ass){
        super(f,s,b);
        _assetManager = ass;
        load();
    }

    @Override
    public void load() {
        try{
            _font = Typeface.createFromAsset(_assetManager, _filename);
        }
        catch (Exception e) {
            // Ouch. No está.
            System.err.println("Error cargando la fuente: " + e);
        }
    }

    public Typeface get_font() {
        return _font;
    }

    //VARIABLES
    Typeface _font;
    AssetManager _assetManager;
}
