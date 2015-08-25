#pragma once
#include "Gift.h"
#include <iostream>
using namespace std;
class GiftB:public Gift
{
public:
	GiftB();
	~GiftB();
	void showGift() {
		cout << "GiftB" << endl;
	}
};

