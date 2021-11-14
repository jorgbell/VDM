package es.ucm.gdv.practica1.engine;


public interface Font {

    public String getFileName();
    public int getSize();
    public boolean isBold();
    public void setSize(int s);
    public void setBold(boolean b);
    public void load();

}
