package es.ucm.gdv.practica1.enginepc;
import es.ucm.gdv.practica1.engine.Engine;
import es.ucm.gdv.practica1.enginepc.GraphicsPC;
import es.ucm.gdv.practica1.enginepc.InputPC;


//clase que tendrá los métodos de ciclo de vida de java
public class EnginePC extends Engine {
    public EnginePC(){
        super();
    }

    public boolean init(){
        super.init();
        _myGraphics = new GraphicsPC("ventana");
        _myInput = new InputPC();
        //tiene que llamar al de GraphicsPC pero creo que salta a Graphics directamente
        //por eso casteo pero igual es feisimo y no hay que hacer eso
        //lo mismo para input
        ((GraphicsPC)_myGraphics).init();
        ((InputPC)_myInput).init();

        return true;
    }

}