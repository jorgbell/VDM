package es.ucm.gdv.practica1.engine;
//implementación común del motor independiente de la plataforma
public abstract class AbstractEngine implements _Engine{

    public static class EnginePaths{
        public EnginePaths(String r, String i, String f){
            _rootPath = r;
            _imagesPath = i;
            _fontsPath = f;
        }
        public String _rootPath;
        public String _imagesPath;
        public String _fontsPath;
    }

    protected AbstractEngine(_Game game, _Graphics g, Input i, EnginePaths p){
        _myGame = game;
        _myGraphics = g;
        _myInput = i;
        _myPaths = p;
    }

    @Override
    public boolean init() {
        _lastFrameTime = System.nanoTime();
        if(!_myGraphics.init() || !_myGraphics.setInputListener(_myInput) || !_myGame.init() )
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
        double elapsedTime = (double)(currentTime - _lastFrameTime) / 1.0E9;
        _lastFrameTime = currentTime;
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

    public EnginePaths paths(){
        return _myPaths;
    }

    //variables
    protected _Graphics _myGraphics; //o abstractGraphics
    protected _Game _myGame;
    protected Input _myInput;
    protected EnginePaths _myPaths;
    protected long _lastFrameTime;
    protected volatile boolean _running = false;
}
