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
            double deltaTime = getDeltaTime();
            _myGame.update(deltaTime);
            _myGame.getInput();
            _myGraphics.render(_myGame);
        }
    }


}
