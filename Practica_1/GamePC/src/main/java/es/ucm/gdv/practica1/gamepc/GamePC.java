package es.ucm.gdv.practica1.gamepc;
import es.ucm.gdv.practica1.enginepc.EnginePC;
import es.ucm.gdv.practica1.gamelogic.GameLogic;

//Puse una dependencia a Engine a parte de a EnginePC para que funcionara el engine.run() y creo que eso esta mal

public class GamePC {
    GamePC(){
        //inicializamos el motor y el juego
        GameLogic g = new GameLogic();
        _engine = new EnginePC(g);
    }

    //métodos estáticos
    public static void main(String[] args) {
        GamePC game = new GamePC();
        game._engine.runEngine();
    }
    private final EnginePC _engine;




} //GamePC