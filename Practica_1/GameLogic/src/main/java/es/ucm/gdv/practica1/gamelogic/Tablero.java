package es.ucm.gdv.practica1.gamelogic;

import java.util.Vector;
import java.util.Random;
import es.ucm.gdv.practica1.engine.FloatPair;


public class Tablero
{
    Tablero(){};

    public void init(int s)
    {
        size = s;
        N_CASILLAS = s*s;
        //Las barreras se marcan con una X
        generateBarriers();

        //Llenamos con barreras las casillas cercadas
        fillGaps();

        //Generamos casillas azules numeradas de forma aleatoria, siendo el maximo del numero el espacio disponible
        generateBlues();
    }

    public void generateBarriers()
    {
        //Generamos el limite horizontal superior del tablero
        Vector<String> v1 = new Vector<String>(0);
        tablero.add(v1);
        for (int j = 0; j < size + 2; j++) tablero.get(0).add("X");

        Random rand = new Random();

        //Generamos barreras de forma aleatoria
        for (int i = 1; i < size + 1; i++)
        {
            Vector<String> v2 = new Vector<String>(0);
            tablero.add(v2);

            tablero.get(i).add("X");

            for (int j = 1; j < size + 1; j++)
            {
                if (rand.nextInt(size / 2) == 0)
                {
                    tablero.get(i).add("X");
                }

                else
                {
                    tablero.get(i).add(" ");
                    freeSpace.add(new FloatPair(j, i));
                }
            }

            tablero.get(i).add("X");
        }

        //Generamos el limite horizontal inferior del tablero
        tablero.add(v1);
        for (int j = 0; j < size + 2; j++) tablero.get(size + 1).add("X");
    }

    //Genera casillas azules numeradas en casillas vacias con espacio suficiente
    //El valor (Numero de casillas azules que tiene que ver) de la casila es un numero entre 1 y el menor de los valores entre
    //el espacio disponible y el tamaño del tablero.
    private void generateBlues()
    {
        //Vector<FloatPair>::Iterator it = freeSpace.begin();
        Random rand = new Random();

        int i = 0;

        //Recorremos las casillas que no tienen barreras
        while (i<freeSpace.size()/*it != freeSpace.end()*/)
        {
            //int y = (*it).y;
            //int x = (*it).x;
            FloatPair pos = new FloatPair((int)freeSpace.get(i)._y, (int)freeSpace.get(i)._x);

            Vector<Integer> space = checkSpace((int)pos._x, (int)pos._y);

            //Comprobamos que haya espacio, y si es asi hay una probabilidad de poner una casilla numerada
            if (space.get(0) > 0 && rand.nextInt(size) == 0)
            {
                //El valor maximo es el menor entre el espacio y el tamaño del tablero
                String s =String.valueOf(1 + rand.nextInt(Math.min(size, space.get(0))));
                tablero.get((int)pos._y).set((int)pos._x,s);
                numberedBlues.add(new NBlue(pos, space));
                //it = freeSpace.erase(it);
                freeSpace.remove(i);
            }
            else
                i++;
        }
    }

    //Marca como barreras los espacios encerrados y los elimina de la lista de espacios
    private void fillGaps()
    {

        int i = 0;
        //Recorremos las casillas que no tienen barreras
        while (i<freeSpace.size())
        {
            FloatPair pos = new FloatPair((int)freeSpace.get(i)._y, (int)freeSpace.get(i)._x);

            //Si no hay espacio significa que estan encerradas y que deben ser barreras
            if (checkSpace((int)pos._x, (int)pos._y).get(0) == 0)
            {
                tablero.get((int)pos._y).set((int)pos._x, "X");
                freeSpace.remove(i);
            }
            else i++;
        }
    }

    //Comprueba el espacio disponible desde esta posicion, tanto el numero total como en cada direccion
    //El indice [0] es el total, [1] Arriba, [2] Abajo, [3] Izquierda y [4] Derecha
    private Vector<Integer> checkSpace(int x, int y)
    {
        Vector<Integer> space = new Vector<Integer>(0);
        int directionSpace;
        int totalSpace = 0;
        int sign, j;
        Boolean barrier = false;

        //Recorremos las dos direcciones verticales
        for (int i = 0; i < 4; i++)
        {
            directionSpace = 0;
            j = 1;
            sign = -1 + 2 * (i % 2);

            while (!barrier)
            {
                String value;
                if (i < 2){ value = tablero.get(y + j * sign).get(x);}
                else { value = tablero.get(y).get(x + j * sign);}

                if (value == "X") barrier = true;
                else
                {
                    directionSpace++;
                    j++;
                }
            }

            barrier = false;

            space.get(directionSpace);
            totalSpace += directionSpace;
        }
        space.add(0,totalSpace);
        return space;
    }

    //Comprueba el numero de casillas azules que se ven desde esta posicion, tanto el numero total como en cada direccion
    //El indice [0] es el total, [1] Arriba, [2] Abajo, [3] Izquierda y [4] Derecha
    private Vector<Integer> checkBlues(int x, int y)
    {
        Vector<Integer> blues = new Vector<Integer>(0);
        int directionBlues;
        int totalBlues = 0;
        int sign, j;
        Boolean barrier = false;

        //Recorremos las cuatro direcciones
        for (int i = 0; i < 4; i++)
        {
            directionBlues = 0;
            j = 1;
            sign = -1 + 2 * (i % 2);

            while (!barrier)
            {
                String value;
                if (i < 2) value = tablero.get(y + j * sign).get(x);
                else value = tablero.get(y).get(x + j * sign);

                if (value == "X") barrier = true;

                else if (value != " ")
                {
                    directionBlues++;
                    totalBlues++;
                }

                j++;
            }

            blues.add(directionBlues);
            barrier = false;
        }

        blues.add(0,totalBlues);
        return blues;
    }

    //Utilizado en la pista dos, cuenta el numero de azules posibles si la primera casilla vacia en una dirección fuera azul
    public int countPossibleBlues(int direction, int x, int y)
    {
        int empties = 0;
        int blues = 0;
        int sign = -1 + 2 * (direction % 2);
        Boolean barrier = false;

        while(empties < 2 && !barrier)
        {
            String value;
            if (direction < 2) value = tablero.get(y + blues * sign).get(x);
            else value = tablero.get(y).get(x + blues * sign);
            if(value == "X") barrier = true;
            else if(value == " ") empties++;
            blues++;
        }

        return blues;
    }

    //Comprueba si una casilla forma parte del vector de casillas interactuables
    public Boolean isFreeSpace(int x, int y)
    {
        Boolean found = false;
        int i = 0;
        while (i < freeSpace.size() && !found)
        {
            if(freeSpace.get(i)._x == x && freeSpace.get(i)._y == y) found = true;
            else i++;
        }

        return found;
    }

    //Devuelve el valor de una casilla
    public String getValue(int x, int y)
    {
        return tablero.get(y).get(x);
    }

    //Cambia el valor de una casilla
    public void setValue(int x, int y, String s)
    {
        tablero.get(y).set(x, s);
    }

    private int size;
    private int N_CASILLAS;
    Vector<Vector<String>> tablero;
    Vector<FloatPair> freeSpace;
    Vector<NBlue> numberedBlues;
}

