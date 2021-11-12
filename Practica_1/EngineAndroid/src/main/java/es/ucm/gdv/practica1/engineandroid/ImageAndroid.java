package es.ucm.gdv.practica1.engineandroid;

import es.ucm.gdv.practica1.engine.Image;
import android.content.res.AssetManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;


public class ImageAndroid implements Image {
    ImageAndroid(String filename, AssetManager ass){
        _assetsManager = ass;
        _filename = filename;
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

    public Bitmap getAndroidImage(){
        return _androidImage;
    }

    private void load() {
        try(InputStream is = _assetsManager.open(_filename)) {
            _androidImage = BitmapFactory.decodeStream(is);
        }
        catch (IOException e) {
            System.err.println("No se puede cargar la imagen: " + e);
        }
    }
    //VARIABLES PRIVADAS
    Bitmap _androidImage;
    AssetManager _assetsManager;
    String _filename;


}
