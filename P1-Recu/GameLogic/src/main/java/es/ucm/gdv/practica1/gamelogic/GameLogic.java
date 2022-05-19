package es.ucm.gdv.practica1.gamelogic;

import java.util.List;

import es.ucm.gdv.practica1.engine.Input;
import es.ucm.gdv.practica1.engine._Engine;
import es.ucm.gdv.practica1.engine._Game;

public class GameLogic implements _Game {
    @Override
    public boolean init() {
        return true;
    }

    @Override
    public void setEngine(_Engine e) {
        _myEngine = e;
    }

    @Override
    public void run() {
        getInput();
        update(_myEngine.getDeltaTime());
        render();
    }

    void getInput(){
        List<Input.TouchEvent> inputList = _myEngine.getInput().getTouchEvents();
        while(inputList.size()>0){//mientras haya input que procesar
            Input.TouchEvent aux = inputList.get(0); //cogemos el primero a procesar
            inputList.remove(0); //lo borramos de la lista
            processInput(aux); //lo procesamos
        }
    }

    void processInput(Input.TouchEvent input){

    }


    void update(double deltaTime){

    }

    void render(){

    }

    //VARIABLES PRIVADAS
    _Engine _myEngine;
}
