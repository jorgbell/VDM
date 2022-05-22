package es.ucm.gdv.practica1.engineandroid;

import android.speech.tts.TextToSpeech;

import androidx.appcompat.app.AppCompatActivity;

import es.ucm.gdv.practica1.engine.AbstractEngine;
import es.ucm.gdv.practica1.engine.Input;
import es.ucm.gdv.practica1.engine._Game;
import es.ucm.gdv.practica1.engine._Graphics;

public class _EngineAndroid extends AbstractEngine implements Runnable {

    public _EngineAndroid(_Game game, AppCompatActivity context, EnginePaths p){ //quizas se le podria pasar el w-h
        super(game, new _GraphicsAndroid(context,p), new _InputAndroid(), p);
        _myGame.setEngine(this);
        init();
    }

    public void run() {
        if (_myThread != Thread.currentThread()) {
            // ¿¿Quién es el tuercebotas que está llamando al
            // run() directamente?? Programación defensiva
            // otra vez, con excepción, por merluzo.
            throw new RuntimeException("run() should not be called directly");
        }

        // Antes de saltar a la simulación, confirmamos que tenemos
        // un tamaño mayor que 0. Si la hebra se pone en marcha
        // muy rápido, la vista podría todavía no estar inicializada.
        while(_running && _myGraphics.getWidth() == 0) //WINDOW WIDTH, Quizas luego hay que cambiar a WindowWidth vs GameWidth
            // Espera activa. Sería más elegante al menos dormir un poco.
            ;

        while(_running){

            //ESTO ANTES LO METIA EN UN METODO RENDER DE ANDROIDGRAPCHIS.
            //NO SE SI DEBERIA IR AQUI
            while (!((_GraphicsAndroid)_myGraphics)._surfaceHolder.getSurface().isValid())
                ;
            ((_GraphicsAndroid)_myGraphics)._canvas = ((_GraphicsAndroid)_myGraphics)._surfaceHolder.lockCanvas();
            //((_GraphicsAndroid)_myGraphics).clearWindow();
            //((_GraphicsAndroid)_myGraphics).reScale();
            _myGame.run(); //input, update, render
            ((_GraphicsAndroid)_myGraphics)._surfaceHolder.unlockCanvasAndPost(((_GraphicsAndroid)_myGraphics)._canvas);


            //INPUT
            /*
                // Posibilidad: cedemos algo de tiempo. es una medida conflictiva...
                try {
                    Thread.sleep(1);
                }
                catch(Exception e) {}
    			*/

        }
    }

    public void resume(){
        if (!_running) {
            // Solo hacemos algo si no nos estábamos ejecutando ya
            // (programación defensiva, nunca se sabe quién va a
            // usarnos...)
            _running = true;
            // Lanzamos la ejecución de nuestro método run()
            // en una hebra nueva.
            _myThread = new Thread(this);
            _myThread.start();
        } // if (!_running)
    }

    public void pause(){
        if (_running) {
            _running = false;
            while (true) {
                try {
                    _myThread.join();
                    _myThread = null;
                    break;
                } catch (InterruptedException ie) {
                    // Esto no debería ocurrir nunca...
                }
            } // while(true)
        } // if (_running)
    }

    //atributos privados
    Thread _myThread;
}
