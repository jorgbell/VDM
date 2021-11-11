package es.ucm.gdv.practica1.engine;

public interface Game {
    public boolean init();
    public void update(double deltaTime);
    public void render();
    public void setEngine(Engine e);
}
