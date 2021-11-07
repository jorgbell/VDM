package es.ucm.gdv.practica1.engine;
import es.ucm.gdv.practica1.engine.Graphics;
import es.ucm.gdv.practica1.engine.Input;

//Clase que guardará las instancias de Graphics e Input

public class Engine{
    public Engine(){};
    public Graphics getGraphics(){return _myGraphics;}
    public Input getInput(){return _myInput;}


    protected Graphics _myGraphics;
    protected Input _myInput;

    public boolean init() {

        return true; //devolver true solo si inicializa todo bien
    }

    public void update(){
        //código común del update de android y PC
        //Aqui tiene que actualizar el input y repintar?¿

    }


    //TODO
    public double getDeltaTime() {
        //calculo del deltatime, comun para android y pc
        double elapsedTime = 0;
        return elapsedTime;
    }
}