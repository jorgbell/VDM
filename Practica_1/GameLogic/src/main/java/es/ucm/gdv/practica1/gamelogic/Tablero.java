package es.ucm.gdv.practica1.gamelogic;

public class Tablero 
{
    Tablero(int s) : size(s), N_CASILLAS(s*s) { init(); };

    public void init()
    {
        srand((Unsigned int)time(NULL));

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
        Vector<String> v1;
        tablero.push_back(v1);
        for (int j = 0; j < size + 2; j++) tablero[0].push_back("X");

        //Generamos barreras de forma aleatoria
        for (int i = 1; i < size + 1; i++)
        {
            Vector<String> v2;
            tablero.push_back(v2);

            tablero[i].push_back("X");

            for (int j = 1; j < size + 1; j++)
            {
                if (rand() % (size / 2) == 0)
                {
                    tablero[i].push_back("X");
                }

                else
                {
                    tablero[i].push_back(" ");
                    freeSpace.push_back({ j, i });
                }
            }

            tablero[i].push_back("X");
        }

        //Generamos el limite horizontal inferior del tablero
        tablero.push_back(v1);
        for (int j = 0; j < size + 2; j++) tablero[size + 1].push_back("X");
    }

    //Genera casillas azules numeradas en casillas vacias con espacio suficiente
    //El valor (Numero de casillas azules que tiene que ver) de la casila es un numero entre 1 y el menor de los valores entre
    //el espacio disponible y el tamaño del tablero. 
    private void generateBlues()
    {
        Vector<POS>::Iterator it = freeSpace.begin();

        //Recorremos las casillas que no tienen barreras
        while (it != freeSpace.end())
        {
            int y = (*it).y;
            int x = (*it).x;
            Vector<int> space = checkSpace(x, y);

            //Comprobamos que haya espacio, y si es asi hay una probabilidad de poner una casilla numerada
            if (space[0] > 0 && rand() % size == 0)
            {
                //El valor maximo es el menor entre el espacio y el tamaño del tablero
                tablero[y][x] = std::to_string(1 + rand() % (min(size, space))); 
                numberedBlues.push_back({x, y, space});
                it = freeSpace.erase(it);
            }

            else it++;
        }
    }

    //Marca como barreras los espacios encerrados y los elimina de la lista de espacios
    private void fillGaps()
    {
        Vector<POS>::Iterator it = freeSpace.begin();

        //Recorremos las casillas que no tienen barreras
        while (it != freeSpace.end())
        {
            int y = (*it).y;
            int x = (*it).x;

            //Si no hay espacio significa que estan encerradas y que deben ser barreras
            if (checkSpace(x, y)[0] == 0)
            {
                tablero[y][x] = 'X';
                it = freeSpace.erase(it);
            }

            else it++;
        }
    }

    //Comprueba el espacio disponible desde esta posicion, tanto el numero total como en cada direccion
    //El indice [0] es el total, [1] Arriba, [2] Abajo, [3] Izquierda y [4] Derecha
    private Vector<int> checkSpace(int x, int y)
    {
        Vector<int> space;
        int directionSpace;
        int totalSpace = 0;
        int sign, j;
        Bool barrier = false;

        space.push_back(0);

        //Recorremos las dos direcciones verticales
        for (int i = 0; i < 4; i++)
        {
            directionSpace = 0;
            j = 1;
            sign = -1 + 2 * (i % 2);

            while (!barrier)
            {
                if (i < 2) String value = tablero[y + j * sign][x];
                else String value = tablero[y][x + j * sign];

                if (value == "X") barrier = true;
                else
                {
                    directionSpace++;
                    j++;
                }
            }

            barrier = false;

            space.push_back(directionSpace);
            totalSpace += directionSpace;
        }

        space[0] = totalSpace;
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
        Bool barrier = false;

        blues.push_back(0);

        //Recorremos las cuatro direcciones
        for (int i = 0; i < 4; i++)
        {
            directionBlues = 0;
            j = 1;
            sign = -1 + 2 * (i % 2);

            while (!barrier)
            {
                if (i < 2) String value = tablero[y + j * sign][x];
                else String value = tablero[y][x + j * sign];

                if (value == "X") barrier = true;

                else if (value != " ")
                {
                    directionBlues++;
                    totalBlues++;
                }

                j++;
            }

            blues.push_back(directionBlues);
            barrier = false;
        }

        blues[0] = totalBlues;
        return blues;
    }

    //Utilizado en la pista dos, cuenta el numero de azules posibles si la primera casilla vacia en una dirección fuera azul
    public int countPossibleBlues(int direction)
    {
        int empties = 0;
        int blues = 0;
        int sign = -1 + 2 * (direction % 2);
        Bool barrier = false;

        while(empties < 2 && !barrier)
        {
                if (direction < 2) String value = tablero[y + blues * sign][x];
                else String value = tablero[y][x + blues * sign];
                if(value == "X") barrier = true;
                else if(value == " ") empties++;
                blues++;
        }

        return blues;
    }

    //Comprueba si una casilla forma parte del vector de casillas interactuables
    public Bool isFreeSpace(int x, int y)
    {
        Bool found = false;
        int i = 0;
        while (i < freeSpace.size() && !found) 
        {
            if(freeSpace[i].x == x && freeSpace[i].y == y) found = true;
            else i++;
        }

        return found;
    }

    //Devuelve el valor de una casilla
    public String getValue(int x, int y)
    {
        return tablero[y][x];
    }

    //Cambia el valor de una casilla
    public void setValue(int x, int y, String s)
    {
        tablero[y][x] = s;
    }

    private int size;
	private int N_CASILLAS;
	Vector<Vector<string>> tablero;
	Vector<POS> freeSpace;
	Vector<NBLUE> numberedBlues;

    //Struct posicion que guarda la posicion de una casilla en el array tablero
    private Struct POS
    {
        int x, y;
    };

    //Informacion de las casillas azules numeradas, con la posicion, el espacio libre y el numero de casillas azules visibles
    //(Tanto total como en cada direccion)

    private Struct NBLUE
    {
        POS pos;
        Vector<int> space;
        Vector<int> visibleBlues;
    };
}
