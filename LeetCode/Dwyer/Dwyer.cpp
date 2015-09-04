// Dwyer.cpp : 定义控制台应用程序的入口点。
//

#include "stdafx.h"
#include "QuickSort.h"
#include "PlateAFactory.h"
#include "PlateBFactory.h"
#include "Derived.h"
#include "DerivedDerived.h"
#include "Context.h"
#include "StrategyA.h"
#include "StrategyB.h"
int main()
{
	/*虚函数
	Base A;
	Base B;
	Derived C;
	Derived D;
	DerivedDerived dd;
	Base &e = C;
	Base *f = &D;
	Derived *g = &dd;
	g->print();
	g->show();
	e.print();
	f->print();*/

	//工厂模式
	/* 
	Factory* A = new PlateAFactory();
	Plate *p = A->createPlate();
	Gift *pg = A->createGift();
	p->setPrice();
	pg->showGift();

	Factory* B = new PlateBFactory();
	Plate* q = B->createPlate();	
	Gift *qg = B->createGift();
	q->setPrice();
	qg->showGift();
    */

	//策略模式
	Context *c = new Context();
	Strategy *s = new StrategyA();
	c->setS(s);
	c->algorithm();
	s = new StrategyB();
	c->setS(s);
	c->algorithm();
	return 0;
}

