
# <div align=center>剑指offer java实现</div>

+ [查找二维数组中的数字](#1)    &nbsp; 
+ [替换字符串中的空格](#2)
+ [从尾到头打印链表](#3)
+ [重构二叉树](#4)
+ [两个栈模拟队列、两个队列模拟栈](#5)

---
<a name="1"></a>
1.查找二维数组中的数字
``` java
题目：
在一个二维数组中，每一行都按照从左到右递增的顺序排序，每一列都按照从上到下递增的顺序排序。
请完成一个函数，输入这样的一个二维数组和一个整数，判断数组中是否含有该整数。

思路：
1. 若数组未排序 则先排序
2. 按排序顺序，确定查找的位置，eg：若行、列升序，则从右上或坐下开始
3. 选取数组中右上角的数字。如果该数字等于要查找的数字，查找过程结束；
   如果该数字大于要查找的数字，去除这个数字所在的列；
   如果该数字小于要查找的数字，去除这个数字所在的行。

```
<a name="2"></a>
2.替换字符串中的空格
``` java
题目：
请实现一个函数，把字符串中的每个空格替换成“%20”。例如输入“We are happy"，则输出”We%20are%20happy"

思路：
O(n)复杂化度：[从后向前遍历 计算出空格个数 --> 推算出扩容后的字符串长度]
准备两个指针，P1和P2.   
P1指向原始字符串的末尾，而P2指向替换之后的字符串的末尾
向前移动指针P1,逐个把它指向的字符复制到P2指向的位置，直到碰到空格为止

```
![替换字符串中的空格](https://i.imgur.com/dkyCBV2.jpg)

<a name="3"></a>
3.从尾到头打印链表
``` java
题目：
输入个链表的头结点，从尾到头反过来打印出每个结点的值。 例如[1 2 3 4 5] --> [5 4 3 2 1] 

思路：
//不改变链表结构
使用栈结构先进后出的特点，完成链表的逆序输出
递归实现，链表首节点开始进行递归，直到尾部为止，每次递归时都将当前结点的值加入列表中
//改变链表结构 -- 使用pre和next指针帮助实现
next和pre分别记录当前节点的下一个结点和当前节点的上一个结点，
将当前结点的pre指针指向next
pre和当前节点指针都向后移位，继续下面节点的处理

```

<a name="4"></a>
4.重构二叉树
``` java

题目：
输入某二叉树的前序遍历和中序遍历的结果，请重建出该二叉树。假设输入的前序遍历和中序遍历的结果中都不含重复的数字。
例如：前序遍历序列｛ 1, 2, 4, 7, 3, 5, 6, 8｝和中序遍历序列｛4, 7, 2, 1, 5, 3, 8，6}，重建出下图所示的二叉树并输出它的头结点。

思路：
根据前序序列 确定根节点的值
根据中序序列确定 根节点左右子树的序列元素个数
调用递归 实现 左右子树的构建

```
![重构二叉树](https://i.imgur.com/4g1m0Nt.jpg)

<a name="5"></a>
5.两个栈模拟队列、两个队列模拟栈
``` java
题目：
1.两个栈模拟队列
2.两个队列模拟栈
思路：
1.所有元素进stack1，然后全部出stack1并进入stack2.实现队列的先进先出
若要给队列添加元素，即先进sack1,要出队时，若stack2不为空就出栈，为空时就把stack1全部进栈到stack2
2.把非空队列的n-1个压人空对列，剩的第n个出对，即总有一个队列为空 --> 模拟出栈
将元素入(空)队 --> 模拟压栈

```
![两个栈模拟队列](https://i.imgur.com/XNGygta.jpg)
![两个队列模拟栈](https://i.imgur.com/W3UXHak.jpg)





