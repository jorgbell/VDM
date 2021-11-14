package es.ucm.gdv.practica1.gamelogic;

import es.ucm.gdv.practica1.engine.FloatPair;
import es.ucm.gdv.practica1.engine.Graphics;
import es.ucm.gdv.practica1.engine.Rect;

public abstract class Button {
    Button(FloatPair pos, int r, int color, Graphics g){
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

    public boolean checkCollision(float mouseX, float mouseY){
        //calculamos el cuadrado inscrito
        float lado = (float)Math.sqrt((Math.pow(_radius,2))*2);
        //x1 y x2 son vertices de arriba, y1 y2 son vertices de abajo
        float x1 = _pos._x; float y1 = _pos._y;
        float x2 = _pos._x+lado; float y2 = _pos._y+lado;
        _inscrito = new Rect(x1,x2,y1,y2);
        boolean col = false;
        //Comparamos las posiciones del raton con las del cuadrado
        if(mouseX >= x1 && mouseX <= x2){ //si está en la misma posicion en x
            if(mouseY >= y1 && mouseY <= x2){//y tambien en Y
                col = true;
            }
        }
        if(!col && mouseY >= y1 && mouseY <= x2){
            if(mouseX >= x1 && mouseX <= x2){
                col = true;
            }
        }
        return col;
    }

    public FloatPair getCenter(){
        return _inscrito.getCenterPos();
    }

    protected int _radius;
    protected FloatPair _pos;
    protected Graphics _myGraphics;
    protected int _color;
    protected boolean isVisible;
    protected Rect _inscrito;
}
