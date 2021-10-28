#include "Tablero.h"

#include <iostream>
#include <random>

void Tablero::print()
{
	string bar;

	for (int i = 0; i < size; i++)
	{
		bar += "+---";
	}

	bar += "+\n";

	for (int i = 0; i < size; i++) 
	{
		cout << bar;

		for (int j = 0; j < size; j++) 
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

	for (int i = 0; i < size; i++) 
	{
		vector<char> v;
		tablero.push_back(v);

		for (int j = 0; j < size; j++)
		{
			if (rand() % size + 1)
			{
				tablero[i].push_back('X');
			}
			else tablero[i].push_back(' ');
		}
	}

	//numero de paredes aleatoria entre 1 y size
	int nParedes = rand() % size +1;
	//colocamos las paredes en sitios aleatorios
	




}
