package es.ucm.gdv.practica1.engine;


public interface Graphics {
    public boolean init();
    public void render(Game myGame);
    public Image newImage(String name);
    public Font newFont(String filename, int size, boolean isBold);
    //borra el contenido completo de la ventana, rellenándolo con un color recibido como parámetro.
    public void clearGame(int color);
    public void clearWindow();

    //MÉTODOS DE CONTROL DE TRANSFORMACIÓN SOBRE EL CANVAS
    void translate(float x, float y);
    void scale(float x, float y);
    void save();
    void restore();

    //recibe una imagen y la muestra en la pantalla. Se pueden necesitar diferentes versiones de este método dependiendo
    //de si se permite o no escalar la imagen, si se permite elegir qué porción de la
    //imagen original se muestra, etcétera.
    public void drawImage(Image image, int x, int y, float scaleX, float scaleY); //, ...
    //establece el color a utilizar en las operaciones de
    //dibujado posteriores.
    public void setColor(int color);
    //establece el color a utilizar en las operaciones de
    //dibujado posteriores.
    public void setFont(Font f);
    // dibuja un círculo relleno del color activo
    public void fillCircle(int cx,int cy,int r);
    //escribe el texto con la fuente y color activos.
    public void drawText(String text,int x,int y);
    //Rellena un rectangulo del color actual del tamaño indicado por parametro
    public void fillRect(int x, int y, int w, int h);
    public void changeBGColor(int c);
    public int getActualColor();
    public FloatPair gameToWindowPos(FloatPair pos);

    public int getWindowWidth();
    public int getWindowHeight();
    public int getGameWidth();
    public int getGameHeight();



}


