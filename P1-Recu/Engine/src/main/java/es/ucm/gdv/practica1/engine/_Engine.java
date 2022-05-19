package es.ucm.gdv.practica1.engine;

public interface _Engine {
    public _Graphics getGraphics();
    public Input getInput();
    public boolean init(); //abstract
    public void run();
    public boolean stop(); //abstract
    public double getDeltaTime(); //abstract
}
