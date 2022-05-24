package es.ucm.gdv.practica1.gamelogic;

import java.util.Collections;
import java.util.Vector;
import java.util.Random;
import es.ucm.gdv.practica1.engine.pair;

public class Tablero
{
    Tablero(int s)
    {
        _pistas = new Pistas(this);
        init(s);
    };

    public void print(){

        String bar = "";

        for (int i = 0; i < size * 2; i++)
            System.out.print("\n");
            //cout << "\n";

        for (int i = 0; i < size; i++)
        {
            bar += "+---";
        }

        bar += "+\n";

        for (int i = 1; i < size + 1; i++)
        {
            System.out.print(bar);
            //cout << bar;
            for (int j = 1; j < size + 1; j++)
            {
                System.out.print("| "+tablero.get(i).get(j)+" ");
                //cout << "| " << tablero[i][j] << " ";
            }
            System.out.print("\n");
            //cout << "|\n";
        }
        System.out.print(bar);
        //cout << bar;
    }

    public void init(int s)
    {
        size = s;
        N_CASILLAS = s*s;
        minBarriers= N_CASILLAS - (int)(N_CASILLAS*0.95);
        maxBarriers = N_CASILLAS/3;
        Boolean solvable = false;

        //generacion de un tablero hasta que pueda ser resuelto
        while(!solvable)
        {
            tablero.clear();
            freeSpace.clear();
            numberedBlues.clear();

            //Las barreras se marcan con una X
            generateBarriers();
            //Llenamos con barreras las casillas cercadas
            print();
            fillGaps();
            System.out.print("MinBarriers: " + minBarriers + "\nMaxBarriers: "+ maxBarriers + "\nMinNBLues: "+minBlues+"\nMaxNBlues: "+maxBlues);
            print();
            //Generamos casillas azules numeradas de forma aleatoria, siendo el maximo del numero el espacio disponible
            generateBlues();
            print();
            //Resolvemos el tablero usando las pistas
            solvable = solveTablero();
            print();
        }

    }

    public void generateBarriers()
    {
        //Generamos el limite horizontal superior del tablero
        Vector<String> limiteH = new Vector<String>(0);
        //tablero.add(limiteH);
        for (int j = 0; j < size + 2; j++) limiteH.add("X");

        Random rand = new Random();

        int nBarriers = 0;
        //numero minimo requerido de barreras = minimo un 5% del total tienen que ser barreras
        //creamos unos contenedores provisionales en los que meteremos el tablero que estamos creando.
        //si el numero de barreras llega a ser el que queremos, lo aniadiremos al final. Si no, repetiremos.
        Vector<Vector<String>> interiorProvisional = new Vector<Vector<String>>(0);
        Vector<pair<Integer>> freeSpaceProvisional = new Vector<pair<Integer>>(0);

        while(nBarriers < minBarriers) { //si al acabar de hacer el bucle no cumple el minimo de barreras que se piden, vuelve a intentarlo
            //reseteamos valores
            nBarriers = 0;
            interiorProvisional.clear();
            interiorProvisional.add(limiteH);
            freeSpaceProvisional.clear();

            //empezamos a crear las barreras
            int i = 1;
            while(i < size+1){ //debe hacer todas las lineas
                Vector<String> linea = new Vector<String>(0);

                interiorProvisional.add(linea);
                interiorProvisional.get(i).add("X"); //borde lateral izq (pared invisible)

                int j = 1;
                while(j<size+1){//debe recorrer toda la linea
                    //si puede aniadir muros, mira a ver si lo mete. Si no, tiene que meter si o si un espacio en blanco
                    if(nBarriers < maxBarriers){
                        int prob = rand.nextInt(10);
                        //aniade o no segun el factor aleatorio un muro o un espacio en blanco
                        if (prob<2) //20% de probabilidad de crear un muro
                        {
                            interiorProvisional.get(i).add("X");
                            nBarriers++; //sumamos unicamente aqui ya que el resto de barreras aniadidas son las invisibles
                        }
                        else{//puede meter mas muros, pero no dio la casualidad por el aleatorio, asi que mete un espacio en blanco
                            interiorProvisional.get(i).add(" ");
                            freeSpaceProvisional.add(new pair<Integer>(j, i)); //marcamos en el vector de los espacios vacios donde esta colocado en el tablero
                        }
                    }
                    else {//mete un espacio en blanco por no poder meter mas muros
                        interiorProvisional.get(i).add(" ");
                        freeSpaceProvisional.add(new pair<Integer>(j, i)); //marcamos en el vector de los espacios vacios donde esta colocado en el tablero
                    }
                    j++;
                }

                interiorProvisional.get(i).add("X"); //borde lateral der (pared invisible)
                i++;
            }
        }

        //Una vez se sale del bucle, significa que ha conseguido crear un tablero correcto. En ese caso, aniadimos:

        for (Vector<String> linea: interiorProvisional) {
            tablero.add(linea);
        }
        for (pair<Integer> space: freeSpaceProvisional) {
            freeSpace.add(space);
        }

        //Generamos el limite horizontal inferior del tablero
        tablero.add(limiteH);
        //for (int j = 0; j < size + 2; j++) tablero.get(size + 1).add("X");
    }

