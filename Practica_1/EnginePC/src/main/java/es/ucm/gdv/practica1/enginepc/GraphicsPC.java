package es.ucm.gdv.practica1.enginepc;
import es.ucm.gdv.practica1.engine.AbstractGraphics;
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
        _window = new JFrame(_windowName); //?????
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

        return true;
    }


    private String _windowName;
    private JFrame _window;
    public java.awt.image.BufferStrategy _strategy;

}
