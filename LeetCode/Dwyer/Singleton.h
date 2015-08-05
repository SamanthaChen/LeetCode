//这个是懒汉模式
#pragma once
#include "../LeetCode.h"
class Singleton
{
public:
	Singleton();
	~Singleton();
	//需要加锁并且两次判断是不是空
	static Singleton* instance() {
		if (m_instance == NULL) {
			//lock();  //要加 但是我还没搞懂c++的lock
			if (m_instance == NULL) {
				m_instance = new Singleton();
			}
			//unlock();
		}
		return m_instance;
	}
	static Singleton* freeInstance() {
		delete m_instance;
		m_instance = NULL;
	}
private:
	static Singleton* m_instance;
};

