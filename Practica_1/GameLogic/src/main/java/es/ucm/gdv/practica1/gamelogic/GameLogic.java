package es.ucm.gdv.practica1.gamelogic;

import es.ucm.gdv.practica1.engine.Engine;

public class GameLogic{
    public GameLogic(Engine e){_myEngine = e;}


    public void init(){
        /*
        // Cargamos la fuente del fichero .ttf.
        Font baseFont;
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
    }

    Engine _myEngine; //podrá ser de tipo Android o PC.

    public void update(double deltaTime) {

    }
}