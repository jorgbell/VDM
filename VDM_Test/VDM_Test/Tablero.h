#pragma once
#include <string>
#include <vector>
#include <time.h>

using namespace std;

struct POS
{
	int x, y;
};

class Tablero
{
public:
	Tablero(int s) : size(s), N_CASILLAS(s*s) { init(); };
	void print();
private:
	int size;
	int N_CASILLAS;
	vector<vector<char>> tablero;
	vector<POS>freeSpace;
	void init();
	void fillGaps();
	int checkSpace(int x, int y);
};

