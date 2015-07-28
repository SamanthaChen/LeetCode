#include "stdafx.h"
#include "StrBlob.h"


StrBlob::StrBlob()
{
}


StrBlob::~StrBlob()
{
}

void StrBlob::check(size_type i, const string &msg) const
{
	if (i >= data->size())
		throw out_of_range(msg);
};

const string&  StrBlob::front()
{
	check(0, "front on empty StrBlob");
	return data->front();
}

const string& const StrBlob::back()
{
	check(0, "back on empty StrBlob");
	return data->back();
}

void StrBlob::pop_back()
{
	check(0, "pop_back on empty StrBlob");
	data->pop_back();
}