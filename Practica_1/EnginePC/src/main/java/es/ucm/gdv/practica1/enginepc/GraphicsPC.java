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
        setGameSize(gSize);
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

        //crea la imagen según la libreria de Java
        ImagePC i;
        try {
            java.awt.Image pci = javax.imageio.ImageIO.read(new java.io.File(name));
            i = new ImagePC(name,pci);
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }

        return i;
    }

    @Override
    public Font newFont(String filename, int size, boolean isBold) {
        java.awt.Font baseFont;
        Font f;
        try (InputStream is = new FileInputStream(filename)) {
            baseFont = java.awt.Font.createFont(java.awt.Font.TRUETYPE_FONT, is);
            f = new FontPC(filename,size,isBold,
                    // baseFont contiene el tipo de letra base en tamaño 1. La
                    // usamos como punto de partida para crear la nuestra, más
                    // grande y en negrita.
                    baseFont.deriveFont(java.awt.Font.BOLD, 40));
        }
        catch (Exception e) {
            // Ouch. No está.
            System.err.println("Error cargando la fuente: " + e);
            return null;
        }

        return f;
    }

    @Override
    public void clear(int c) {
        setColor(c);
        _graphics.fillRect(0,0,getWindowWidth(), getWindowHeight());
        _graphics.translate(0,0);
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
    public void drawImage(Image image, int x, int y) {
        ImagePC ipc = (ImagePC)image;
        if (ipc.getPCImage()!=null)
            _graphics.drawImage(ipc.getPCImage(),x,y,null);
    }

    @Override
    public void setFont(Font f) {
        FontPC fpc = (FontPC)f;
        if(fpc.getPCFont()!=null){
            _graphics.setFont(fpc.getPCFont());
            _actualFont = fpc;
        }
    }

    //TODO
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
    public void translate(int x, int y) {
        _graphics.translate(x,y);
    }

    @Override
    public void scale(int x, int y) {
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

    //TODO Componentlistener: cuando detecte movimiento, cambiar el valor de _windowSize y recalcular en abstractGraphics


    @Override
    public void render(Game myPCGame) {
        do {
            do {
                Graphics g = _strategy.getDrawGraphics();
                _graphics = g;
                try {
                    clear(_bgColor); //en caso de querer pintar el fondo de un color diferente al predeterminado, lo indicamos en Render de la app llamando desde ahí a Clear()
                    myPCGame.render(); //pinta lo que el juego vaya a pintar en ese frame
                    createWindowAdjustments(); //colocado después por si se quiere cambiar el color de fondo a diferencia del color de las bandas

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
