package es.ucm.gdv.practica1.gamelogic;

import java.util.List;

import es.ucm.gdv.practica1.engine.Font;
import es.ucm.gdv.practica1.engine.Image;
import es.ucm.gdv.practica1.engine.Input;
import es.ucm.gdv.practica1.engine._Engine;
import es.ucm.gdv.practica1.engine._Game;

public class GameLogic implements _Game {
    @Override
    public boolean init() {
        //carga de recursos
        f = _myEngine.getGraphics().newFont("JosefinSans-Bold.ttf",90,true);
        f2 = _myEngine.getGraphics().newFont("Molle-Regular.ttf",150,true);
        i = _myEngine.getGraphics().newImage("close.png");
        i2 = _myEngine.getGraphics().newImage("eye.png");
        return true;
    }

    @Override
    public void setEngine(_Engine e) {
        _myEngine = e;
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

    @Override
    public void processInput(Input.TouchEvent input) {
        switch (input.get_type()){
            case ARRASTRAR:
                break;
            case SOLTAR:
                prueba = false;
                color = 0x134589;
                break;
            case PULSAR:
                prueba = true;
                color = 0x956842;
                break;
        }
    }


    @Override
    public void update(double deltaTime) {
        if(!prueba){
        x = (float)(x+0.1);
        y = (float)(y+0.1);}
        else{
            x = (float)(x-0.1);
            y = (float)(y-0.1);
        }
    }


    @Override
    public void render() {
        _myEngine.getGraphics().setColor(0x817135);
        _myEngine.getGraphics().fillRect(x,y,100,100);

        _myEngine.getGraphics().setActiveFont(f);
        _myEngine.getGraphics().drawText("hola",x,y);
        _myEngine.getGraphics().setColor(color);
        _myEngine.getGraphics().setActiveFont(f2);
        _myEngine.getGraphics().drawText("que tal",x,y);

        _myEngine.getGraphics().drawImage(i,x,y,1,1);
    }

    //VARIABLES PRIVADAS
    _Engine _myEngine;
    //VARIABLES DE PRUEBAS
    boolean prueba = false;
    float x = 30; float y = 30;
    int color = 0x956842;
    Font f, f2;
    Image i, i2;
}
