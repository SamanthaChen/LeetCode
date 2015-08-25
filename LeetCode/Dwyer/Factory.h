#pragma once
#include "Plate.h"
#include "Gift.h"
class Factory
{
public:
	Factory();
	~Factory();
	virtual Plate* createPlate() = 0;
	virtual Gift* createGift() = 0;
};

