package es.ucm.gdv.practica1.enginepc;

import java.awt.Graphics;

import es.ucm.gdv.practica1.engine.AbstractEngine;
import es.ucm.gdv.practica1.engine._Game;

public class _EnginePC extends AbstractEngine {
    public _EnginePC(_Game g, String title, int w, int h, EnginePaths p){
        super(g, new _GraphicsPC(title, w, h, p), new _InputPC(), p);
        _myGame.setEngine(this);
        init();
    }

    @Override
    public void run() {
        if(!_running)
            _running = true;
        while(_running){
            //ESTO ANTES LO PONIA EN UN METODO "RENDER" DESDE PCGRAPHICS.
            //NO SE SI ESTO DEBERIA IR AQUI

            do {
                do {
                    Graphics g = ((_GraphicsPC) _myGraphics)._bufferStrategy.getDrawGraphics();
                    ((_GraphicsPC) _myGraphics)._jGraphics = g; //variable en PCGraphics
                    try {
                        //_myGraphics.clearWindow();
                        //_myGraphics.reScale(); //hace clear para crear las bandas del color bg
                        _myGame.run(); //input, update, render
                    }
                    finally {
                        g.dispose();
                    }
                } while(((_GraphicsPC) _myGraphics)._bufferStrategy.contentsRestored());
                ((_GraphicsPC) _myGraphics)._bufferStrategy.show();
            } while(((_GraphicsPC) _myGraphics)._bufferStrategy.contentsLost());


        }

    }


}
