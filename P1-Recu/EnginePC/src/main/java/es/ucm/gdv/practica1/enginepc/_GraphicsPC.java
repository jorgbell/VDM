package es.ucm.gdv.practica1.enginepc;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.MouseListener;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferStrategy;

import javax.swing.JFrame;

import es.ucm.gdv.practica1.engine.AbstractEngine;
import es.ucm.gdv.practica1.engine.AbstractGraphics;
import es.ucm.gdv.practica1.engine.Font;
import es.ucm.gdv.practica1.engine.Image;
import es.ucm.gdv.practica1.engine.Input;
import es.ucm.gdv.practica1.engine._Game;


public class _GraphicsPC extends AbstractGraphics {
    public _GraphicsPC(String title, int wWidth, int wHeight, AbstractEngine.EnginePaths p){
        super(p);
        _windowName = title;
        _wWidth = wWidth;
        _wHeight = wHeight;
    }

    @Override
    public boolean init() {
        //inicializa JFrame y crea la ventana
        _jframeWindow = new JFrame(_windowName);
        _jframeWindow.setSize(_wWidth, _wHeight);
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
    public void render(_Game game) {
        do {
            do {
                Graphics g = _bufferStrategy.getDrawGraphics();
                _jGraphics = g; //variable en PCGraphics
                try {
                    clear(0xFFFFFF00);
                    reScale();
                    game.render(); //input, update, render
                }
                finally {
                    g.dispose();
                }
            } while(_bufferStrategy.contentsRestored());
            _bufferStrategy.show();
        } while(_bufferStrategy.contentsLost());
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
    public void scale(double x, double y) {
        ((Graphics2D)_jGraphics).scale(x,y);
    }

    @Override
    public void translate(int x, int y) {
        _jGraphics.translate(x,y);

    }

    //TODO
    @Override
    public Image newImage(String name) {
        ImagePC i = new ImagePC(_paths._imagesPath + name);
        return i;
    }

    //TODO
    @Override
    public Font newFont(String filename, int size, boolean isBold) {
        FontPC f = new FontPC(_paths._fontsPath + filename, size, isBold);
        return f;
    }

    @Override
    public void setActiveFont(Font f) {
        FontPC fpc = (FontPC)f;
        if(fpc.get_font()!=null){
            _jGraphics.setFont(fpc.get_font());
            _actualFont = fpc;
        }
    }

    //TODO
    @Override
    public void drawImage(Image image, float x, float y, float scaleX, float scaleY) {
        ImagePC ipc = (ImagePC)image;
        if(ipc.get_image() != null){
            int drawWidth = (int)(image.getWidth()*scaleX);
            int drawHeight = (int)(image.getHeight()*scaleY);
            _jGraphics.drawImage(ipc.get_image(),
                    (int)x, (int)y,
                    drawWidth, drawHeight,
                    null);
        }
    }

    @Override
    public void drawText(String text, float x, float y) {
        _jGraphics.drawString(text,(int)x,(int)y);

    }

    @Override
    public void fillCircle(float cx, float cy, int r) {
        _jGraphics.drawOval((int)cx,(int)cy,r,r);
        _jGraphics.fillOval((int)cx,(int)cy,r,r);
    }

    @Override
    public void fillRect(float x, float y, float w, float h) {
        _jGraphics.fillRect((int)x,(int)y,(int)w,(int)h);
    }


    //VARIABLES PRIVADAS
    String _windowName;

    JFrame _jframeWindow;
    public BufferStrategy _bufferStrategy;
    Graphics _jGraphics;

    private AffineTransform _save;



}
