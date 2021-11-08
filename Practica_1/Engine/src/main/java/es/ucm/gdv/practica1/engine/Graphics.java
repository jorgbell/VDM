package es.ucm.gdv.practica1.engine;
import es.ucm.gdv.practica1.engine.Image;
import es.ucm.gdv.practica1.engine.Font;

//TODO
public class Graphics {
    public Graphics(){};
    public Image newImage(String name){
        //carga una imagen almacenada en el contenedor de recursos de la aplicacion a partir de su nombre
        Image i = new Image(name);
        return i;
    };
    public Font newFont(String filename, int size, boolean isBold){
        //crea una nueva fuente del tamaño especificado a partir de un fichero .ttf. Se indica si se desea o no fuente en negrita.
        Font f = new Font(filename, size, isBold);
        return f;
    }
    public void clear(Color color){
        //borra el contenido completo de la ventana, rellenándolo con un color recibido como parámetro.
    };

    //MÉTODOS DE CONTROL DE TRANSFORMACIÓN SOBRE EL CANVAS
    void translate(int x, int y){}
    void scale(int x, int y){}
    void save(){};
    void restore(){};

    public void drawImage(Image image //, ...
                    ){
        //recibe una imagen y la muestra en la pantalla. Se pueden necesitar diferentes versiones de este método dependiendo
        //de si se permite o no escalar la imagen, si se permite elegir qué porción de la
        //imagen original se muestra, etcétera.
    }
    public void setColor(Color color){
        //establece el color a utilizar en las operaciones de
        //dibujado posteriores.
    }
    public void setFont(Font f){
        //establece el color a utilizar en las operaciones de
        //dibujado posteriores.
    }
    public void fillCircle(int cx,int cy,int r){
        // dibuja un círculo relleno del color activo
    }
    public void drawText(String text,int x,int y){
        //escribe el texto con la fuente y color activos.
    }


    public int getWindowWidth(){ return _windowWidth;}
    public int getWindowHeight(){ return _windowHeight;}

    protected int _windowWidth;
    protected int _windowHeight;
    protected Font _actualFont;
    protected Color _actualColor;

    public boolean init() {
        return true;
    }

}

