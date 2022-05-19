package es.ucm.gdv.practica1.engine;

import java.util.ArrayList;
import java.util.List;

public abstract class AbstractInput implements Input{

    protected AbstractInput(){
        _myTouchEvents = new ArrayList<TouchEvent>();
    }

    @Override
    public List<TouchEvent> getTouchEvents() {
        return _myTouchEvents;
    }

    @Override
    public void newEvent(TouchEvent tE) {
        synchronized (this){
            _myTouchEvents.add(tE);
        }
    }

    List<TouchEvent> _myTouchEvents;
}
