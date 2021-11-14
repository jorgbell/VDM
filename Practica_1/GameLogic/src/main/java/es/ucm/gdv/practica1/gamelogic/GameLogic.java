package es.ucm.gdv.practica1.gamelogic;


import java.util.List;

import es.ucm.gdv.practica1.engine.Engine;
import es.ucm.gdv.practica1.engine.Game;
import es.ucm.gdv.practica1.engine.Graphics;
import es.ucm.gdv.practica1.engine.Font;
import es.ucm.gdv.practica1.engine.TouchEvent;



public class GameLogic implements Game {
    public GameLogic(){}

    @Override
    public void setEngine(Engine e){_myEngine = e;}

    @Override
    public boolean init(){
        _myGraphics = _myEngine.getGraphics();

        // Cargamos la fuente del fichero .ttf.
        _babababangers = _myGraphics.newFont("Bangers-Regular.ttf",90,true);
        b = false;

        return true;
    }


    @Override
    public void update(double deltaTime) {
        //EJEMPLO
        int maxX = _myGraphics.getWindowHeight()-40; // 300 : longitud estimada en píxeles del rótulo

        _x += _incX * deltaTime;
        while(_x < 0 || _x > maxX) {
            // Vamos a pintar fuera de la pantalla. Rectificamos.
            if (_x < 0) {
                // Nos salimos por la izquierda. Rebotamos.
                _x = -_x;
                _incX *= -1;
            }
            else if (_x > maxX) {
                // Nos salimos por la derecha. Rebotamos
                _x = 2*maxX - _x;
                _incX *= -1;
            }
        } // while
    }

    @Override
    public void render() {
        // Borramos el fondo.
        _myGraphics.clear(0XFF806A00); //esto es horrible ya cambiaremos el color cuando sepa como es exactamente


        //EJEMPLO
        if(_babababangers != null && !b){
            _myGraphics.setColor(0XFFFFFFFF);
            _myGraphics.setFont(_babababangers);
            _myGraphics.drawText("BABABABANGERS", (int)_x, 100);
        }

    }

    @Override
    public void getInput() {
        List<TouchEvent> inputList = _myEngine.getInput().getTouchEvents();
        while(inputList.size()>0){//mientras haya input que procesar
            TouchEvent aux = inputList.get(0); //cogemos el primero a procesar
            inputList.remove(0); //lo borramos de la lista
            processInput(aux); //lo procesamos
        }
    }

    //Método para implementar la lógica del input
    private void processInput(TouchEvent input){
        //switch input.type.... etc hacer cosas en general
        switch (input.get_type()){
            case PULSAR:
                //PROBLEMA: Pulsar nunca lo detecta porque por usar Arrastrar, arrastrar lo pisa.
                //Al igual habria que quitar la libreria que usa arrastrar porque no nos interesa en este juego creo y es opcional
                //en caso de que nos de problemas esto
                if(!input.isRightClick()){
                    b = true;
                    System.out.print("Pulsaste click izquierdo\n");
                }
                else
                    System.out.print("Pulsaste click derecho\n");
                break;
            case SOLTAR:
                if(!input.isRightClick())
                    System.out.print("Soltaste el click izquierdo\n");
                else
                    System.out.print("Soltaste el click derecho\n");
                break;
            case ARRASTRAR:
                if(!input.isRightClick())
                    System.out.print("Arrastraste con el click izquierdo\n");
                else
                    System.out.print("Arrastraste con el click derecho\n");
                break;
        }
    }

    private Engine _myEngine; //podrá ser de tipo Android o PC.
    private Graphics _myGraphics;
    //cosas del juego
    private Font _babababangers;
    /**
     * Posición x actual del texto (lado izquierdo). Es importante
     * que sea un número real, para acumular cambios por debajo del píxel si
     * la velocidad de actualización es mayor que la del desplazamiento.
     */
    protected double _x = 0;

    /**
     * Velocidad de desplazamiento en píxeles por segundo.
     */
    protected int _incX = 50;
    boolean b;

}