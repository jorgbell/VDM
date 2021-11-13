#pragma once
#include <string>
#include <vector>
#include <time.h>

using namespace std;

struct POS
{
	int x, y;
};

struct NBLUE
{
	POS pos;
	int visibleBlues = 0;
};

class Tablero
{
public:
	Tablero(int s) : size(s), N_CASILLAS(s*s) { init(); };
	void print();
private:
	int size;
	int N_CASILLAS;
	vector<vector<string>> tablero;
	vector<POS>freeSpace;
	vector<NBLUE>numberedBlues;
	void init();
	void generateBarriers();
	void generateBlues();
	void fillGaps();
	vector<int> checkSpace(int x, int y);
	int checkBlues(int x, int y);
};

