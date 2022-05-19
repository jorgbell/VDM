package es.ucm.gdv.practica1.enginepc;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import es.ucm.gdv.practica1.engine.AbstractInput;

public class _InputPC extends AbstractInput implements MouseListener {

    @Override
    public void mousePressed(MouseEvent mouseEvent) {
        newEvent(createEvent(mouseEvent, TouchEvent.InputType.PULSAR));
    }

    @Override
    public void mouseReleased(MouseEvent mouseEvent) {
        newEvent(createEvent(mouseEvent, TouchEvent.InputType.SOLTAR));
    }

    TouchEvent createEvent(MouseEvent mouseEvent, TouchEvent.InputType type){
        return new TouchEvent(type,
                (mouseEvent.getButton()!=MouseEvent.BUTTON1),
                mouseEvent.getX(),mouseEvent.getY(),
                mouseEvent.getID());
    }

    //------------------------//

    @Override
    public void mouseClicked(MouseEvent mouseEvent) {
        ;
    }

    @Override
    public void mouseEntered(MouseEvent mouseEvent) {
        ;
    }

    @Override
    public void mouseExited(MouseEvent mouseEvent) {
        ;
    }
}
