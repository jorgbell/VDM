package es.ucm.gdv.practica1.engine;
import es.ucm.gdv.practica1.engine.Graphics;
import es.ucm.gdv.practica1.engine.Input;

//Clase que guardarĂ¡ las instancias de Graphics e Input


public interface Engine{

    public Graphics getGraphics();
    public Input getInput();
    public boolean init();
    public double getDeltaTime();
    public void stop();

}