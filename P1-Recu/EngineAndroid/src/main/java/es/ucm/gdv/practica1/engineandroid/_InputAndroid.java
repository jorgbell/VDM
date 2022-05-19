package es.ucm.gdv.practica1.engineandroid;

import android.view.MotionEvent;
import android.view.View;

import es.ucm.gdv.practica1.engine.AbstractInput;

public class _InputAndroid extends AbstractInput implements View.OnTouchListener{
    @Override
    public boolean onTouch(View view, MotionEvent motionEvent) {
        switch (motionEvent.getAction()){
            case MotionEvent.ACTION_DOWN:
            case MotionEvent.ACTION_POINTER_DOWN:
                newEvent(createEvent(motionEvent, TouchEvent.InputType.PULSAR));
                break;
            case MotionEvent.ACTION_UP:
            case MotionEvent.ACTION_POINTER_UP:
                newEvent(createEvent(motionEvent, TouchEvent.InputType.SOLTAR));
                break;
        }
        return true;
    }

    TouchEvent createEvent(MotionEvent e, TouchEvent.InputType type){
        return new TouchEvent(type,
                false,
                e.getX(), e.getY(),
                e.getPointerId(e.getActionIndex()));
    }
}
