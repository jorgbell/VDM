package es.ucm.gdv.practica1.engine;
//implementación común del motor independiente de la plataforma
public abstract class AbstractEngine implements _Engine{

    protected AbstractEngine(_Game game, _Graphics g, Input i){
        _myGame = game;
        _myGraphics = g;
        _myInput = i;
    }

    @Override
    public boolean init() {
        _lastFrameTime = System.nanoTime();
        if(!_myGraphics.init() || !_myGame.init() || !_myGraphics.setInputListener(_myInput))
            return false;
        return true;
    }

    @Override
    public boolean stop() {
        _running = false;
        return true;
    }

    @Override
    public double getDeltaTime() {
        long currentTime = System.nanoTime();
        long nanoElapsedTime = currentTime - _lastFrameTime;
        _lastFrameTime = currentTime;
        double elapsedTime = (double) nanoElapsedTime / 1.0E9;
        return elapsedTime;
    }

    @Override
    public _Graphics getGraphics() {
        return _myGraphics;
    }

    @Override
    public Input getInput() {
        return _myInput;
    }

    //variables
    protected _Graphics _myGraphics; //o abstractGraphics
    protected _Game _myGame;
    protected Input _myInput;
    protected long _lastFrameTime;
    protected volatile boolean _running = false;
}
