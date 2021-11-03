package es.ucm.gdv.practica1.engine;

import java.util.List;

//TODO
public class Input {
    public class TouchEvent{

    }

    public Input(){};
    public List<TouchEvent> getTouchEvents(){return _myTouchEvents;}

    private List<TouchEvent> _myTouchEvents;

}

