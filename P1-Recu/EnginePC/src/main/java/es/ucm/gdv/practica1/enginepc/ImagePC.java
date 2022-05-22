package es.ucm.gdv.practica1.enginepc;

import java.awt.Image;
import java.io.IOException;

import es.ucm.gdv.practica1.engine.AbstractImage;

public class ImagePC extends AbstractImage {

    ImagePC(String f){
        super(f);
        load();
    }


    @Override
    public void load() {
        try {
            _image = javax.imageio.ImageIO.read(new java.io.File(_filename));
            _width = _image.getWidth(null);
            _height = _image.getHeight(null);
        } catch (IOException e) {
            System.err.println("No se puede cargar la imagen: " + e);
        }
    }

    public Image get_image() {
        return _image;
    }

    java.awt.Image _image;
}
