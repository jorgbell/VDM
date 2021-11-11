package es.ucm.gdv.practica1.engine;
import es.ucm.gdv.practica1.engine.Graphics;
import es.ucm.gdv.practica1.engine.Input;

//Clase que guardará las instancias de Graphics e Input


public interface Engine{

    public Graphics getGraphics();
    public Input getInput();

    public boolean init();

    public void runEngine();

    public double getDeltaTime();


}