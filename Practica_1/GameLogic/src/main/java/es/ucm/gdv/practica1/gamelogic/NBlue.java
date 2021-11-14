package es.ucm.gdv.practica1.gamelogic;
import java.util.Vector;

import es.ucm.gdv.practica1.engine.FloatPair;
//Informacion de las casillas azules numeradas, con la posicion, el espacio libre y el numero de casillas azules visibles
//(Tanto total como en cada direccion)

public class NBlue {
    public NBlue(FloatPair p, Vector<Integer> s){
        pos = p;
        space = s;
    }
    FloatPair pos;
    Vector<Integer> space;
    Vector<Integer> visibleBlues;
};