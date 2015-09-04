#pragma once
#include "Strategy.h"
#include "../LeetCode.h"
class StrategyA:public Strategy
{
public:
	StrategyA();
	~StrategyA();
	void algorithm() {
		cout << "use A" << endl;
	}
};