    //Genera casillas azules numeradas en casillas vacias con espacio suficiente
    //El valor (Numero de casillas azules que tiene que ver) de la casila es un numero entre 1 y el menor de los valores entre
    //el espacio disponible y el tamaño del tablero.
    private void generateBlues()
    {
        Random rand = new Random();

        int nBlues = 0;

        //contenedor del resultado provisional
        Vector<NBlue> provisionalNBlues = new Vector<NBlue>();
        //copia de seguridad de los espacios vacios
        Vector<pair<Integer>> freeSpaceCopy = new Vector<pair<Integer>>();
        freeSpaceCopy.addAll(freeSpace);

        while(nBlues < minBlues){ //mientras no se haya superado el minimo de azules iniciales requerido, hace una interacion hasta conseguirlo
            provisionalNBlues.clear();
            freeSpace.clear();
            freeSpace.addAll(freeSpaceCopy);
            nBlues = 0;
            int i = 0;
            //Recorremos las casillas que no tienen barreras
            while (i<freeSpace.size() && nBlues < maxBlues) //mientras aun queden espacios por recorrer Y no se haya superado el maximo de azules requerido
            {
                pair<Integer> pos = new pair<Integer>(freeSpace.get(i)._sec, freeSpace.get(i)._first);
                //FloatPair pos = new FloatPair((int)freeSpace.get(i)._y, (int)freeSpace.get(i)._x);

                Vector<Integer> space = checkSpace(pos._first, pos._sec);

                //Comprobamos que haya espacio, y si es asi hay una probabilidad de poner una casilla numerada
                int prob = rand.nextInt(10);
                if (space.get(0) > 0 && prob < 1) //10% de probabilidades de crear un numero inicial
                {
                    //El valor maximo es el menor entre el espacio y el tamaño del tablero
                    Integer value = 1 + rand.nextInt(Math.min(size, space.get(0)));
                    String s = String.valueOf(value);
                    provisionalNBlues.add(new NBlue(pos, value, space)); //aniadimos una casilla azul al vector que cuenta las casillas azules que hay
                    freeSpace.remove(i); //no pasa nada si este bucle da un tablero incorrecto, porque al inicio del siguiente recuperaremos la copia de seguridad de los espacios vacios
                    nBlues++;
                }
                else
                    i++;
            }
        }


        for (NBlue nblue: provisionalNBlues) {
            tablero.get(nblue.pos._first).set(nblue.pos._sec,String.valueOf(nblue.value));
        }
    }

