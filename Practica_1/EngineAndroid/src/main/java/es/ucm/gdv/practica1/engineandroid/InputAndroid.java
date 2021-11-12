package es.ucm.gdv.practica1.engineandroid;

import android.graphics.Point;
import android.view.MotionEvent;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

import es.ucm.gdv.practica1.engine.Input;
import es.ucm.gdv.practica1.engine.TouchEvent;

public class InputAndroid implements Input, View.OnTouchListener {
    InputAndroid(GraphicsAndroid g){
        _myGraphics = g; //Para setear el TouchListener y futuros reescalados
        _myGraphics.getSurfaceView().setOnTouchListener(this);
        _myTouchEvents = new ArrayList<TouchEvent>();
    }

    //INPUT
    @Override
    synchronized public List<TouchEvent> getTouchEvents() {
        return _myTouchEvents;
    }


    //ONTOUCHLISTENER
    @Override
    public boolean onTouch(View view, MotionEvent motionEvent) {
        /*int index =

        Point p = new Point((int)motionEvent.getX(),(int)motionEvent.getY());
*/

        return true;
    }


    //VARIABLES PRIVADAS
    private GraphicsAndroid _myGraphics;
    private List<TouchEvent> _myTouchEvents;
}
