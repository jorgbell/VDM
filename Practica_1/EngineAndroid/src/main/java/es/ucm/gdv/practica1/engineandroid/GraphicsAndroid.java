package es.ucm.gdv.practica1.engineandroid;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

import androidx.appcompat.app.AppCompatActivity;

import es.ucm.gdv.practica1.engine.AbstractGraphics;
import es.ucm.gdv.practica1.engine.FloatPair;
import es.ucm.gdv.practica1.engine.Font;
import es.ucm.gdv.practica1.engine.Game;
import es.ucm.gdv.practica1.engine.Graphics;
import es.ucm.gdv.practica1.engine.Image;

public class GraphicsAndroid extends AbstractGraphics implements Graphics {
    GraphicsAndroid(AppCompatActivity context, FloatPair gameSize){
        _context = context;
        _gameSize = gameSize;
        init();
    };

    @Override
    public boolean init() {
        _paint = new Paint();
        _paint.setTextAlign(Paint.Align.LEFT);
        _surfaceView = new SurfaceView(_context);
        _holder = _surfaceView.getHolder();
        _context.setContentView(_surfaceView);
        return true;
    }

    @Override
    public void render(Game myGame){
        while (!_holder.getSurface().isValid())
            ;
        _canvas = _holder.lockCanvas();
        clearWindow();
        reScale();
        myGame.render();
        _holder.unlockCanvasAndPost(_canvas);
    }

    @Override
    public void clearGame(int color) {
        setColor(color);
        _canvas.drawRect(0,0,getWindowWidth(),getWindowHeight(), _paint);
    }
    public void clearWindow(){
        _canvas.drawColor(_bgColor);
    }

    @Override
    public void drawImage(Image image, int x, int y, float scaleX, float scaleY) {
        if(image !=null){
            ImageAndroid aI = (ImageAndroid)image;
            if(aI.getAndroidImage()!=null){
                FloatPair fp = new FloatPair(scaleX, scaleY);
                aI.resizeAndroidImage(fp);
                _canvas.drawBitmap(aI.getAndroidImage(),x,y,_paint);
            }
        }
    }

    @Override
    public void drawText(String text, int x, int y) {
        _canvas.drawText(text, x, y, _paint);
    }

    @Override
    public void fillCircle(int cx, int cy, int r) {
        _canvas.drawCircle(cx,cy,r,_paint);
    }

    @Override
    public void fillRect(int x, int y, int w, int h) {
        _canvas.drawRect(x,y,w,h, _paint);
    }

    @Override
    public int getWindowHeight() {
        return _surfaceView.getHeight();
    }

    @Override
    public int getWindowWidth() {
        return _surfaceView.getWidth();
    }

    @Override
    public Font newFont(String filename, int size, boolean isBold) {
        FontAndroid f = new FontAndroid(filename,size,isBold, _context.getAssets());
        return f;
    }

    @Override
    public Image newImage(String name) {
        ImageAndroid i = new ImageAndroid(name, _context.getAssets());
        return i;
    }

    @Override
    public void restore() {
        _canvas.restore();
    }

    @Override
    public void save() {
        _canvas.save();
    }


    @Override
    public void setColor(int color) {
        _paint.setColor(color);
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
    public void translate(float x, float y) {
        _canvas.translate(x,y);
    }
    @Override
    public void scale(float x, float y) {
        _canvas.scale(x,y);
    }


    public SurfaceView getSurfaceView(){
        return _surfaceView;
    }

    //------------------------------------------------
    //VARIABLES PRIVADAS
    private SurfaceView _surfaceView;
    private SurfaceHolder _holder;
    private AppCompatActivity _context;
    private Paint _paint;
    private Canvas _canvas;
    private FontAndroid _actualFont;
}
