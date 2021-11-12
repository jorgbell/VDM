package es.ucm.gdv.practica1.engine;

//TODO separar en TouchEventAndroid y PC??
public class TouchEvent {

    public enum InputType{
        PULSAR,
        SOLTAR,
        ARRASTRAR
    }

    public TouchEvent(InputType tipo, boolean r, float x, float y, int ID){
        _posX = x;
        _posY = y;
        _touchID = ID;
        _type = tipo;
        _isRightClick = r;
    }

    public float get_posX(){return _posX;}
    public float get_posY(){return _posY;}
    public int get_touchID(){return _touchID;}
    public boolean isRightClick(){return _isRightClick;}
    public InputType get_type(){return _type;}

    //VARIABLES PRIVADAS
    float _posX;
    float _posY;
    int _touchID;
    boolean _isRightClick;
    InputType _type;

}
