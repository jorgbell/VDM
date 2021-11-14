package es.ucm.gdv.practica1.engine;


public abstract class AbstractGraphics implements Graphics{
    //esta clase tendrá los métodos relacionados con el reescalado y las bandas blancas
    public enum WindowAdjustement{
        NONE,
        VERTICAL,
        HORIZONTAL
    }

    protected void setGameSize(FloatPair gameSize){ //width, height
        _gameSize = gameSize;
        _gameAspectRatio = gameSize._x/gameSize._y;
        //Comprobamos hacia dónde debemos hacer las bandas para compensar el tamano, en caso de que sea necesario
        reScale();
    }

    public void reScale(){
        //Si hay que meter bandas, el ancho o alto del juego no será el indicado, sino uno reescalado, dependiendo de por donde haya que reescalar
        if(_windowSize._x/_windowSize._y <= _gameAspectRatio){
            _adjustement = WindowAdjustement.VERTICAL; //Las bandas debemos meterlas por arriba, por lo tanto,
            _scaleFactor = _windowSize._x / _gameSize._x; //calculamos el factor de reescalado con el ANCHO
            _gameSize._y *= _scaleFactor; //recalculamos el ALTO de la lógica real
        }
        else{
            _adjustement = WindowAdjustement.HORIZONTAL; //Las bandas debemos meterlas por los lados, por lo tanto,
            _scaleFactor = _windowSize._y / _gameSize._y; //calculamos el factor de reescalado con el ALTO
            _gameSize._x *= _scaleFactor; //recalculamos el ANCHO de la lógica real
        }
    }


    //rellena los bordes del color indicado por parámetro
    public void createWindowAdjustments(){
        setColor(_bgColor);
        FloatPair zero= new FloatPair(0,0);
        switch (_adjustement){
            case NONE:
                break;
            case VERTICAL:
                //Arriba
                fillRect(0,0,(int)_windowSize._x, (int)gameToWindowPos(zero)._y);
                //Abajo
                int y = (int)(_windowSize._y * _gameSize._y)/2 + (int)_gameSize._y;
                fillRect(0,y,(int)_windowSize._x, (int)_windowSize._y);
                break;
            case HORIZONTAL:
                //Izquierda
                fillRect(0,0,(int)gameToWindowPos(zero)._x, (int)_windowSize._y);
                //Derecha
                int x = (int)(_windowSize._x * _gameSize._x)/2 + (int)_gameSize._x;
                fillRect(x,0,(int)_windowSize._x, (int)_windowSize._y);
        }

    }
    //CÁLCULOS DE POSICIONES REALES Y VIRTUALES

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
    }





    public int getGameWidth(){return (int)_gameSize._x;}
    public int getGameHeight(){return (int)_gameSize._y;}

    //VARIABLES PRIVADAS
    //tamanos de ventana y relacion de aspecto
    private float _gameAspectRatio = 1.0f;
    protected FloatPair _windowSize;//tamano real de la ventana
    protected FloatPair _gameSize;//tamano con el que trabaja un canvas y que después ajustaremos a la pantalla real

    //valores para el calculo del escalado y transformaciones varias
    protected float _scaleFactor = 1.0f;
    protected WindowAdjustement _adjustement = WindowAdjustement.NONE; //inicialmente indicamos que no habrá que ajustar la ventana
    protected int _bgColor;
}
