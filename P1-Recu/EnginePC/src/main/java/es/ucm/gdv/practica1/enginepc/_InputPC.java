package es.ucm.gdv.practica1.enginepc;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import es.ucm.gdv.practica1.engine.AbstractInput;

public class _InputPC extends AbstractInput implements MouseListener {

    @Override
    public void mousePressed(MouseEvent mouseEvent) {
        TouchEvent tE = new TouchEvent(TouchEvent.InputType.PULSAR,
                (mouseEvent.getButton()!=MouseEvent.BUTTON1),
                mouseEvent.getX(),mouseEvent.getY(),
                mouseEvent.getID());
        newEvent(tE);

    }

    @Override
    public void mouseReleased(MouseEvent mouseEvent) {
        TouchEvent tE = new TouchEvent(TouchEvent.InputType.SOLTAR,
                (mouseEvent.getButton()!=MouseEvent.BUTTON1),
                mouseEvent.getX(),mouseEvent.getY(),
                mouseEvent.getID());
        newEvent(tE);
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
