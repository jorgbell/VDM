package es.ucm.gdv.practica1.enginepc;

import java.io.IOException;

import es.ucm.gdv.practica1.engine.Image;

public class ImagePC implements Image {
    ImagePC(String name){
        _name=name;
        _pcImage = null;
        load();
    }
    @Override
    public int getWidth() {
        return _width;
    }

    @Override
    public int getHeight() {
        return _height;
    }

    @Override
    public void load(){
        try {
            _pcImage = javax.imageio.ImageIO.read(new java.io.File(_name));
        } catch (IOException e) {
            System.err.println("No se puede cargar la imagen: " + e);
        }
    }

    public java.awt.Image getPCImage(){ return _pcImage;}

    protected int _width;
    protected int _height;
    private String _name;
    private java.awt.Image _pcImage;

}
