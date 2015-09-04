#pragma once
class Strategy
{
public:
	Strategy();
	~Strategy();
	virtual void algorithm() = 0;
};

