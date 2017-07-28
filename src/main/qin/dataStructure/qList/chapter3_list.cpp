// chapter3_list.cpp : 定义控制台应用程序的入口点。
//

#include "stdafx.h"
#include "stdio.h"    

/* 存储空间初始分配量*/
#define MAXSIZE 20

//////////////////////////////////新增变量
#define OK 1
#define ERROR 0
#define TRUE 1
#define FALSE 0
/* 函数的类型, 值是函数结果状态代码如ok等*/
typedef int Status;
//////////////////////////////////新增变量

/* 根据实际情况而定 这里假设为int*/
typedef int ElemType;

/*
	发现描述顺序存储结构需要三个属性:
	1.其实位置 data 存储位置就是存储空间的存储位置
	2.线性表的最大存储容量 数组长度MAXSIZE
	3.线性表的当前长度 length
	*/
typedef struct
{
	/* 数组存储数据元素, 最大值为MAXSIZE */
	ElemType data[MAXSIZE];
	/* 线性表当前长度*/
	int length;
}SqList;

/*
	对于线性表的顺序存储结构来说
	如果我们要实现GetElem操作
	即线性表L中的第i个位置元素值返回 其实是非常简单的
	只要i的数值在数组下标范围内 就是把数组第i-1下标的值返回即可
	初始条件 顺序线性表L已存在 1<=i<=ListLength(L)
	操作结果 用e返回L中第i个数据元素的值
	*/
Status GetElem(SqList L, int i, ElemType *e)
{
	if (L.length == 0 || i < 1 || i > L.length) { return ERROR; }
	*e = L.data[i - 1];
	return OK;
}

//插入
/*
	初始条件 顺序线性表L已存在 1<=i<=ListLength(L)
	操作结果 在L中第i个位置之前插入新的数据元素e L的长度加1
*/
Status ListInsert(SqList *L, int i, ElemType e)
{
	//抽取存储结构长度变量
	int length_ = L->length;

	//线性表已满
	if (length_ == MAXSIZE) return ERROR;
	if (i < 1 || i > length_ + 1) return ERROR;
	//插入数据不在表尾
	if (i <= length_)
	{
		//将要插入位置后数据元素向后移动一位
		for (int k = length_ - 1; k >= i - 1; k--)
		{
			L->data[k + 1] = L->data[k];
		}
	}

	//将新元素插入
	L->data[i - 1] = e;
	length_++;
	return OK;
}

int main()
{
	return 1;
}
