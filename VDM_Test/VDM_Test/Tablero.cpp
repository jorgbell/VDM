#include "Tablero.h"

#include <iostream>
#include <random>

void Tablero::print()
{
	string bar;

	//for (int i = 0; i < size * 3; i++) cout << "\n";

	for (int i = 0; i < size; i++)
	{
		bar += "+---";
	}

	bar += "+\n";

	for (int i = 1; i < size + 1; i++) 
	{
		cout << bar;

		for (int j = 1; j < size + 1; j++) 
		{
			cout << "| " << tablero[i][j] << " ";
		}

		cout << "|\n";
	}

	cout << bar;
}

void Tablero::init()
{
	srand((unsigned int)time(NULL));

	// numero de paredes rojas aleatorias
	//paredes inamovibles se marcan con una X

	//inicializamos un tablero vacío

	vector<char> v1;

	tablero.push_back(v1);

	for (int j = 0; j < size + 2; j++) tablero[0].push_back('X');

	for (int i = 1; i < size + 1; i++) 
	{
		vector<char> v2;
		tablero.push_back(v2);

		tablero[i].push_back('X');

		for (int j = 1; j < size + 1; j++)
		{
			if (rand() % 2 == 0)
			{
				tablero[i].push_back('X');
			}

			else
			{
				tablero[i].push_back(' ');
				freeSpace.push_back({ j, i });
			}
		}

		tablero[i].push_back('X');
	}

	tablero.push_back(v1);

	for (int j = 0; j < size + 2; j++) tablero[size + 1].push_back('X');


	print();
	fillGaps();
	print();
}

//Comprobacion del espacio disponible
int Tablero::checkSpace(int x, int y)
{
	int space = 0;
	int sign, j;
	bool barrier = false;

	for(int i = 0; i < 2; i++)
	{
		j = 1;
		sign = -1 + 2 * (i % 2);
		
		while (!barrier)
		{
			if (tablero[y + j * sign][x] == 'X') barrier = true;
			else
			{
				space++;
				j++;
			}
		}

		barrier = false;
	}

	for (int i = 0; i < 2; i++)
	{
		j = 1;
		sign = -1 + 2 * (i % 2);

		while (!barrier)
		{
			if (tablero[y][x + j * sign] == 'X') barrier = true;
			else
			{
				space++;
				j++;
			}
		}

		barrier = false;
		j = 0;
	}

	return space;
}

//Marca como barreras los espacios encerrados y los elimina de la lista de espacios
void Tablero::fillGaps()
{
	std::vector<POS>::iterator it = freeSpace.begin();

	while (it != freeSpace.end())
	{
		int y = (*it).y;
		int x = (*it).x;

		if (checkSpace(x, y) == 0)
		{
			tablero[y][x] = 'X';
			it = freeSpace.erase(it);
		}

		else it++;
	}
}
