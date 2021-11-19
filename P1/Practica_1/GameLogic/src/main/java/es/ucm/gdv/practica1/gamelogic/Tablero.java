package es.ucm.gdv.practica1.gamelogic;

import com.sun.org.apache.xpath.internal.operations.Bool;

import java.util.Vector;
import java.util.Random;
import es.ucm.gdv.practica1.engine.FloatPair;


public class Tablero
{
    Tablero(int s)
    {
        init(s);
    };

    public void init(int s)
    {
        size = s;
        N_CASILLAS = s*s;
        Boolean solvable = false;

        while(!solvable)
        {
            tablero.clear();
            freeSpace.clear();
            numberedBlues.clear();

            //Las barreras se marcan con una X
            generateBarriers();
            //Llenamos con barreras las casillas cercadas
            fillGaps();
            //Generamos casillas azules numeradas de forma aleatoria, siendo el maximo del numero el espacio disponible
            generateBlues();
            //Resolvemos el tablero usando las pistas
            solvable = solveTablero();
        }
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
                Integer value = 1 + rand.nextInt(Math.min(size, space.get(0)));
                String s = String.valueOf(value);
                tablero.get((int)pos._y).set((int)pos._x,s);
                numberedBlues.add(new NBlue(pos, value, space));
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

    private Boolean solveTablero()
    {
        Pistas p = new Pistas(this);

        Boolean solvable = true;
        Boolean solved = false;

        while (solvable && !solved)
        {
            updateBlues();
            int i = 0;
            Boolean flag = true;

            while (i < numberedBlues.size() && flag)
            {
                NBlue b = numberedBlues.get(i);

                if(p.PistaDiez(b)) solvable = false;

                if(p.PistaUno(b))
                {
                    fillSidesBarrier(b);
                    flag = false;
                }

                if(p.PistaTres(b))
                {
                    int dir = p.PistaOcho(b);
                    if(dir != 0)fillDirectionBlue(b, dir);

                    else if(p.PistaNueve(b)) fillAllDirections(b);
                    flag = false;
                }

                if(p.PistaDos(b) != 0)
                {
                    fillDirectionBlue(b, p.PistaDos(b));
                }

                i++;
            }

            solved = isSolved();
        }

        return solvable;
    }

    private Boolean isSolved()
    {
        Boolean flag = false;
        int i = 0;
        while(i < freeSpace.size() && !flag)
        {
            if(tablero.get((int)freeSpace.get(i)._y).get((int)freeSpace.get(i)._x) == " ") flag = true;
            else i++;
        }

        if(flag) return false;

        i = 0;
        flag = false;

        while(i < numberedBlues.size() && !flag)
        {
            if(numberedBlues.get(i).value == numberedBlues.get(i).visibleBlues.get(0)) flag = true;
            else i++;
        }

        return (!flag);
    }

    private void fillSidesBarrier(NBlue b)
    {
        int x = (int)b.pos._x;
        int y = (int)b.pos._y;
        Vector<Integer> adjacent = checkAdjacentBlues(x, y);

        tablero.get(y - (adjacent.get(1) + 1)).set(x, "X");
        tablero.get(y + (adjacent.get(2) + 1)).set(x, "X");
        tablero.get(y).set(x - (adjacent.get(3) + 1), "X");
        tablero.get(y).set(x + (adjacent.get(4) + 1), "X");
    }

    private void fillDirectionBlue(NBlue b, int dir)
    {
        int sign = -1 + 2 * (dir % 2);
        int x = (int)b.pos._x;
        int y = (int)b.pos._y;
        Vector<Integer> adjacent = checkAdjacentBlues(x, y);

        if(dir < 2) tablero.get(y + ((adjacent.get(1) + 1) * sign)).set(x, ".");
        else tablero.get(y).set(x + ((adjacent.get(4) + 1) * sign), ".");
    }

    private void fillAllDirections(NBlue b)
    {
        int x = (int)b.pos._x;
        int y = (int)b.pos._y;

        for(int i = 1; i <= 4; i++)
        {
            int sign = -1 + 2 * (i % 2);

            for(int j = 0; j < b.space.get(i); j++)
            {
                String value;
                if (i < 2 && tablero.get(y + j * sign).get(x) == " ") tablero.get(y + j * sign).set(x, ".");
                else if (tablero.get(y).get(x + j * sign) == " ") tablero.get(y).set(x + j * sign, ".");
            }
        }
    }

    public void updateBlues()
    {
        for(int i = 0; i < numberedBlues.size(); i++)
        {
            int x = (int)numberedBlues.get(i).pos._x;
            int y = (int)numberedBlues.get(i).pos._y;
            numberedBlues.get(i).space = checkSpace(x, y);
            numberedBlues.get(i).visibleBlues = checkBlues(x, y);
        }
    }

    //Comprueba el espacio disponible desde esta posicion, tanto el numero total como en cada direccion
    //El indice [0] es el total, [1] Arriba, [2] Abajo, [3] Izquierda y [4] Derecha
    public Vector<Integer> checkSpace(int x, int y)
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
    public Vector<Integer> checkBlues(int x, int y)
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

    public Vector<Integer> checkAdjacentBlues(int x, int y)
    {
        Vector<Integer> blues = new Vector<Integer>(0);
        int directionBlues;
        int totalBlues = 0;
        int sign, j;
        Boolean flag = false;

        //Recorremos las cuatro direcciones
        for (int i = 0; i < 4; i++)
        {
            directionBlues = 0;
            j = 1;
            sign = -1 + 2 * (i % 2);

            while (!flag)
            {
                String value;
                if (i < 2) value = tablero.get(y + j * sign).get(x);
                else value = tablero.get(y).get(x + j * sign);

                if (value == "X" || value == " ") flag = true;

                else
                {
                    directionBlues++;
                    totalBlues++;
                }

                j++;
            }

            blues.add(directionBlues);
            flag = false;
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

    public Vector<NBlue> getNumberedBlues()
    {
        return numberedBlues;
    }

    private int size;
    private int N_CASILLAS;
    private Vector<Vector<String>> tablero;
    private Vector<FloatPair> freeSpace;
    private Vector<NBlue> numberedBlues;
}

