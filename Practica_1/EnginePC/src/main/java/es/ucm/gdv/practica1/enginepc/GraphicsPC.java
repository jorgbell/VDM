package es.ucm.gdv.practica1.enginepc;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import java.io.FileInputStream;
import java.io.InputStream;

import es.ucm.gdv.practica1.engine.AbstractGraphics;
import es.ucm.gdv.practica1.engine.Color;
import es.ucm.gdv.practica1.engine.Font;
import es.ucm.gdv.practica1.engine.Image;

import javax.swing.JFrame;

public class GraphicsPC extends AbstractGraphics {
    public GraphicsPC(String title){
        super();
        _windowName = title;
    }

    @Override
    public boolean init() {
        super.init();
        //inicializa JFrame
        _window = new JFrame(_windowName);
        _window.setSize(_windowWidth,_windowHeight);
        _window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //crea la ventana

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
        _drawGraphics = _strategy.getDrawGraphics();

        return true;
    }

    @Override
    public Image newImage(String name) {
        Image i =super.newImage(name);
        //crea la imagen según la libreria de Java
    }

    @Override
    public Font newFont(String filename, int size, boolean isBold) {
        FontPC f = (FontPC)super.newFont(filename, size, isBold);
        java.awt.Font baseFont;
        //if f!= null???
        try (InputStream is = new FileInputStream(f.getFileName())) {
            baseFont = java.awt.Font.createFont(java.awt.Font.TRUETYPE_FONT, is);
        }
        catch (Exception e) {
            // Ouch. No está.
            System.err.println("Error cargando la fuente: " + e);
            return null;
        }
        // baseFont contiene el tipo de letra base en tamaño 1. La
        // usamos como punto de partida para crear la nuestra, más
        // grande y en negrita.
        f.setPCFont(baseFont.deriveFont(java.awt.Font.BOLD, 40)); //guardamos la fuente bien hecha para ciclarla más tarde
        return f;
    }

    @Override
    public void clear(Color c) {
        setColor(c);
        _drawGraphics.fillRect(0,0,getWindowWidth(), getWindowHeight());
    }

    @Override
    public void drawText(String text, int x, int y) {
        _drawGraphics.drawString(text,x,y);
    }

    @Override
    public void setColor(Color c) {
        _drawGraphics.setColor(new java.awt.Color(c._r,c._g, c._a, c._a));
    }

    //TODO DE AQUÍ PARA ABAJO

    @Override
    public void drawImage(Image image) {
        super.drawImage(image);
    }

    @Override
    public void setFont(Font f) {
        super.setFont(f);
    }

    @Override
    public void fillCircle(int cx, int cy, int r) {
        super.fillCircle(cx, cy, r);
    }



    public java.awt.Graphics getDrawGraphics(){
        return _drawGraphics;
    }



    public BufferStrategy getStrategy() { return _strategy; }

    private String _windowName;
    private JFrame _window;
    private java.awt.image.BufferStrategy _strategy;
    private java.awt.Graphics _drawGraphics;


}
