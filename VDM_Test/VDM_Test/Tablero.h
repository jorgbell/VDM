#pragma once
#include <string>
#include <vector>

using namespace std;

class Tablero
{
public:
	Tablero(int s) : size(s), N_CASILLAS(s*s) { init(); };
	void print();
private:
	int size;
	int N_CASILLAS;
	vector<vector<char>> tablero;
	void init();
};

