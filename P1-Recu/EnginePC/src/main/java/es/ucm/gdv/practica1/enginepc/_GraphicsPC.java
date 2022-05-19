package es.ucm.gdv.practica1.enginepc;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.MouseListener;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferStrategy;

import javax.swing.JFrame;

import es.ucm.gdv.practica1.engine.AbstractGraphics;
import es.ucm.gdv.practica1.engine.Font;
import es.ucm.gdv.practica1.engine.Image;
import es.ucm.gdv.practica1.engine.Input;


public class _GraphicsPC extends AbstractGraphics {
    public _GraphicsPC(String title, int wWidth, int wHeight){
        _windowName = title;
        _wWidth = wWidth;
        _wHeight = wHeight;
    }

    @Override
    public boolean init() {
        //inicializa JFrame y crea la ventana
        _jframeWindow = new JFrame(_windowName);
        _jframeWindow.setSize(_wWidth, _wHeight);
        //setAspectRatio();
        _jframeWindow.setDefaultCloseOperation(javax.swing.JFrame.EXIT_ON_CLOSE);

        // Vamos a usar renderizado activo. No queremos que Swing llame al
        // método repaint() porque el repintado es continuo en cualquier caso.
        _jframeWindow.setIgnoreRepaint(true);

        // Hacemos visible la ventana.
        _jframeWindow.setVisible(true);

        // Intentamos crear el buffer strategy con 2 buffers.
        int intentos = 100;
        while(intentos-- > 0) {
            try {
                _jframeWindow.createBufferStrategy(2);
                break;
            }
            catch(Exception e) {
            }
        } // while pidiendo la creación de la buffeStrategy
        if (intentos == 0) {
            System.err.println("No pude crear la BufferStrategy");
            return false;
        }
        else {
            // En "modo debug" podríamos querer escribir esto.
            System.out.println("BufferStrategy tras " + (100 - intentos) + " intentos.");
        }
        // Obtenemos el Buffer Strategy que se supone que acaba de crearse.
        _bufferStrategy = _jframeWindow.getBufferStrategy();
        _jGraphics = _bufferStrategy.getDrawGraphics();

        return true;
    }

    @Override
    public boolean setInputListener(Input listener) {
        _InputPC cast = (_InputPC) listener;
        _jframeWindow.addMouseListener(cast);
        return true;
    }

    @Override
    public void setColor(int color) {
        super.setColor(color);
        Color jColor = new Color(color);
        _jGraphics.setColor(jColor);
    }

    @Override
    public void clear(int color) {
        //Este metodo no cambia el color actual. Limpia a lo bruto
        //Para cambiar el color actual usar el metodo anterior
        Color jColor = new Color(color);
        _jGraphics.setColor(jColor);
        _jGraphics.fillRect(0,0, getWidth(), getHeight());
        jColor = new Color(_actualColor);
        _jGraphics.setColor(jColor);
    }

    @Override
    public void restore() {
        if(_save!=null)
            ((Graphics2D)_jGraphics).setTransform(_save);
    }

    @Override
    public void save() {
        _save = ((Graphics2D)_jGraphics).getTransform();

    }

    @Override
    public void scale(float x, float y) {
        ((Graphics2D)_jGraphics).scale(x,y);
    }

    @Override
    public void translate(int x, int y) {
        _jGraphics.translate(x,y);

    }

    //TODO
    @Override
    public Image newImage(String name) {
        ImagePC i = new ImagePC(name);
        return i;
    }

    //TODO
    @Override
    public Font newFont(String filename, int size, boolean isBold) {
        FontPC f = new FontPC(filename, size, isBold);
        return f;
        //TODO setFont()
    }

    //TODO
    @Override
    public void drawImage(Image image) {

    }

    @Override
    public void drawText(String text, int x, int y) {
        _jGraphics.drawString(text,x,y);

    }

    @Override
    public void fillCircle(int cx, int cy, int r) {
        _jGraphics.drawOval(cx,cy,r,r);
        _jGraphics.fillOval(cx,cy,r,r);
    }

    @Override
    public void fillRect(int x, int y, int w, int h) {
        _jGraphics.fillRect(x,y,w,h);
    }


    //VARIABLES PRIVADAS
    String _windowName;

    JFrame _jframeWindow;
    public BufferStrategy _bufferStrategy;
    Graphics _jGraphics;

    private AffineTransform _save;



}
