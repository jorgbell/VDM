package es.ucm.gdv.practica1.gamelogic;

import java.util.Vector;

public class Pistas
{

    public Pistas(){}
    public Pistas(Tablero t){
        _myTablero = t;
    }

    public void set_myTablero(Tablero t){_myTablero = t;}

    //Si un número tiene ya visibles el número de celdas que dice, entonces se puede
    //“cerrar”, es decir, poner paredes en los extremos.
    Boolean PistaUno(NBlue b)
    {
        return _myTablero.checkBlues(b.pos._first, b.pos._sec).get(0) == b.value;
    }

    //Si pusiéramos un punto azul en una celda vacía, superaríamos el número de visibles
    //del número, y por tanto, debe ser una pared.
    int PistaDos(NBlue b)
    {
        Boolean found = false;
        int i = 1;

        while(i <= 4 && !found)
        {
            if(_myTablero.countPossibleBlues(i, b.pos._first, b.pos._sec) > b.value) found = true;
            else i++;
        }

        if (found) return i;
        else return 0;
    }

    //Si no ponemos un punto en alguna celda vacía, entonces es imposible alcanzar el número.
    Boolean PistaTres(NBlue b)
    {
        if(b.visibleBlues.get(0) < b.value)
        {
            Boolean found = false;
            int i = 1;
            while(i <= 4 && !found)
            {
                if(b.visibleBlues.get(i) < b.space.get(i)) found = true;

                else i++;
            }

            return found;
        }

        else return false;
    }

    //Un número tiene más casillas azules visibles de las que debería.
    Boolean PistaCuatro(NBlue b)
    {
        return b.visibleBlues.get(0) > b.value;
    }

    //Un número tiene una cantidad insuficiente de casillas azules visibles y sin embargo
    //ya está “cerrada” (no puede ampliarse más por culpa de paredes).
    Boolean PistaCinco(NBlue b)
    {
        if(b.visibleBlues.get(0) < b.value)
        {
            Boolean found = false;
            int i = 1;
            while(i <= 4 && !found)
            {
                if(b.visibleBlues.get(i) < b.space.get(i)) found = true;

                else i++;
            }

            return !found;
        }

        else return false;
    }

    //Si una celda está vacía y cerrada y no ve ninguna celda azul, entonces es pared (todos
    //los puntos azules deben ver al menos a otro).
    Boolean PistaSeis(int x, int y)
    {
        return _myTablero.checkSpace(x, y).get(0) == 0;
    }

    //En sentido opuesto, si hay una celda punto puesta por el usuario que está cerrada
    //y no ve a ninguna otra, entonces se trata de un error por el mismo motivo.
    Boolean PistaSiete(int x, int y)
    {
        return (_myTablero.checkBlues(x, y).get(0) == 0 && _myTablero.checkSpace(x, y).get(0) == 0);
    }

    //Un número que no ve suficientes puntos no está aún cerrado y solo tiene abierta una
    //dirección. Está cubierta por la pista 3.
    int PistaOcho(NBlue b)
    {
        if(b.visibleBlues.get(0) < b.value)
        {
            Vector<Integer> foundDirections = new Vector<Integer>(0);
            for(int i = 1; i <= 4; i++) if(b.visibleBlues.get(i) < b.space.get(i)) foundDirections.add(i);

            if (foundDirections.size() == 1) return foundDirections.get(0);
            else return 0;
        }

        else return 0;
    }

    //Un número no está cerrado y tiene varias direcciones, pero la suma alcanzable es el
    //valor que hay que conseguir. Basta con llenar el resto de celdas vacías para resolverlo.
    //Está también cubierta por la pista 3.
    Boolean PistaNueve(NBlue b)
    {
        if(b.visibleBlues.get(0) < b.value)
        {
            return b.space.get(0) == b.value;
        }

        else return false;
    }

    //En sentido opuesto, una celda de tipo número no está cerrada pero si se ponen en
    //punto el resto de celdas vacías que tiene alcanzables no llegará a su valor, por lo
    //que es un futuro error
    Boolean PistaDiez(NBlue b)
    {
        return (b.space.get(0) + b.visibleBlues.get(0)) < b.value;
    }

    //VARIABLES PRIVADAS
    Tablero _myTablero;
}
