package es.ucm.gdv.practica1.gamepc;

import es.ucm.gdv.practica1.enginepc._EnginePC;
import es.ucm.gdv.practica1.gamelogic.GameLogic;

public class GamePC {
    GamePC(){
        //inicializamos el motor y el juego
        GameLogic g = new GameLogic();
        _engine = new _EnginePC(g, "OhNo", 480, 480);

    }

    //métodos estáticos
    public static void main(String[] args) {
        GamePC gamepc = new GamePC();
        gamepc._engine.run();
    }
    private final _EnginePC _engine;




} //GamePC