package es.ucm.gdv.practica1.engineandroid;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.speech.tts.TextToSpeech;
import android.view.Surface;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

import androidx.appcompat.app.AppCompatActivity;

import es.ucm.gdv.practica1.engine.AbstractEngine;
import es.ucm.gdv.practica1.engine.AbstractGraphics;
import es.ucm.gdv.practica1.engine.Font;
import es.ucm.gdv.practica1.engine.Image;
import es.ucm.gdv.practica1.engine.Input;
import es.ucm.gdv.practica1.engine._Game;

public class _GraphicsAndroid extends AbstractGraphics{

    _GraphicsAndroid(AppCompatActivity context, AbstractEngine.EnginePaths p){
        super(p);
        _context = context;
    }

    @Override
    public boolean init() {
        _paint = new Paint();
        _paint.setTextAlign(Paint.Align.LEFT);
        _surfaceView = new SurfaceView(_context);
        _surfaceHolder = _surfaceView.getHolder();
        _context.setContentView(_surfaceView);
        //setAspectRatio();
        _wWidth = _surfaceView.getWidth();
        _wHeight = _surfaceView.getHeight();
        return true;
    }

    @Override
    public boolean setInputListener(Input listener) {
        _InputAndroid cast = (_InputAndroid)listener;
        _surfaceView.setOnTouchListener(cast);
        return true;
    }


    @Override
    public void render(_Game game) {

        while (!_surfaceHolder.getSurface().isValid())
            ;

        _canvas = _surfaceHolder.lockCanvas();
        setColor(0x817135);
        fillRect(0,0,100,100);
        //_canvas.drawColor(0xFFFFFFFF);
        //((_GraphicsAndroid)_myGraphics).reScale();
        game.render();
        _surfaceHolder.unlockCanvasAndPost(_canvas);
    }

    @Override
    public void setColor(int color) {
        super.setColor(color);
        _paint.setColor(color);
    }

    @Override
    public void clear(int color) {
        //Este metodo no cambia el color actual. Limpia a lo bruto
        //Para cambiar el color actual usar el metodo anterior
        _paint.setColor(color);
        _canvas.drawRect(0,0,getWidth(),getHeight(), _paint);
        _paint.setColor(_actualColor);
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
    public void scale(float x, float y) {
        _canvas.scale(x,y);
    }

    @Override
    public void translate(int x, int y) {
        _canvas.translate(x,y);
    }

    //TODO
    @Override
    public Image newImage(String name) {
        ImageAndroid i = new ImageAndroid(_paths._imagesPath + name, _context.getAssets());
        return i;
    }

    //TODO
    @Override
    public Font newFont(String filename, int size, boolean isBold) {
        FontAndroid f = new FontAndroid(_paths._fontsPath + filename,size,isBold, _context.getAssets());
        return f;
        //TODO setFont()
    }

    @Override
    public void setActiveFont(Font f) {
        FontAndroid fa = (FontAndroid) f;
        if(fa.get_font()!=null){
            _paint.setTypeface(fa.get_font());
            _paint.setFakeBoldText(fa.is_bold());
            _paint.setTextSize(fa.get_size());
        }
    }


    //TODO
    @Override
    public void drawImage(Image image, float x, float y, float scaleX, float scaleY) {
        if(image !=null){
            ImageAndroid aI = (ImageAndroid)image;
            if(aI.get_image()!=null){
                int scaledW = (int)(aI.getWidth()*scaleX);
                int scaledH = (int)(aI.getHeight()*scaleY);
                aI.scaleImage(scaledW,scaledH);
                _canvas.drawBitmap(aI.get_image(),x,y,_paint);
            }
        }
    }

    @Override
    public void drawText(String text, float x, float y) {
        _canvas.drawText(text, x, y, _paint);
    }

    @Override
    public void fillCircle(float cx, float cy, int r) {
        _canvas.drawCircle(cx,cy,r,_paint);
    }

    @Override
    public void fillRect(float x, float y, float w, float h) {
        _canvas.drawRect(x,y,w,h, _paint);
    }

    @Override
    public int getWidth() {
        return _surfaceView.getWidth();
    }

    @Override
    public int getHeight() {
        return _surfaceView.getHeight();
    }

    //VARIABLES
    AppCompatActivity _context;
    Paint _paint;
    SurfaceView _surfaceView;
    SurfaceHolder _surfaceHolder;
    Canvas _canvas;
}
