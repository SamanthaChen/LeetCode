// Dwyer.cpp : 定义控制台应用程序的入口点。
//

#include "stdafx.h"
#include "QuickSort.h"
#include "PlateAFactory.h"
#include "PlateBFactory.h"
#include "Derived.h"
#include "DerivedDerived.h"
int main()
{
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
	f->print();

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
	return 0;
}

