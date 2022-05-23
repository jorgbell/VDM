package es.ucm.gdv.practica1.gameandroid;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import es.ucm.gdv.practica1.engine.AbstractEngine;
import es.ucm.gdv.practica1.engineandroid._EngineAndroid;
import es.ucm.gdv.practica1.gamelogic.GameLogic;

public class GameAndroid extends AppCompatActivity {
    /**
     * Método llamado por Android como parte del ciclo de vida de
     * la actividad. Se llama en el momento de lanzarla.
     *
     * @param savedInstanceState Información de estado de la actividad
     *                           previamente serializada por ella misma
     *                           para reconstruirse en el mismo estado
     *                           tras un reinicio. Será null la primera
     *                           vez.
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        GameLogic g = new GameLogic();
        AbstractEngine.EnginePaths paths = new AbstractEngine.EnginePaths("", "images/", "fonts/");
        _myEngine = new _EngineAndroid(g, this, paths);

    }

    /**
     * Método llamado por Android como parte del ciclo de vida de la
     * actividad. Notifica que la actividad ha dejado de ser la de
     * primer plano. Es un indicador de que el usuario está, de alguna
     * forma, abandonando la actividad.
     */
    @Override
    protected void onPause() {
        super.onPause();
        _myEngine.pause();
    }

    /**
     * Método llamado por Android como parte del ciclo de vida de la
     * actividad. Notifica que la actividad va a pasar a primer plano,
     * estando en la cima de la pila de actividades y completamente
     * visible.
     *
     * Es llamado durante la puesta en marcha de la actividad (algo después
     * de onCreate()) y también después de un periodo de pausa (notificado
     * a través de onPause()).
     */
    @Override
    protected void onResume() {
        // Avisamos a la vista (que es la encargada del active render)
        // de lo que está pasando.
        super.onResume();
        _myEngine.resume();
    }

    private _EngineAndroid _myEngine;
}
