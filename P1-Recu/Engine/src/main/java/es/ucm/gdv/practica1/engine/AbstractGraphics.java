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

    //MÉTODOS PARA EL REESCALADO
    @Override
    public void reScale() {

        float aspectH = (float) getHeight() / _gameHeight;
        float aspectW = (float) getWidth() / _gameWidth;
        if(aspectH == 1 && aspectW == 1){
            translate(0,0);
            scale(1,1);
            return; //si es el mismo tamanio el juego y la ventana, sale directamente
        }
        //si el juego y la ventana tienen diferente tamanio
        if(_gameWidth*aspectH > getWidth()){
            _scaleFactor = aspectW;
            _translateFactor = new pair( 0 ,
                    (getHeight() - (int)(_gameHeight * _scaleFactor))/2)     ;
        }
        else{
            _scaleFactor = aspectH;
            _translateFactor = new pair( (getHeight() - (int)(_gameHeight * _scaleFactor))/2 ,
                    0)     ;
        }

        translate(_translateFactor._first, _translateFactor._sec);
        scale(_scaleFactor, _scaleFactor);
    }

    @Override
    public void setGameSize(int x, int y) {
        _gameWidth = x; _gameHeight = y;
    }

    //VARIABLES PRIVADAS
    protected int _actualColor = 0xFFFFFFFF;
    protected Font _actualFont;

    protected int _wWidth;
    protected int _wHeight;
    protected int _gameWidth;
    protected int _gameHeight;
    //para cálculos de reescalado
    pair<Integer> _translateFactor;
    double _scaleFactor;



    protected AbstractEngine.EnginePaths _paths;
}
