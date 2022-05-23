package es.ucm.gdv.practica1.gamepc;

import es.ucm.gdv.practica1.engine.AbstractEngine;
import es.ucm.gdv.practica1.enginepc._EnginePC;
import es.ucm.gdv.practica1.gamelogic.GameLogic;

public class GamePC {
    GamePC(){
        //inicializamos el motor y el juego
        GameLogic g = new GameLogic(400,600);
        AbstractEngine.EnginePaths paths = new AbstractEngine.EnginePaths("./data/", "./data/images/", "./data/fonts/");
        _engine = new _EnginePC(g, "OhNo", 400, 600, paths);

    }

    //métodos estáticos
    public static void main(String[] args) {
        GamePC gamepc = new GamePC();
        gamepc._engine.run();
    }
    private final _EnginePC _engine;




} //GamePC