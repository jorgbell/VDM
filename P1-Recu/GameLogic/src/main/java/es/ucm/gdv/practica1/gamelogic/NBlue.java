package es.ucm.gdv.practica1.gamelogic;
import java.util.Vector;
import es.ucm.gdv.practica1.engine.pair;

//Informacion de las casillas azules numeradas, con la posicion, el espacio libre y el numero de casillas azules visibles
//(Tanto total como en cada direccion)

public class NBlue {
    public NBlue(pair<Integer> p, Integer v, Vector<Integer> s){
        value = v;
        pos = p;
        space = s;
    }

    public void setSpace(Vector<Integer> s)
    {
        space = s;
    }

    public void setBlues(Vector<Integer> b)
    {
        visibleBlues = b;
    }

    Integer value;
    pair<Integer> pos;
    Vector<Integer> space;
    Vector<Integer> visibleBlues;
};