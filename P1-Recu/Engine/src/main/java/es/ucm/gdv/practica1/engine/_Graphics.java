package es.ucm.gdv.practica1.engine;

public interface _Graphics {

    public boolean init();
    public boolean setInputListener(Input listener);
    public void render(_Game game);
    public void reScale();
    public void setGameSize(int x, int y);
    //carga una imagen almacenada en el contenedor de recursos de la aplicacion a partir de su nombre
    Image newImage(String name);
    //crea una nueva fuente del tamaño especificado a partir del .ttf y se indica si se desea o no en negrita
    Font newFont(String filename, int size, boolean isBold);
    void setActiveFont(Font f);
    //borra el contenido completo de la ventana rellenandolo con un color recibido como parametro
    void clear(int color);

    //métodos de control de la transformación sobre el canvas
    //las operaciones de dinbujado posteriores se verán afectadas por la transformación establecida
    void translate(int x, int y);
    void scale(double x, double y);
    void save();
    void restore();

    //recibe una imagen y la muestra en la pantalla.
    void drawImage(Image image, float x, float y, float scaleX, float scaleY); //diferentes versiones según se permita: escalar, que porción mostrar, etc

    //establece el color activo para las operaciones posteriores
    void setColor(int color);
    //devuelve el color actual
    int getColor();

    //dibuja un circulo relleno con el color activo
    void fillCircle(float cx, float cy, int r);
    void fillRect(float x, float y, float w, float h);
    // escribe el texto con la fuente y color activos.
    void drawText(String text, float x, float y);

    //tamaño de la ventana
    int getWidth(); //window width vs game width?¿?
    int getHeight();
}
