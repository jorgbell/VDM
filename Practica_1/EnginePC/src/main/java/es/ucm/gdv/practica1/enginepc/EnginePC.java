package es.ucm.gdv.practica1.enginepc;
import java.awt.Graphics;

import es.ucm.gdv.practica1.engine.Engine;
import es.ucm.gdv.practica1.engine.Game;
import es.ucm.gdv.practica1.engine.Input;
import es.ucm.gdv.practica1.enginepc.GraphicsPC;
import es.ucm.gdv.practica1.enginepc.InputPC;


//clase que tendrá los métodos de ciclo de vida de java
public class EnginePC implements Engine {
    public EnginePC(Game g){
        _myPCGame = g;
        _myPCGame.setEngine(this);
        init();
    }
    @Override
    public es.ucm.gdv.practica1.engine.Graphics getGraphics() {
        return _myPCGraphics;
    }

    @Override
    public Input getInput() {
        return _myPCInput;
    }

    public boolean init(){
        _lastFrameTime = System.nanoTime();
        _myPCGraphics = new GraphicsPC("ventana", 400,400);
        _myPCInput = new InputPC();
        if(!_myPCGraphics.init() || !_myPCInput.init() || !_myPCGame.init())
            return false;

        return true;
    }

    @Override
    public void runEngine(){
        while(true){
            _myPCGame.update(getDeltaTime()); //actualiza la logica del juego
            do {
                do {
                    java.awt.Graphics g = _myPCGraphics.getDrawGraphics();
                    try {
                        _myPCGame.render(); //pinta lo que el juego vaya a pintar en ese frame
                    }
                    finally {
                        g.dispose();
                    }
                } while(_myPCGraphics.getStrategy().contentsRestored());
                _myPCGraphics.getStrategy().show();
            } while(_myPCGraphics.getStrategy().contentsLost());


            //pillar input, npi de como es
        }
    }

    @Override
    public double getDeltaTime() {
        long currentTime = System.nanoTime();
        long nanoElapsedTime = currentTime - _lastFrameTime;
        _lastFrameTime = currentTime;
        double elapsedTime = (double) nanoElapsedTime / 1.0E9;
        return elapsedTime;
    }

    private GraphicsPC _myPCGraphics;
    private InputPC _myPCInput;
    private Game _myPCGame;
    private long _lastFrameTime;

}