package es.ucm.gdv.practica1.enginepc;

import es.ucm.gdv.practica1.engine.Image;

public class ImagePC implements Image {
    ImagePC(String name){
        _name=name;
    }
    ImagePC(String name, java.awt.Image pci){
        _name=name;
        setPCImage(pci);
    }
    @Override
    public int getWidth() {
        return _width;
    }

    @Override
    public int getHeight() {
        return _height;
    }

    public void setPCImage(java.awt.Image i) {
        _pcImage = i;
        _width = i.getWidth(null);
        _height = i.getHeight(null);
    }
    public java.awt.Image getPCImage(){ return _pcImage;}


    protected int _width;
    protected int _height;
    private String _name;
    private java.awt.Image _pcImage;

}
