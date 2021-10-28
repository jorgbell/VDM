#include "Tablero.h"

#include <iostream>

void Tablero::print()
{
	for (string s : tablero) {
		cout << "----------------------------------\n";
		cout << s << "\n";
	}
	cout << "----------------------------------\n";
}

void Tablero::init()
{

	// numero de paredes rojas aleatorias
	//paredes inamovibles se marcan con una X

	//inicializamos un tablero vacío
	string linea = "| | | | |";
	for (int i = 0; i < size; i++) { tablero.push_back(linea); }

	//numero de paredes aleatoria entre 1 y size
	int nParedes = rand() % size +1;
	//colocamos las paredes en sitios aleatorios
	




}
