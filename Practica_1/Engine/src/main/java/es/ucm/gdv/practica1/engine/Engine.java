package es.ucm.gdv.practica1.engine;
import es.ucm.gdv.practica1.engine.Graphics;
import es.ucm.gdv.practica1.engine.Input;
import es.ucm.gdv.practica1.gamelogic.GameLogic;

//Clase que guardará las instancias de Graphics e Input

public class Engine{
    public Engine(){};
    public Graphics getGraphics(){return _myGraphics;}
    public Input getInput(){return _myInput;}


    protected Graphics _myGraphics;
    protected Input _myInput;
    protected GameLogic _myGame;
    private long _lastFrameTime;

    protected boolean init() {
        _lastFrameTime = System.nanoTime();
        return true; //devolver true solo si inicializa todo bien
    }

    public void update(){
        //código común del update de android y PC
        //Aqui tiene que actualizar el input y repintar?¿

    }

    public void run(){

    }

    //TODO
    public double getDeltaTime() {
        long currentTime = System.nanoTime();
        long nanoElapsedTime = currentTime - _lastFrameTime;
        _lastFrameTime = currentTime;
        double elapsedTime = (double) nanoElapsedTime / 1.0E9;
        return elapsedTime;
    }
}