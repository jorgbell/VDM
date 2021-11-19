package es.ucm.gdv.practica1.engine;

import java.util.List;
import es.ucm.gdv.practica1.engine.TouchEvent;

public interface Input {
    public List<TouchEvent> getTouchEvents();
}

