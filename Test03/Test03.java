package Test03;

/**
 * Created by Yan_Jiang on 2018/12/1.
 * 题目：
 * 在一个二维数组中，每一行都按照从左到右递增的顺序排序，每一列都按照从上到下递增的顺序排序。
 * 请完成一个函数，输入这样的一个二维数组和一个整数，判断数组中是否含有该整数。
 *
 * 数组：按连续的内存空间顺序存储数据，需要预分配内存空间 --> 空间效率较差
 *      按下标查找数据较快O(1) --> 时间效率较好
 *
 * 思路：选取数组中右上角的数字。如果该数字等于要查找的数字，查找过程结束：
 *      如果该数字大于要查找的数字，剔除这个数字所在的列：如果该数字小于要查找的数字，剔除这个数字所在的行。
 */
public class Test03 {

    public static void main(String[] args) {

        int[][] a = {
                {1, 2, 8, 9},
                {2, 4, 9, 12},
                {4, 7, 10, 13},
                {6, 8, 11, 15}
        };
        System.out.println(findNum(a,8));

    }

    public static boolean findNum(int[][] a, int num) {

        int rows = a.length; //行
        int cols = a[0].length; //列

        int row = 0; // 起始开始的行号
        int col = cols - 1; // 起始开始的列号

        // 要查找的位置确保在数组之内 -- 右上角开始查找
        while (row >= 0 && row < rows && col >= 0 && col < cols) {
            if (a[row][col] == num) { // 如果找到了就直接退出
                return true;
            } else if (a[row][col] > num) { // 如果找到的数比要找的数大，说明要找的数在当前数的左边
                col--; // 列数减一，代表向左移动
            } else { // 如果找到的数比要找的数小，说明要找的数在当前数的下边
                row++; // 行数加一，代表向下移动
            }
        }

        return false;
    }

}
