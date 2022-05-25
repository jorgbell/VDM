package es.ucm.gdv.practica1.gamelogic;

import java.util.List;

import es.ucm.gdv.practica1.engine.AbstractGame;
import es.ucm.gdv.practica1.engine.Font;
import es.ucm.gdv.practica1.engine.Image;
import es.ucm.gdv.practica1.engine.Input;

public class GameLogic extends AbstractGame {

    public GameLogic(int gameW, int gameH){
        super(gameW, gameH);
    }

    @Override
    public boolean init() {
        //carga de recursos
        _myTablero = new Tablero(10);
        _myTablero.print();
        return true;
    }


    @Override
    public void processInput(Input.TouchEvent input) {
        switch (input.get_type()){
            case ARRASTRAR:
                break;
            case SOLTAR:

                break;
            case PULSAR:

                break;
        }
    }


    @Override
    public void update(double deltaTime) {

    }


    @Override
    public void render() {

    }


    //VARIABLES PRIVADAS
    Tablero _myTablero;


}
