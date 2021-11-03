package es.ucm.gdv.practica1.engine;
import es.ucm.gdv.practica1.engine.Graphics;
import es.ucm.gdv.practica1.engine.Input;

//Clase que guardará las instancias de Graphics e Input

public class Engine{
    public Engine(){};
    public Graphics getGraphics(){return _myGraphics;}
    public Input getInput(){return _myInput;}


    private Graphics _myGraphics;
    private Input _myInput;

}