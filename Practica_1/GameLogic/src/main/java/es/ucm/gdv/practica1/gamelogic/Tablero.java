package es.ucm.gdv.practica1.gamelogic;

public class Tablero 
{
    Tablero(int s) : size(s), N_CASILLAS(s*s) { init(); };

    public void init()
    {
        srand((Unsigned int)time(NULL));

        //Las barreras se marcan con una X
        generateBarriers();
        // print();

        //Llenamos con barreras las casillas cercadas
        fillGaps();
        // print();

        //Generamos casillas azules numeradas de forma aleatoria, siendo el maximo del numero el espacio disponible
        generateBlues();
        // print();
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

    private void generateBlues()
    {
        Vector<POS>::Iterator it = freeSpace.begin();

        while (it != freeSpace.end())
        {
            int y = (*it).y;
            int x = (*it).x;
            Vector<int> space = checkSpace(x, y);

            if (space[0] > 0 && rand() % size == 0)
            {
                tablero[y][x] = std::to_string(1 + rand() % (min(size, space)));
                numberedBlues.push_back({x, y, space});
                it = freeSpace.erase(it);
            }

            else it++;
        }
    }

    //Marca como barreras los espacios encerrados y los elimina de la lista de espacios
    void fillGaps()
    {
        Vector<POS>::Iterator it = freeSpace.begin();

        while (it != freeSpace.end())
        {
            int y = (*it).y;
            int x = (*it).x;

            if (checkSpace(x, y)[0] == 0)
            {
                tablero[y][x] = 'X';
                it = freeSpace.erase(it);
            }

            else it++;
        }
    }

    //Comprobacion del espacio disponible
    private Vector<int> checkSpace(int x, int y)
    {
        Vector<int> space;
        int directionSpace;
        int totalSpace = 0;
        int sign, j;
        Bool barrier = false;

        space.push_back(0);

        for (int i = 0; i < 2; i++)
        {
            directionSpace = 0;
            j = 1;
            sign = -1 + 2 * (i % 2);

            while (!barrier)
            {
                if (tablero[y + j * sign][x] == "X") barrier = true;
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

        for (int i = 0; i < 2; i++)
        {
            directionSpace = 0;
            j = 1;
            sign = -1 + 2 * (i % 2);

            while (!barrier)
            {
                if (tablero[y][x + j * sign] == "X") barrier = true;
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

    //Comprobacion del numero de azules visible disponible
    private Vector<int> checkBlues(int x, int y)
    {
        Vector<int> blues;
        int directionBlues;
        int totalBlues = 0;
        int sign, j;
        Bool barrier = false;

        blues.push_back(0);

        for (int i = 0; i < 2; i++)
        {
            directionBlues = 0;
            j = 1;
            sign = -1 + 2 * (i % 2);

            while (!barrier)
            {
                if (tablero[y + j * sign][x] == "X") barrier = true;

                else if (tablero[y + j * sign][x] != " ")
                {
                    directionBlues++;
                    totalBlues++;
                }

                j++;
            }

            blues.push_back(directionBlues);
            barrier = false;
        }

        for (int i = 0; i < 2; i++)
        {
            directionBlues = 0;
            j = 1;
            sign = -1 + 2 * (i % 2);

            while (!barrier)
            {
                if (tablero[y][x + j * sign] == "X") barrier = true;

                else if (tablero[y + j * sign][x] != " ")
                {
                    directionBlues++;
                    totalBlues++;
                }

                j++;
            }

            blues.push_back(directionBlues);
            barrier = false;
        }

        return blues;
    }

    public int getValue(int x, int y)
    {
        return tablero[y][x];
    }

    private int size;
	private int N_CASILLAS;
	Vector<Vector<string>> tablero;
	Vector<POS> freeSpace;
	Vector<NBLUE> numberedBlues;

    private Struct POS
    {
        int x, y;
    };

    private Struct NBLUE
    {
        POS pos;
        Vector<int> space;
        Vector<int> visibleBlues;
    };
}
