package es.ucm.gdv.practica1.gamelogic;


import es.ucm.gdv.practica1.engine.Engine;
import es.ucm.gdv.practica1.engine.Graphics;
import es.ucm.gdv.practica1.engine.Font;
import es.ucm.gdv.practica1.engine.Color;
import es.ucm.gdv.practica1.engine.Image;

public class GameLogic{
    public GameLogic(Engine e){_myEngine = e;}


    public boolean init(){
        _myGraphics = _myEngine.getGraphics();
        // Cargamos la fuente del fichero .ttf.
        _babababangers = _myGraphics.newFont("Bangers-Regular.ttf",40,true);

        /*
        try (InputStream is = new FileInputStream("Bangers-Regular.ttf")) {
            baseFont = Font.createFont(Font.TRUETYPE_FONT, is);
        }
        catch (Exception e) {
            // Ouch. No está.
            System.err.println("Error cargando la fuente: " + e);
            return false;
        }

        // baseFont contiene el tipo de letra base en tamaño 1. La
        // usamos como punto de partida para crear la nuestra, más
        // grande y en negrita.
        _font = baseFont.deriveFont(Font.BOLD, 40);
    */

        return true;
    }


    public void update(double deltaTime) {
        int maxX = _myGraphics.getWindowHeight() - 300; // 300 : longitud estimada en píxeles del rótulo

        _x += _incX * deltaTime;
        while(_x < 0 || _x > maxX) {
            // Vamos a pintar fuera de la pantalla. Rectificamos.
            if (_x < 0) {
                // Nos salimos por la izquierda. Rebotamos.
                _x = -_x;
                _incX *= -1;
            }
            else if (_x > maxX) {
                // Nos salimos por la derecha. Rebotamos
                _x = 2*maxX - _x;
                _incX *= -1;
            }
        } // while
    }

    public void render() {
        // Borramos el fondo.
        _myGraphics.clear(new Color(0,1,1)); //esto es horrible ya cambiaremos el color cuando sepa como es exactamente
        if(_babababangers != null){
            Color white;
            _myGraphics.setColor(new Color(0,0,0));
            _myGraphics.setFont(_babababangers);
            _myGraphics.drawText("RENDERIZADO ACTIVO", (int)_x, 100);
        }
    /* PC
        g.setColor(Color.yellow.darker());
        g.fillRect(0, 0, getWidth(), getHeight());

        // Ponemos el rótulo (si conseguimos cargar la fuente)
        if (_font != null) {
            g.setColor(Color.WHITE);
            g.setFont(_font);
            g.drawString("RENDERIZADO ACTIVO", (int)_x, 100);
        }
        */
    }


    Engine _myEngine; //podrá ser de tipo Android o PC.
    Graphics _myGraphics;
    //cosas del juego
    Font _babababangers;
    /**
     * Posición x actual del texto (lado izquierdo). Es importante
     * que sea un número real, para acumular cambios por debajo del píxel si
     * la velocidad de actualización es mayor que la del desplazamiento.
     */
    protected double _x = 0;

    /**
     * Velocidad de desplazamiento en píxeles por segundo.
     */
    protected int _incX = 50;

}