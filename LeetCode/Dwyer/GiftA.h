#pragma once
#include "Gift.h"
#include <iostream>
using namespace std;
class GiftA:public Gift
{
public:
	GiftA();
	~GiftA();
	void showGift() {
		cout << "GiftA" << endl;
	}
};

