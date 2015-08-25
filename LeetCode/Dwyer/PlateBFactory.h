#pragma once
#include "Factory.h"
#include "PlateB.h"
#include "GiftB.h"
class PlateBFactory:public Factory
{
public:
	PlateBFactory();
	~PlateBFactory();
	Plate * createPlate() {
		return new PlateB();
	}
	Gift * createGift() {
		return new GiftB();
	}
};

