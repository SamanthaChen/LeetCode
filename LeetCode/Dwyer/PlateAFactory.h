#pragma once
#include "Factory.h"
#include "PlateA.h"
#include "GiftA.h"
class PlateAFactory:public Factory
{
public:
	PlateAFactory();
	~PlateAFactory();
	Plate * createPlate() {
		return new PlateA();
	}
	Gift* createGift() {
		return new GiftA();
	}
};