package es.ucm.gdv.practica1.enginepc;
import java.awt.Graphics;

import es.ucm.gdv.practica1.engine.Engine;
import es.ucm.gdv.practica1.enginepc.GraphicsPC;
import es.ucm.gdv.practica1.enginepc.InputPC;
import es.ucm.gdv.practica1.gamelogic.GameLogic;


//clase que tendrá los métodos de ciclo de vida de java
public class EnginePC extends Engine {
    public EnginePC(){
        super();
        init();
    }

    protected boolean init(){
        if(!super.init())
            return false;
        _myGraphics = new GraphicsPC("ventana");
        _myInput = new InputPC();
        _myGame = new GameLogic((EnginePC)this);
        if(!_myGraphics.init() || !_myInput.init() || !_myGame.init())
            return false;

        return true;
    }

    @Override
    public void run(){
        super.run();
        while(true){
            _myGame.update(getDeltaTime()); //actualiza la logica del juego
            do {
                do {
                    java.awt.Graphics g = _myGraphics.getDrawGraphics();
                    try {
                        _myGame.render(); //pinta lo que el juego vaya a pintar en ese frame
                    }
                    finally {
                        g.dispose();
                    }
                } while(_myGraphics.getStrategy().contentsRestored());
                _myGraphics.getStrategy().show();
            } while(_myGraphics.getStrategy().contentsLost());


            //pillar input, npi de como es
        }
    }


}