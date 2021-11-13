public class Pistas 
{
    Bool PistaUno()
    {
        return seenBlues[0] == value;
    }

    int PistaDos()
    {
        if(seenBlues[0] > value) 
        {

        }

        else return false;
    }

    int PistaTres()
    {
        if(seenBlues[0] < value)
        {
            Bool found = false;
            int i = 1;
            while(i <= 4 && !found)
            {
                if(seenBlues[i] < space[i]) found = true;

                else i++;
            }

            if (found) return i;
            else return 0;
        }

        else return 0;
    }

    Bool PistaCuatro()
    {
        return seenBlues[0] > value;
    }

    Bool PistaCinco()
    {
        if(seenBlues[0] < value)
        {
            Bool found = false;
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

    Bool PistaSeis()
    {
        return space[0] == 0;
    }

    Bool PistaSiete()
    {
        return (seenBlues[0] == 0 && space[0] == 0); 
    }

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

    Bool PistaNueve()
    {
        if(seenBlues[0] < value) 
        {
            return space[0] == value;
        }

        else return false;
    }

    Bool PistaDiez()
    {
        return space[0] < value;
    }
}
