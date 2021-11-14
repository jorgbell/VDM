package es.ucm.gdv.practica1.gamelogic;

import es.ucm.gdv.practica1.engine.FloatPair;
//Informacion de las casillas azules numeradas, con la posicion, el espacio libre y el numero de casillas azules visibles
//(Tanto total como en cada direccion)

public class NBlue {
    FloatPair pos;
    List<Integer> space;
    Vector<int> visibleBlues;
};