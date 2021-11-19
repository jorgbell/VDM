package es.ucm.gdv.practica1.engine;


public abstract class AbstractGraphics implements Graphics{

    public void reScale(){
        setAspectRatio();
        //Comprobamos hacia dónde debemos hacer las bandas para compensar el tamano, en caso de que sea necesario
        //Si hay que meter bandas, el ancho o alto del juego no será el indicado, sino uno reescalado, dependiendo de por donde haya que reescalar
        if(_gameAspectRatio._x <= _gameAspectRatio._y){
            _scaleFactor = _gameAspectRatio._x; //calculamos el factor de reescalado con el ANCHO
        }
        else{
            _scaleFactor = _gameAspectRatio._y; //calculamos el factor de reescalado con el ALTO
        }

        FloatPair offset= new FloatPair(0,0); //default
        offset._x = (getWindowWidth() - (_gameSize._x*_scaleFactor))/2;
        offset._y = (getWindowHeight() - (_gameSize._y*_scaleFactor))/2;

        translate(offset._x, offset._y);
        scale(_scaleFactor,_scaleFactor);
    }

    public void changeBGColor(int c){
        _bgColor = c;
    }

    public int getActualColor(){return _actualColor;}
    @Override
    public int getGameWidth(){return (int)_gameSize._x;}
    @Override
    public int getGameHeight(){return (int)_gameSize._y;}

    @Override
    public FloatPair gameToWindowPos(FloatPair pos){
        FloatPair scaled = new FloatPair(pos._x *_scaleFactor, pos._y*_scaleFactor);
        if(_gameAspectRatio._x > _gameAspectRatio._y){
            scaled._x += (getWindowWidth() - (_gameSize._x*_scaleFactor))/2; //calculamos el factor de reescalado con el ANCHO
        }
        else{
            scaled._y += (getWindowHeight() - (_gameSize._y*_scaleFactor))/2;; //calculamos el factor de reescalado con el ALTO
        }
        return scaled;

    }

    public void setAspectRatio(){
        _gameAspectRatio = new FloatPair(getWindowWidth()/_gameSize._x,
                getWindowHeight() / _gameSize._y);
    }
    //VARIABLES PRIVADAS
    //tamanos de ventana y relacion de aspecto
    protected FloatPair _windowSize;//tamano real de la ventana
    protected FloatPair _gameSize;//tamano con el que trabaja un canvas y que después ajustaremos a la pantalla real

    //valores para el calculo del escalado y transformaciones varias
    protected float _scaleFactor;
    protected int _bgColor = 0xFFFFFFFF;
    protected int _actualColor;
    FloatPair _gameAspectRatio;
}
