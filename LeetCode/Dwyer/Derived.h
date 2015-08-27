#pragma once
#include <iostream>
#include "Base.h"
using std::cout;
using std::endl;
class Derived:public Base
{
public:
	Derived();
	~Derived();
	void print() {
		cout << "derived" << endl;
	}
	virtual void show() {
		cout << "show deriver" << endl;
	}
};

