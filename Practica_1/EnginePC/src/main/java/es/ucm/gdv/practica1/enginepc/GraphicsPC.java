package es.ucm.gdv.practica1.enginepc;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferStrategy;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

import es.ucm.gdv.practica1.engine.AbstractGraphics;
import java.awt.Color;

import es.ucm.gdv.practica1.engine.FloatPair;
import es.ucm.gdv.practica1.engine.Font;
import es.ucm.gdv.practica1.engine.Game;
import es.ucm.gdv.practica1.engine.Image;

import javax.swing.JFrame;

public class GraphicsPC extends AbstractGraphics implements es.ucm.gdv.practica1.engine.Graphics {
    public GraphicsPC(String title, FloatPair wSize, FloatPair gSize){
        _windowName = title;
        _windowSize = wSize;
        _gameSize = gSize;
    }

    @Override
    public boolean init() {
        //inicializa JFrame y crea la ventana
        _window = new JFrame(_windowName);
        _window.setSize((int)_windowSize._x,(int)_windowSize._y);
        _window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Vamos a usar renderizado activo. No queremos que Swing llame al
        // método repaint() porque el repintado es continuo en cualquier caso.
        _window.setIgnoreRepaint(true);

        // Hacemos visible la ventana.
        _window.setVisible(true);

        // Intentamos crear el buffer strategy con 2 buffers.
        int intentos = 100;
        while(intentos-- > 0) {
            try {
                _window.createBufferStrategy(2);
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
        _strategy = _window.getBufferStrategy();
        _graphics = _strategy.getDrawGraphics();

        return true;
    }

    @Override
    public Image newImage(String name) {
        ImagePC i = new ImagePC(name);
        return i;
    }

    @Override
    public Font newFont(String filename, int size, boolean isBold) {
        FontPC f = new FontPC(filename, size, isBold);
        return f;
    }

    @Override
    public void clearGame(int c) {
        setColor(c);
        _graphics.fillRect(0,0,getGameWidth(), getGameHeight());
    }
    @Override
    public void clearWindow(){
        setColor(_bgColor);
        _graphics.fillRect(0,0,getWindowWidth(), getWindowHeight());
    }

    @Override
    public void drawText(String text, int x, int y) {
        _graphics.drawString(text,x,y);
    }

    @Override
    public void setColor(int c) {
        Color jc = new Color(c);
        _graphics.setColor(jc);
        _actualColor = jc;
    }


    //TODO las diferentes versiones de este método, mirar referencia de java.awt.drawImage()
    @Override
    public void drawImage(Image image, int x, int y, float scaleX, float scaleY) {
        ImagePC ipc = (ImagePC)image;
        FloatPair scale = new FloatPair(scaleX, scaleY);
        if (ipc.getPCImage()!=null){
            //cálculo de ancho y alto de la imagen
            int w = (int)(ipc.getPCImage().getWidth(null)*scale._x);
            int h = (int)(ipc.getPCImage().getHeight(null)*scale._y);

            _graphics.drawImage(ipc.getPCImage(),x,y,w,h,null);
            /*
            //inicialización del recorte de la imagen
            int dx1 = x; int dy1 = y;
            int dx2 = x+w; int dy2 = y+h;
            //comprobamos si la imagen se puede dibujar entera en el espacio del canvas del juego
            if(dy2 > y+getGameHeight()){//Si la imagen se sale por abajo, hay que recortar en altura
                int diffy = h - getGameHeight();
                dy2 = h-diffy;
            }
            if(dx2 > x+getGameWidth()){//Si la imagen se sale por la derecha, hay que recortar en tamano
                int diffx =  w- getGameWidth();
                dx2 = w-diffx;
            }

            _graphics.drawImage(ipc.getPCImage(), dx1, dy1, dx2, dy2, 0, getGameHeight(), getGameWidth(), getGameHeight()+get, null);
             */
        }
    }


    @Override
    public void setFont(Font f) {
        FontPC fpc = (FontPC)f;
        if(fpc.getPCFont()!=null){
            _graphics.setFont(fpc.getPCFont());
            _actualFont = fpc;
        }
    }

    @Override
    public void fillCircle(int cx, int cy, int r) {
        _graphics.drawOval(cx,cy,r,r);
        _graphics.fillOval(cx,cy,r,r);
    }

    @Override
    public void fillRect(int x, int y, int w, int h) {
        _graphics.fillRect(x,y,w,h);
    }

    @Override
    public void translate(float x, float y) {
        _graphics.translate((int)x,(int)y);
    }

    @Override
    public void scale(float x, float y) {
        ((Graphics2D)_graphics).scale(x,y);
    }

    @Override
    public void save() {
        _save = ((Graphics2D)_graphics).getTransform();
    }

    @Override
    public void restore() {
        if(_save!=null)
            ((Graphics2D)_graphics).setTransform(_save);
    }

    @Override
    public int getWindowWidth() {
        return _window.getWidth();
    }

    @Override
    public int getWindowHeight() {
        return _window.getHeight();
    }


    @Override
    public void render(Game myPCGame) {
        do {
            do {
                Graphics g = _strategy.getDrawGraphics();
                _graphics = g;
                try {
                    clearWindow();
                    reScale(); //hace clear para crear las bandas del color bg
                    myPCGame.render(); //pinta lo que el juego vaya a pintar en ese frame
                }
                finally {
                    g.dispose();
                }
            } while(_strategy.contentsRestored());
            _strategy.show();
        } while(_strategy.contentsLost());
    }



    public BufferStrategy getStrategy() { return _strategy; }
    public JFrame getWindow(){return _window;}

    protected Font _actualFont;
    protected Color _actualColor;
    private String _windowName;
    private JFrame _window;
    private java.awt.image.BufferStrategy _strategy;
    private java.awt.Graphics _graphics;
    private AffineTransform _save;



}
