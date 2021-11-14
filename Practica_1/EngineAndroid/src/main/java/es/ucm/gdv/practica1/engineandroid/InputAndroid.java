package es.ucm.gdv.practica1.engineandroid;

import android.graphics.Point;
import android.text.method.Touch;
import android.view.MotionEvent;
import android.view.View;

import androidx.constraintlayout.widget.ConstraintSet;

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
        //lista de puntos. Si no es de tipo Move, habrá sólo un punto
        /*List<Point> pointsList = new ArrayList<Point>();
        for(int i = 0; i<motionEvent.getPointerCount();i++){
            Point p = new Point((int)motionEvent.getX(),(int)motionEvent.getY());

        }*/

        //Como sólo estamos detectando pulsación estandar, no de arrastrar porque no es necesario para
        //nuestro juego, sólo pondremos pulsar y levantar el dedo.
        //No obstante, como sólo queremos un tipo concreto de input, sólo llamaremos a addEvent en caso de que sea
        //esos tipos concretos de input.
        switch (motionEvent.getAction()){
            case MotionEvent.ACTION_DOWN:
            case MotionEvent.ACTION_POINTER_DOWN:
                newEvent(motionEvent, TouchEvent.InputType.PULSAR);
                break;
            case MotionEvent.ACTION_UP:
            case MotionEvent.ACTION_POINTER_UP:
                newEvent(motionEvent, TouchEvent.InputType.SOLTAR);
                break;
        }
        return true;
    }

    public void newEvent(MotionEvent e, TouchEvent.InputType ty){
        int index = e.getActionIndex();
        TouchEvent tE = new TouchEvent(ty,false,e.getX(),e.getY(), e.getPointerId(index));
        synchronized (this){
            _myTouchEvents.add(tE);
        }
    }

    //VARIABLES PRIVADAS
    private GraphicsAndroid _myGraphics;
    private List<TouchEvent> _myTouchEvents;
}
