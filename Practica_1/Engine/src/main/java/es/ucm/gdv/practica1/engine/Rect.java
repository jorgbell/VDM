package es.ucm.gdv.practica1.engine;

public class Rect {
    public Rect(float x1, float x2, float y1, float y2){
        //gameLogic values
        _x1 = x1;
        _x2 = x2;
        _y1 = y1;
        _y2 = y2;
        _lado = x2-x1;
    }

    public FloatPair getCenterPos(){
        FloatPair center = new FloatPair(0,0);
        center._x = _x1 + _lado;
        center._y = _y1 + _lado;
        return center;
    }

    public float _x1;
    public float _x2;
    public float _y1;
    public float _y2;
    public float _lado;
}
