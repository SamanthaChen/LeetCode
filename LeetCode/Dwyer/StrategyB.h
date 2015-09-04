#pragma once
#include "../LeetCode.h"
#include "Strategy.h"
class StrategyB :public Strategy
{
public:
	StrategyB();
	~StrategyB();
	void algorithm() {
		cout << "use B" << endl;
	}
};

