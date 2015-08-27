#pragma once
#include <iostream>
using std::cout;
using std::endl;
class Base
{
public:
	Base();
	~Base();
	virtual void print() {
		cout << "base" << endl;
	}
	virtual void show() {
		cout << "show base" << endl;
	}
};

