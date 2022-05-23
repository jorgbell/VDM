package es.ucm.gdv.practica1.engine;

public interface _Game {
    public boolean init();
    public void update(double deltaTime);
    public void render();
    public void getInput();
    public void processInput(Input.TouchEvent input);
    public void setEngine(_Engine e);
}
