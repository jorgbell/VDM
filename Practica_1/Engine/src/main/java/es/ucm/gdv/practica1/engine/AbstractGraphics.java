package es.ucm.gdv.practica1.engine;

import es.ucm.gdv.practica1.engine.Graphics;

public abstract class AbstractGraphics implements Graphics{
    //esta clase tendrá los métodos relacionados con el reescalado y las bandas blancas
    public AbstractGraphics(){

    }

    @Override
    public boolean init() {
        return true;
    }
}
