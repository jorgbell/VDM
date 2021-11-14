package es.ucm.gdv.practica1.engine;


public abstract class AbstractGraphics implements Graphics{

    public void reScale(){
        FloatPair gameAspectRatio = new FloatPair(getWindowWidth()/_gameSize._x,
                                                getWindowHeight() / _gameSize._y);
        //Comprobamos hacia dónde debemos hacer las bandas para compensar el tamano, en caso de que sea necesario
        //Si hay que meter bandas, el ancho o alto del juego no será el indicado, sino uno reescalado, dependiendo de por donde haya que reescalar
        if(gameAspectRatio._x <= gameAspectRatio._y){
            _scaleFactor = gameAspectRatio._x; //calculamos el factor de reescalado con el ANCHO
        }
        else{
            _scaleFactor = gameAspectRatio._y; //calculamos el factor de reescalado con el ALTO
        }

        FloatPair offset= new FloatPair(0,0); //default
        offset._x = (getWindowWidth() - (int)(_gameSize._x*_scaleFactor))/2;
        offset._y = (getWindowHeight() - (int)(_gameSize._y*_scaleFactor))/2;

        scale(1,1); //resetear el escalado para que al trasladar no utilice el que había guardado anteriormente
        translate(offset._x, offset._y);
        scale(_scaleFactor,_scaleFactor);
    }

    //CÁLCULOS DE POSICIONES REALES Y VIRTUALES

    /*
    //Dada una posición en el Canvas del juego, queremos saber en qué posición real de la pantalla se va a pintar
    protected FloatPair gameToWindowPos(FloatPair pos){
        if(_adjustement == WindowAdjustement.NONE)
            return pos;//como el factor de reescalado en este caso es 1, lo devolvemos tal cual

        FloatPair newPos = new FloatPair(pos._x * _scaleFactor, pos._y * _scaleFactor);
        //en caso de haber reescalado la pantalla, debemos recalcular según donde estén las barras colocadas

        if(_adjustement == WindowAdjustement.HORIZONTAL) //Si están a los lados, debemos
            newPos._x += (_windowSize._x - _gameSize._x)/2;
        else
            newPos._y += (_windowSize._y - _gameSize._y)/2;
        return newPos;
    }
    */

    /*
    //Dada una posición en la pantalla real, queremos saber en qué posición con respecto al canvas se encuentra
    protected FloatPair windowToGamePos(FloatPair pos){
        FloatPair newPos;
        FloatPair aux = pos;
        if(_adjustement == WindowAdjustement.NONE){
            ;
        }
        //en caso de haber reescalado la pantalla, debemos recalcular según donde estén las barras colocadas
        else if(_adjustement == WindowAdjustement.HORIZONTAL)  //Si están a los lados, debemos
            aux._x -= (_windowSize._x-_gameSize._x)/2;
        else
            aux._y -= (_windowSize._y-_gameSize._y)/2;

        newPos = new FloatPair((aux._x / _scaleFactor)/_gameSize._x,
                (aux._y / _scaleFactor)/_gameSize._y);
        return newPos;
    }*/

    public void changeBGColor(int c){
        _bgColor = c;
    }

    @Override
    public int getGameWidth(){return (int)_gameSize._x;}
    @Override
    public int getGameHeight(){return (int)_gameSize._y;}

    //VARIABLES PRIVADAS
    //tamanos de ventana y relacion de aspecto
    protected FloatPair _windowSize;//tamano real de la ventana
    protected FloatPair _gameSize;//tamano con el que trabaja un canvas y que después ajustaremos a la pantalla real

    //valores para el calculo del escalado y transformaciones varias
    protected float _scaleFactor = 1.0f;
    protected int _bgColor = 0xFFFFFFFF;
}
