package es.ucm.gdv.practica1.engineandroid;

import es.ucm.gdv.practica1.engine.FloatPair;
import es.ucm.gdv.practica1.engine.Image;
import android.content.res.AssetManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;


public class ImageAndroid implements Image {
    ImageAndroid(String filename, AssetManager ass){
        _assetsManager = ass;
        _filename = filename;
        _actualScale = new FloatPair(1,1);
        _androidImage = null;
        load();
    }

    @Override
    public int getHeight() {
        return _androidImage.getHeight();
    }

    @Override
    public int getWidth() {
        return _androidImage.getWidth();
    }

    @Override
    public void load() {
        try(InputStream is = _assetsManager.open(_filename)) {
            _androidImage = BitmapFactory.decodeStream(is);
        }
        catch (IOException e) {
            System.err.println("No se puede cargar la imagen: " + e);
        }
    }

    public void resizeAndroidImage(FloatPair scale){
        if(_actualScale._x == scale._x && _actualScale._y == scale._y ) //no hace falta reescalar, salimos para ahorrar tiempo
            return;
        _actualScale = scale;
        // CREATE A MATRIX FOR THE MANIPULATION
        Matrix matrix = new Matrix();
        // RESIZE THE BIT MAP
        matrix.postScale(scale._x, scale._y);
        // "RECREATE" THE NEW BITMAP
        Bitmap resizedBitmap = Bitmap.createBitmap(_androidImage, 0, 0, getWidth(), getHeight(), matrix, false);
        _androidImage = resizedBitmap;
    }

    public Bitmap getAndroidImage(){
        return _androidImage;
    }
    public FloatPair getActualScale(){return _actualScale;}

    //VARIABLES PRIVADAS
    Bitmap _androidImage;
    AssetManager _assetsManager;
    String _filename;
    FloatPair _actualScale;


}
