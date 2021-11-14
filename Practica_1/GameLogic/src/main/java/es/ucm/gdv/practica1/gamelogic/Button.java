package es.ucm.gdv.practica1.gamelogic;

import es.ucm.gdv.practica1.engine.FloatPair;
import es.ucm.gdv.practica1.engine.Graphics;


public abstract class Button {
    public class Rect {
        public Rect(float x, float y, float width, float height) {
            //gameLogic values
            _x = x;
            _y = y;
            _width = width;
            _height = height;
        }

        public boolean checkCollision(float mouseX, float mouseY) {
            return ((mouseX>_x && mouseX <_x + _width) && (mouseY> _y && mouseY < _y+_height));
        }

        public FloatPair getCenter(){
            FloatPair center = new FloatPair((_x+_width)/2, (_y+_height)/2);
            return center;
        }
        float _x; float _y; float _width; float _height;
    } //Rect
        Button(FloatPair pos, FloatPair size, int r, int color, Graphics g){
        _rect = new Rect(pos._x, pos._y, size._x, size._y);
        _myGraphics = g;
        _pos = pos;
        _radius = r;
        _color = color;
    }
    public void render(){
        int prevColor = _myGraphics.getActualColor();
        _myGraphics.setColor(_color);
        _myGraphics.fillCircle((int)_pos._x, (int)_pos._y, _radius);
        _myGraphics.setColor(prevColor);
    }

    protected int _radius;
    protected Rect _rect;
    protected FloatPair _pos;
    protected Graphics _myGraphics;
    protected int _color;
    protected boolean isVisible;
}
