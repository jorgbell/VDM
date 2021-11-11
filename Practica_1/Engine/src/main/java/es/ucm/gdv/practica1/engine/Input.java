package es.ucm.gdv.practica1.engine;

import java.util.List;
import es.ucm.gdv.practica1.engine.TouchEvent;

//TODO
public interface Input {

    public boolean init();

    public List<TouchEvent> getTouchEvents();


}

