package es.ucm.gdv.practica1.gamelogic;


import es.ucm.gdv.practica1.engine.FloatPair;
import es.ucm.gdv.practica1.engine.Font;
import es.ucm.gdv.practica1.engine.Graphics;

public class OhNoButton extends Button {

    public enum colorType{
        NONE,
        WALL,
        BLUE
    }
    OhNoButton(FloatPair gamePos, int r, int color, Graphics g, Tablero tab, FloatPair tabPos){
        super(gamePos,r,color,g);
        _tablero = tab;
        _tableroPos = tabPos;
        _buttonText = _tablero.getValue((int)tabPos._x, (int)tabPos._y);
        switch (_buttonText){
            case "X":
                _type = colorType.WALL;
                _buttonText =" ";
                break;
            case " ":
                _type = colorType.NONE;
                break;
            case ".":
            default:
                _type = colorType.BLUE;
                break;
        }
    }
    public void render(){
        switch (_type){
            case NONE:
                _color = 0x00FFFFFF;
                break;
            case BLUE:
                _color = 0xFF0000FF;
                break;
            case WALL:
                _color = 0xFFFF0000;
                break;
        }
        super.render();
        //dibuja el numero
        int aux = _myGraphics.getActualColor();
        _myGraphics.setColor(0xFFFFFFFF);
        _myGraphics.setFont(_font);
        _myGraphics.drawText(_buttonText,(int)getCenter()._x, (int)getCenter()._y);
        _myGraphics.setColor(aux);
    }

    public void setValue(colorType t){ //metodo que hay que llamar a la hora de pulsar un boton en el tablero
        _type = t;
    }

    FloatPair _tableroPos; //posicion de este boton en el array de tablero
    Tablero _tablero;
    private String _buttonText;
    public boolean _wall;
    Font _font;
    public colorType _type;

}

