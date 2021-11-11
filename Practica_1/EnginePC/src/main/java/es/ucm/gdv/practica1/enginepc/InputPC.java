package es.ucm.gdv.practica1.enginepc;
import java.util.List;

import es.ucm.gdv.practica1.engine.Input;
import es.ucm.gdv.practica1.engine.TouchEvent;

public class InputPC implements Input{
    public InputPC(){

    }

    public boolean init() {

        return true;
    }

    @Override
    public List<TouchEvent> getTouchEvents() {
        return _myTouchEvents;
    }

    private List<TouchEvent> _myTouchEvents;
}
