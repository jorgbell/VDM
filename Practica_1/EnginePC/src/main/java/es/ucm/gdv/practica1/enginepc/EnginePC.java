package es.ucm.gdv.practica1.enginepc;
import java.awt.Graphics;

import es.ucm.gdv.practica1.engine.Engine;
import es.ucm.gdv.practica1.engine.FloatPair;
import es.ucm.gdv.practica1.engine.Game;
import es.ucm.gdv.practica1.engine.Input;
import es.ucm.gdv.practica1.enginepc.GraphicsPC;
import es.ucm.gdv.practica1.enginepc.InputPC;


//clase que tendrá los métodos de ciclo de vida de java
public class EnginePC implements Engine {
    public EnginePC(Game g, int wWidth,int wHeight,int gWidth,int gHeight){
        _myPCGame = g;
        _myPCGame.setEngine(this);
        FloatPair wSize = new FloatPair(wWidth,wHeight);
        FloatPair gSize = new FloatPair(gWidth, gHeight);
        _myPCGraphics = new GraphicsPC("0hn0!",wSize, gSize);
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
        if(!_myPCGraphics.init() || !_myPCGame.init())
            return false;
        _myPCInput = new InputPC(_myPCGraphics);
        return true;
    }

    public void run(){
        while(true){
            _myPCGame.getInput();
            _myPCGame.update(getDeltaTime()); //actualiza la logica del juego
            _myPCGraphics.render(_myPCGame);
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