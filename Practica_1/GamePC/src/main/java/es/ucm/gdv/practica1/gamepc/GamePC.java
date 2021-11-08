package es.ucm.gdv.practica1.gamepc;
import es.ucm.gdv.practica1.enginepc.EnginePC;
//Puse una dependencia a Engine a parte de a EnginePC para que funcionara el engine.run() y creo que eso esta mal

public class GamePC {
    GamePC(){
        //inicializamos el motor
        _engine = new EnginePC();
    }

    //métodos estáticos
    public static void main(String[] args) {
        GamePC game = new GamePC();
        game._engine.run();
    }
    private EnginePC _engine;




} //GamePC