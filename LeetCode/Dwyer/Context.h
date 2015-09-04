#pragma once
#include "Strategy.h"
#include "../LeetCode.h"
class Context
{
public:
	Context();
	~Context();
	void algorithm() {
		s->algorithm();
	}
	void setS(Strategy *s) {
		this->s = s;
	}
private:
	Strategy *s;
};

