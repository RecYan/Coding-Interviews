
# <div align=center>剑指offer java实现</div>

+ [查找二维数组中的数字](#1)
+ [替换字符串中的空格](#2)


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



