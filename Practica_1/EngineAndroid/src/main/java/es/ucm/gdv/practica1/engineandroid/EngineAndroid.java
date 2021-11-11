package es.ucm.gdv.practica1.engineandroid;



import android.content.Context;
import android.graphics.Canvas;

import es.ucm.gdv.practica1.engine.Engine;
import es.ucm.gdv.practica1.engine.Game;
import es.ucm.gdv.practica1.engine.Graphics;
import es.ucm.gdv.practica1.engine.Input;

public class EngineAndroid implements Engine, Runnable {

    public EngineAndroid(Context context, Game game){
        _myAndroidGame = game;
        _myAndroidGame.setEngine(this);
        _myContext = context;
        init();
    };

    //ENGINE
    @Override
    public Graphics getGraphics() {
        return _myAndroidGraphics;
    }

    @Override
    public double getDeltaTime() {
        long currentTime = System.nanoTime();
        long nanoElapsedTime = currentTime - _lastFrameTime;
        _lastFrameTime = currentTime;
        double elapsedTime = (double) nanoElapsedTime / 1.0E9;
        return elapsedTime;

    }

    @Override
    public Input getInput() {
        return _myAndroidInput;
    }

    @Override
    public boolean init() {
        _lastFrameTime = System.nanoTime();
        _myAndroidGraphics = new GraphicsAndroid(_myContext);
        _myAndroidInput = new InputAndroid();
        if(!_myAndroidGraphics.init() || !_myAndroidInput.init() || !_myAndroidGame.init())
            return false;

        return true;
    }

    @Override
    public void runEngine() {

    }

    /**
     * Método llamado cuando el active rendering debe ser detenido.
     * Puede tardar un pequeño instante en volver, porque espera a que
     * se termine de generar el frame en curso.
     *
     * Se hace así intencionadamente, para bloquear la hebra de UI
     * temporalmente y evitar potenciales situaciones de carrera (como
     * por ejemplo que Android llame a resume() antes de que el último
     * frame haya terminado de generarse).
     */
    public void pause() {
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

    /**
     * Método llamado para solicitar que se continue con el
     * active rendering. El "juego" se vuelve a poner en marcha
     * (o se pone en marcha por primera vez).
     */
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

    //---------------------------------------------------
    //RUNNABLE
    @Override
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
        while(_running && _myAndroidGraphics.getWindowWidth() == 0)
            // Espera activa. Sería más elegante al menos dormir un poco.
            ;

        while(_running){
            _myAndroidGame.update(getDeltaTime());

            // Pintamos el frame TODO
            while (!_myAndroidGraphics.getHolder().getSurface().isValid())
                ;
            _myAndroidGraphics.lockCanvas();
            _myAndroidGame.render();
            _myAndroidGraphics.unlockCanvasAndPost();
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


    //-----------------------
    //ATRIBUTOS PRIVADOS
    private GraphicsAndroid _myAndroidGraphics;
    private InputAndroid _myAndroidInput;
    private Game _myAndroidGame;
    private Context _myContext;
    private long _lastFrameTime;
    /**
     * Bandera que indica si está o no en marcha la hebra de
     * active rendering, y que se utiliza para sincronización.
     * Es importante que el campo sea volatile.
     *
     * Java proporciona un mecanismo integrado para solicitar la
     * detencción de una hebra, aunque por simplicidad nosotros
     * motamos el nuestro propio.
     */
    volatile boolean _running = false;
    /**
     * Objeto Thread que está ejecutando el método run() en una hebra
     * diferente. Cuando se pide a la vista que se detenga el active
     * rendering, se espera a que la hebra termine.
     */
    Thread _myThread;

}
