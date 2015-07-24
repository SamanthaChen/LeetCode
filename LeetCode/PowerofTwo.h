#pragma once
//Given an integer, write a function to determine if it is a power of two.
//判断是不是2的次方
class PowerofTwo
{
public:
	PowerofTwo();
	~PowerofTwo();

	bool isPowerOfTwo(int n) {
		//两个int可以直接做与运算，不需要考虑转换为二进制什么的
		//n&n-1 始终是0，如果是2的次方的话
		return (n>0 && ((n&(n - 1)) == 0));
	}
};