    //Marca como barreras los espacios encerrados y los elimina de la lista de espacios
    private void fillGaps()
    {
        int i = 0;
        //Recorremos las casillas que no tienen barreras
        while (i<freeSpace.size())
        {
            pair<Integer> pos = new pair<Integer>(freeSpace.get(i)._sec, freeSpace.get(i)._first);
            //FloatPair pos = new FloatPair((int)freeSpace.get(i)._y, (int)freeSpace.get(i)._x);

            //Si no hay espacio significa que estan encerradas y que deben ser barreras
            if (checkSpace(pos._first, pos._sec).get(0) == 0)
            {
                //esta casilla no deberia ser un espacio en blanco. la rellenamos como un muro y la borramos del vector de espacios en blanco
                tablero.get(pos._sec).set(pos._first, "X");
                freeSpace.remove(i);
            }
            else i++;
        }
        minBlues = freeSpace.size() - (int)(freeSpace.size()*0.95);
        //numero maximo de azules iniciales = como maximo puede haber un tercio del total de espacios libres
        maxBlues = freeSpace.size()/3;
    }

    private Boolean solveTablero()
    {

        Boolean solvable = true; //si resulta que no se puede resolver, se cortará el bucle y se devolverá false
        Boolean solved = false; //si lo resuelve, lo mismo pero devolviendo true

        while (solvable && !solved)
        {
            updateBlues();
            int i = 0;
            Boolean flag = true;

            while (i < numberedBlues.size() && flag)
            {
                NBlue b = numberedBlues.get(i);

                if(_pistas.PistaDiez(b)){
                    solvable = false;
                    flag = false;
                }

                if(_pistas.PistaUno(b))
                {
                    fillSidesBarrier(b);
                    flag = false;
                }

                if(_pistas.PistaTres(b))
                {
                    int dir = _pistas.PistaOcho(b);
                    if(dir != 0)fillDirectionBlue(b, dir);

                    else if(_pistas.PistaNueve(b)) fillAllDirections(b);
                    flag = false;
                }

                if(_pistas.PistaDos(b) != 0)
                {
                    fillDirectionBlue(b, _pistas.PistaDos(b));
                    flag = false;
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
            if(tablero.get(freeSpace.get(i)._sec).get(freeSpace.get(i)._first) == " ") flag = true;
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
        int x = b.pos._first;
        int y = b.pos._sec;
        Vector<Integer> adjacent = checkAdjacentBlues(x, y);

        tablero.get(y - (adjacent.get(1) + 1)).set(x, "X");
        tablero.get(y + (adjacent.get(2) + 1)).set(x, "X");
        tablero.get(y).set(x - (adjacent.get(3) + 1), "X");
        tablero.get(y).set(x + (adjacent.get(4) + 1), "X");
    }

    private void fillDirectionBlue(NBlue b, int dir)
    {
        int sign = -1 + 2 * (dir % 2);
        int x = b.pos._first;
        int y = b.pos._sec;
        Vector<Integer> adjacent = checkAdjacentBlues(x, y);

        if(dir < 2) tablero.get(y + ((adjacent.get(1) + 1) * sign)).set(x, ".");
        else tablero.get(y).set(x + ((adjacent.get(4) + 1) * sign), ".");
    }

    private void fillAllDirections(NBlue b)
    {
        int x = b.pos._first;
        int y = b.pos._sec;

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
            int x = numberedBlues.get(i).pos._first;
            int y = numberedBlues.get(i).pos._sec;
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

            space.add(directionSpace);
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
            if(freeSpace.get(i)._first == x && freeSpace.get(i)._sec == y) found = true;
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
    private Vector<Vector<String>> tablero = new  Vector<Vector<String>>();
    private Vector<pair<Integer>> freeSpace = new Vector<pair<Integer>>();
    private Vector<NBlue> numberedBlues = new Vector<NBlue>() ;
    private Pistas _pistas;
    int minBarriers;
    //numero maximo de barreras = como maximo puede haber un tercio del total
    int maxBarriers;
    //numero minimo requerido de azules iniciales = minimo un 5% del total de espacios libres
    int minBlues;
    //numero maximo de azules iniciales = como maximo puede haber un tercio del total de espacios libres
    int maxBlues;

}

