#pragma once
#include "Plate.h"
#include <iostream>
using namespace std;
class PlateA:public Plate
{
public:
	PlateA();
	~PlateA();
	void setPrice() {
		cout << "A" << endl;
	}
};

