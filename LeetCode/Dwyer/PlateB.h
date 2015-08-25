#pragma once
#include "Plate.h"
#include <iostream>
using namespace std;
class PlateB:public Plate
{
public:
	PlateB();
	~PlateB();
	void setPrice() {
		cout << "B" << endl;
	}
};

