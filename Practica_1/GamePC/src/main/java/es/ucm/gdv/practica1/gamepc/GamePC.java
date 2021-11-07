package es.ucm.gdv.practica1.gamepc;
import es.ucm.gdv.practica1.gamelogic.GameLogic;
import es.ucm.gdv.practica1.enginepc.EnginePC;
//Puse una dependencia a Engine a parte de a EnginePC para que funcionara el engine.init() y creo que eso esta mal

public class GamePC {
    GamePC(){
        //inicializamos el motor
        _engine = new EnginePC();
        //inicializamos el juego indicandole que el motor es de tipo PC
        _gameLogic = new GameLogic(_engine);
    }

    //métodos estáticos
    public static void main(String[] args) {
        GamePC game = new GamePC();
        game._engine.init();
        game._gameLogic.init();
        while(true){//bucle principal?? entiendo que esto va aqui pero idk
            game._gameLogic.update(game._engine.getDeltaTime()); //actualiza la logica del juego
            game._engine.update(); //pilla inputs nuevos y repinta la ventana
        }
    }

    private EnginePC _engine;
    private GameLogic _gameLogic;



} //GamePC