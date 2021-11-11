package es.ucm.gdv.practica1.engineandroid;

import java.util.List;

import es.ucm.gdv.practica1.engine.Input;
import es.ucm.gdv.practica1.engine.TouchEvent;

public class InputAndroid implements Input {
    InputAndroid(){}

    @Override
    public List<TouchEvent> getTouchEvents() {
        return null;
    }

    @Override
    public boolean init() {
        return false;
    }
}
