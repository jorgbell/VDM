#include "Tablero.h"

#include <iostream>
#include <random>

void Tablero::print()
{
	string bar;

	for (int i = 0; i < size * 2; i++) cout << "\n";

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

	//Las barreras se marcan con una X
	generateBarriers();
	print();

	//Llenamos con barreras las casillas cercadas
	fillGaps();
	print();

	//Generamos casillas azules numeradas de forma aleatoria, siendo el maximo del numero el espacio disponible
	generateBlues();
	print();
}

void Tablero::generateBarriers()
{
	//Generamos el limite horizontal superior del tablero
	vector<string> v1;
	tablero.push_back(v1);
	for (int j = 0; j < size + 2; j++) tablero[0].push_back("X");

	//Generamos barreras de forma aleatoria
	for (int i = 1; i < size + 1; i++)
	{
		vector<string> v2;
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

void Tablero::generateBlues()
{
	std::vector<POS>::iterator it = freeSpace.begin();

	while (it != freeSpace.end())
	{
		int y = (*it).y;
		int x = (*it).x;
		int space = checkSpace(x, y);

		if (space > 0 && rand() % size == 0)
		{
			tablero[y][x] = std::to_string(1 + rand() % space);
			numberedBlues.push_back({x, y});
			it = freeSpace.erase(it);
		}

		else it++;
	}
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
			if (tablero[y + j * sign][x] == "X") barrier = true;
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
			if (tablero[y][x + j * sign] == "X") barrier = true;
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
