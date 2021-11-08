package es.ucm.gdv.practica1.enginepc;

import es.ucm.gdv.practica1.engine.Font;

public class FontPC extends Font {
    public FontPC(String f, int s, boolean b){ super( f, s,b);}
    public void setPCFont(java.awt.Font f){_pcFont = f;}
    protected java.awt.Font _pcFont;
}
