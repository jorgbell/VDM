package es.ucm.gdv.practica1.enginepc;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.List;

import es.ucm.gdv.practica1.engine.Input;
import es.ucm.gdv.practica1.engine.TouchEvent;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;



public class InputPC implements Input, MouseListener, MouseMotionListener {
    public InputPC(GraphicsPC g){
        _myGraphics = g;
        _myGraphics.getWindow().addMouseListener(this);
        _myGraphics.getWindow().addMouseMotionListener(this);
        _myTouchEvents = new ArrayList<TouchEvent>();
    }

    @Override
    public List<TouchEvent> getTouchEvents() {
        return _myTouchEvents;
    }

    //TODO cambiar lo de las posiciones segun el reescalado
    private void newEvent(MouseEvent e, TouchEvent.InputType ty){
        TouchEvent tE = new TouchEvent(ty,(e.getButton()==MouseEvent.BUTTON1),e.getX(),e.getY(), e.getID());
        synchronized (this){
            _myTouchEvents.add(tE);
        }
    }
    @Override
    public void mousePressed(MouseEvent mouseEvent) {
        newEvent(mouseEvent, TouchEvent.InputType.ARRASTRAR);
    }

    @Override
    public void mouseReleased(MouseEvent mouseEvent) {
        newEvent(mouseEvent, TouchEvent.InputType.SOLTAR);
    }

    @Override
    public void mouseDragged(MouseEvent mouseEvent) {
        newEvent(mouseEvent, TouchEvent.InputType.ARRASTRAR);
    }

    @Override
    public void mouseEntered(MouseEvent mouseEvent) {
        ;
    }

    @Override
    public void mouseExited(MouseEvent mouseEvent) {
        ;
    }

    @Override
    public void mouseClicked(MouseEvent mouseEvent) {
        ;
    }

    @Override
    public void mouseMoved(MouseEvent mouseEvent) {
        ;
    }

    private List<TouchEvent> _myTouchEvents;
    private GraphicsPC _myGraphics; //para sacar la ventana y futuros calculos de reescalado

}
