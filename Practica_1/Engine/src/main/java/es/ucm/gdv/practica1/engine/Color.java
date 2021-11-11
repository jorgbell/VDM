package es.ucm.gdv.practica1.engine;

public class Color {
    public Color(int r, int g, int b, int a){_r= r; _g=g; _b=b; _a= a; }
    public Color(int r, int g, int b){_r= r; _g=g; _b=b; _a= 255; }

    public int _r;
    public int _g;
    public int _b;
    public int _a;
}
