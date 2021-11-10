// VDM_Test.cpp : Pruebas para la lógica del juego, fuera de Android Studio. Si todo va bien, luego copiar y pegar
//

#include <iostream>
#include "Tablero.h"
int main()
{
    Tablero* t = new Tablero(10);

    //t->print();

    delete t; t = nullptr;
}
