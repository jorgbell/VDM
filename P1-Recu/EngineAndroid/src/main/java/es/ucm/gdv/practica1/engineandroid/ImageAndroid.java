package es.ucm.gdv.practica1.engineandroid;

import android.content.res.AssetManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

import java.io.IOException;
import java.io.InputStream;

import es.ucm.gdv.practica1.engine.AbstractImage;
//meter un abstractImage si fuera necesario pero creo que no lo es
public class ImageAndroid extends AbstractImage {

    ImageAndroid(String f, AssetManager ass){
        super(f);
        _assetManager = ass;
        load();
    }


    @Override
    public void load() {
        try(InputStream is = _assetManager.open(_filename)) {
            _image = BitmapFactory.decodeStream(is);
            _width = _image.getWidth();
            _height = _image.getHeight();
        }
        catch (IOException e) {
            System.err.println("No se puede cargar la imagen: " + e);
        }
    }

    public Bitmap get_image() {
        return _image;
    }

    public Bitmap scaleImage(int w, int h){
        return Bitmap.createScaledBitmap(_image,w,h,true);
    }

    Bitmap _image;
    AssetManager _assetManager;

}
