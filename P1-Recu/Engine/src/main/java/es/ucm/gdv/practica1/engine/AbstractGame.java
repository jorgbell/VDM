package es.ucm.gdv.practica1.engine;

import java.util.List;

//abstractGame existe no porque se vayan a implementar varios juegos, sino porque idealmente lo que se implemente aquí estará en cualquier juego hecho con este motor.
public abstract class AbstractGame implements _Game {
    protected AbstractGame(int gameWidth, int gameHeight){
        _gameWidth = gameWidth;
        _gameHeight = gameHeight;
    }


    @Override
    public void setEngine(_Engine e) {
        _myEngine = e;
        _myEngine.getGraphics().setGameSize(_gameWidth, _gameHeight);
    }


    @Override
    public void getInput() {
        List<Input.TouchEvent> inputList = _myEngine.getInput().getTouchEvents();
        while(inputList.size()>0){//mientras haya input que procesar
            Input.TouchEvent aux = inputList.get(0); //cogemos el primero a procesar
            inputList.remove(0); //lo borramos de la lista
            processInput(aux); //lo procesamos
        }
    }

    //VARIABLES PRIVADAS
    protected _Engine _myEngine;
    public int _gameWidth;
    public int _gameHeight;
}
