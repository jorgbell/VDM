package es.ucm.gdv.practica1.gamelogic;

import java.util.Vector;
import java.util.Random;

public class Tablero
{
    Tablero(int s)
    {
        size = s;
        N_CASILLAS = s*s;
        init();
    };

    public void init()
    {
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
                    freeSpace.add({ j, i });
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
        Vector<FloatPair>::Iterator it = freeSpace.begin();
        Random rand = new Random();

        //Recorremos las casillas que no tienen barreras
        while (it != freeSpace.end())
        {
            int y = (*it).y;
            int x = (*it).x;
            Vector<int> space = checkSpace(x, y);

            //Comprobamos que haya espacio, y si es asi hay una probabilidad de poner una casilla numerada
            if (space.get(0) > 0 && rand.nextInt(size) == 0)
            {
                //El valor maximo es el menor entre el espacio y el tamaño del tablero
                tablero.get(y).get(x) = String.valueOf(1 + rand.nextInt(Math.min(size, space.get(0))));
                numberedBlues.push_back({x, y, space.get(0)});
                it = freeSpace.erase(it);
            }

            else it++;
        }
    }

    //Marca como barreras los espacios encerrados y los elimina de la lista de espacios
    private void fillGaps()
    {
        Vector<FloatPair>::Iterator it = freeSpace.begin();

        //Recorremos las casillas que no tienen barreras
        while (it != freeSpace.end())
        {
            int y = (*it).y;
            int x = (*it).x;

            //Si no hay espacio significa que estan encerradas y que deben ser barreras
            if (checkSpace(x, y).get(0) == 0)
            {
                tablero.get(y).get(x) = 'X';
                it = freeSpace.erase(it);
            }

            else it++;
        }
    }

    //Comprueba el espacio disponible desde esta posicion, tanto el numero total como en cada direccion
    //El indice [0] es el total, [1] Arriba, [2] Abajo, [3] Izquierda y [4] Derecha
    private Vector<int> checkSpace(int x, int y)
    {
        Vector<int> space = new Vector<int>(0);
        int directionSpace;
        int totalSpace = 0;
        int sign, j;
        Boolean barrier = false;

        space.add(0);

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

        space.get(0) = totalSpace;
        return space;
    }

    //Comprueba el numero de casillas azules que se ven desde esta posicion, tanto el numero total como en cada direccion
    //El indice [0] es el total, [1] Arriba, [2] Abajo, [3] Izquierda y [4] Derecha
    private Vector<int> checkBlues(int x, int y)
    {
        Vector<int> blues;
        int directionBlues;
        int totalBlues = 0;
        int sign, j;
        Boolean barrier = false;

        blues.add(0);

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

        blues.get(0) = totalBlues;
        return blues;
    }

    //Utilizado en la pista dos, cuenta el numero de azules posibles si la primera casilla vacia en una dirección fuera azul
    public int countPossibleBlues(int direction)
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
            if(freeSpace.get(i).x == x && freeSpace.get(i).y == y) found = true;
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
        tablero.get(y).get(x) = s;
    }

    private int size;
    private int N_CASILLAS;
    Vector<Vector<String>> tablero;
    Vector<FloatPair> freeSpace;
    Vector<NBlue> numberedBlues;
}

