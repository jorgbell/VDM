package es.ucm.gdv.practica1.engine;
//implementación común de los gráficos independiente a la plataforma
public abstract class AbstractGraphics implements _Graphics{

    protected AbstractGraphics(AbstractEngine.EnginePaths p){
        _paths = p;
    }

    @Override
    public void setColor(int color) {
        _actualColor = color;
    }

    @Override
    public int getColor() {
        return _actualColor;
    }


    @Override
    public int getWidth() {
        return _wWidth;
    }

    @Override
    public int getHeight() {
        return _wHeight;
    }


    //VARIABLES PRIVADAS
    protected int _actualColor = 0xFFFFFFFF;
    protected Font _actualFont;

    protected int _wWidth;
    protected int _wHeight;
    protected AbstractEngine.EnginePaths _paths;
}
