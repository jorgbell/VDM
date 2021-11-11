package es.ucm.gdv.practica1.engineandroid;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Typeface;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

import es.ucm.gdv.practica1.engine.AbstractGraphics;
import es.ucm.gdv.practica1.engine.Color;
import es.ucm.gdv.practica1.engine.Font;
import es.ucm.gdv.practica1.engine.Graphics;
import es.ucm.gdv.practica1.engine.Image;

public class GraphicsAndroid extends AbstractGraphics implements Graphics {
    GraphicsAndroid(Context context){
        super();
        _context = context;
        init();
    };

    @Override
    public boolean init() {
        super.init();
        _paint = new Paint();
        _surfaceView = new SurfaceView(_context);
        _holder = _surfaceView.getHolder();
        return true;
    }

    @Override
    public void clear(Color color) {
        _canvas.drawColor(0XFF0000FF); //ARGB
    }

    @Override
    public void drawImage(Image image, int x, int y) {

    }

    @Override
    public void drawText(String text, int x, int y) {
        _canvas.drawText(text, x, y, _paint);
    }

    @Override
    public void fillCircle(int cx, int cy, int r) {

    }

    @Override
    public int getWindowHeight() {
        return _surfaceView.getWidth();
    }

    @Override
    public int getWindowWidth() {
        return _surfaceView.getHeight();
    }

    @Override
    public Font newFont(String filename, int size, boolean isBold) {
        Typeface tf = Typeface.createFromFile(filename);
        Font f;
        if(tf!=null){
            f = new FontAndroid(filename, size, isBold, tf);
        }
        else{
            f = null;
        }
        return f;
    }

    @Override
    public Image newImage(String name) {
        return null;
    }

    @Override
    public void restore() {

    }

    @Override
    public void save() {

    }

    @Override
    public void scale(int x, int y) {

    }

    @Override
    public void setColor(Color color) {
        _paint.setColor(android.graphics.Color.argb(color._a,color._r,color._g, color._b));
        _actualColor = color;
    }

    @Override
    public void setFont(Font f) {
        FontAndroid fa = (FontAndroid) f;
        if(fa.getAndroidFont() != null){
            _paint.setTypeface(fa.getAndroidFont());
            _paint.setFakeBoldText(fa.isBold());
            _paint.setTextSize(fa.getSize());
            _actualFont = fa;
        }

    }

    @Override
    public void translate(int x, int y) {

    }

    public SurfaceView getSurfaceView(){
        return _surfaceView;
    }

    public SurfaceHolder getHolder(){
        return _holder;
    }

    public void lockCanvas(){
        _canvas = _holder.lockCanvas();
    }

    public void unlockCanvasAndPost(){
        _holder.unlockCanvasAndPost(_canvas);
    }

    //------------------------------------------------
    //VARIABLES PRIVADAS
    private SurfaceView _surfaceView;
    private SurfaceHolder _holder;
    private Context _context;
    private Paint _paint;
    private Canvas _canvas;
    private FontAndroid _actualFont;
    private Color _actualColor;
}
