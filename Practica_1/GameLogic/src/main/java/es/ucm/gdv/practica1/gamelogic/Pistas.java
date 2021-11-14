package es.ucm.gdv.practica1.gamelogic;


public class Pistas
{

    public Pistas(){}
    public Pistas(Tablero t){
        _myTablero = t;
    }
    public void setTablero(Tablero t){_myTablero = t;}

    //Si un número tiene ya visibles el número de celdas que dice, entonces se puede
    //“cerrar”, es decir, poner paredes en los extremos.
    Boolean PistaUno()
    {
        return seenBlues.get(0) == value;
    }

    //Si pusiéramos un punto azul en una celda vacía, superaríamos el número de visibles
    //del número, y por tanto, debe ser una pared.
    int PistaDos()
    {
        Boolean found = false;
            int i = 1;

            while(i <= 4 && !found)
            {
                if(_myTablero.countPossibleBlues(i) > value) found = true;

                else i++;
            }

            if (found) return i;
            else return 0;
    }

    //Si no ponemos un punto en alguna celda vacía, entonces es imposible alcanzar el número.
    int PistaTres()
    {
        if(seenBlues.get(0) < value)
        {
            Boolean found = false;
            int i = 1;
            while(i <= 4 && !found)
            {
                if(seenBlues.get(i) < space(i)) found = true;

                else i++;
            }

            if (found) return i;
            else return 0;
        }

        else return 0;
    }

    //Un número tiene más casillas azules visibles de las que debería.
    Boolean PistaCuatro()
    {
        return seenBlues[0] > value;
    }

    //Un número tiene una cantidad insuficiente de casillas azules visibles y sin embargo
    //ya está “cerrada” (no puede ampliarse más por culpa de paredes).
    Boolean PistaCinco()
    {
        if(seenBlues[0] < value)
        {
            Boolean found = false;
            int i = 1;
            while(i <= 4 && !found)
            {
                if(seenBlues[i] < space[i]) found = true;

                else i++;
            }

            return !found;
        }

        else return false;
    }

    //Si una celda está vacía y cerrada y no ve ninguna celda azul, entonces es pared (todos
    //los puntos azules deben ver al menos a otro).
    Boolean PistaSeis()
    {
        return space[0] == 0;
    }

    //En sentido opuesto, si hay una celda punto puesta por el usuario que está cerrada
    //y no ve a ninguna otra, entonces se trata de un error por el mismo motivo.
    Boolean PistaSiete()
    {
        return (seenBlues[0] == 0 && space[0] == 0); 
    }

    //Un número que no ve suficientes puntos no está aún cerrado y solo tiene abierta una
    //dirección. Está cubierta por la pista 3.
    int PistaOcho()
    {
        if(seenBlues[0] < value)
        {
            Vector<int> foundDirections;
            for(int i = 1; i <= 4; i++) if(seenBlues[i] < space[i]) foundDirections.push_back(i);

            if (foundDirections.size() == 1) return foundDirections[0];
            else return 0;
        }

        else return 0;
    }

    //Un número no está cerrado y tiene varias direcciones, pero la suma alcanzable es el
    //valor que hay que conseguir. Basta con llenar el resto de celdas vacías para resolverlo.
    //Está también cubierta por la pista 3.
    Boolean PistaNueve()
    {
        if(seenBlues[0] < value) 
        {
            return space[0] == value;
        }

        else return false;
    }

    //En sentido opuesto, una celda de tipo número no está cerrada pero si se ponen en
    //punto el resto de celdas vacías que tiene alcanzables no llegará a su valor, por lo
    //que es un futuro error
    Boolean PistaDiez()
    {
        return space[0] < value;
    }



    //VARIABLES PRIVADAS
    Tablero _myTablero;
}
