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
        f = _myEngine.getGraphics().newFont("JosefinSans-Bold.ttf",40,true);
        f2 = _myEngine.getGraphics().newFont("Molle-Regular.ttf",60,true);
        i = _myEngine.getGraphics().newImage("close.png");
        i2 = _myEngine.getGraphics().newImage("eye.png");


        return true;
    }


    @Override
    public void processInput(Input.TouchEvent input) {
        switch (input.get_type()){
            case ARRASTRAR:
                break;
            case SOLTAR:
                prueba = false;
                color = 0xFF134589;
                break;
            case PULSAR:
                prueba = true;
                color = 0xFF956842;
                break;
        }
    }


    @Override
    public void update(double deltaTime) {
        if(!prueba){
        x = (float)(x+0.01);
        y = (float)(y+0.01);}
        else{
            x = (float)(x-0.01);
            y = (float)(y-0.01);
        }
    }


    @Override
    public void render() {

        _myEngine.getGraphics().setColor(0xFFFF00FF);
        _myEngine.getGraphics().fillCircle(x,y,40);
        _myEngine.getGraphics().setColor(color);
        _myEngine.getGraphics().setActiveFont(f);
        _myEngine.getGraphics().drawText("hola",x,y);
        _myEngine.getGraphics().setActiveFont(f2);
        _myEngine.getGraphics().drawText("que tal",x+20,y+20);

        _myEngine.getGraphics().drawImage(i,x+30,y+30,1,1);
    }


    //VARIABLES DE PRUEBAS
    boolean prueba = false;
    float x = _gameWidth/5; float y = _gameHeight/2;
    int color = 0xFF956842;
    Font f, f2;
    Image i, i2;
}
