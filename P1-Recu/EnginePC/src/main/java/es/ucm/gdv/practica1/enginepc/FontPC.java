package es.ucm.gdv.practica1.enginepc;

import java.awt.Font;
import java.io.FileInputStream;
import java.io.InputStream;

import es.ucm.gdv.practica1.engine.AbstractFont;

public class FontPC extends AbstractFont {
    FontPC(String f, int s, boolean b){
        super(f,s,b);
        load();
    }

    @Override
    public void load() {
        java.awt.Font baseFont;
        try (InputStream is = new FileInputStream(_filename)) {
            baseFont = java.awt.Font.createFont(java.awt.Font.TRUETYPE_FONT, is);
            _font = baseFont.deriveFont(java.awt.Font.BOLD, _size); //40
        }
        catch (Exception e) {
            // Ouch. No está.
            System.err.println("Error cargando la fuente: " + e);
        }
    }

    public Font get_font() {
        return _font;
    }

    //VARIABLES
    java.awt.Font _font;
}
