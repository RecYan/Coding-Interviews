package Test03;

import org.junit.Test;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by Yan_Jiang on 2018/12/3.
 * 服务于Test03:
 *  对于任意一个无序二维数组，将其排序为行、列 递增的二维数组
 */
public class SortArray {

    @Test
    public void method1() {

        /*Scanner scanner = new Scanner(System.in);
        int[][] a = new int[4][4];
        for (int i = 0; i < 4; i++) { //行
            for (int j = 0; j < 4; j++) { //列
              a[i][j] = scanner.nextInt();
            }
        }*/


        int[][] a = new int[][]{{12, 3, 14, 11}, {1, 2, 6, 4}, {5, 15, 7, 8}, {16, 9, 10, 13}};
        int[] b = new int[16];

        for (int i = 0; i < 4; i++) {           //把二维数组变为一维数组
            for (int j = 0; j < 4; j++) {
                b[4 * i + j] = a[i][j];
            }
        }

        /*for (int i = 0; i < b.length; i++) {        //对一维数组进行排列
            for (int j = 1 + i; j < b.length; j++) {
                if (b[i] > b[j]) {
                    int num = 0;
                    num = b[i];
                    b[i] = b[j];
                    b[j] = num;
                }
            }
        }*/
        Arrays.sort(b); //一维数组升序排序

        for (int i = 0; i < 4; i++) { //再将一维数组变为二维数组
            for (int j = 0; j < 4; j++) {
                a[i][j] = b[4 * i + j];
            }
        }

        for (int i = 0; i < 4; i++) { //对二维数组进行输出
            int count = 0;
            for (int j = 0; j < 4; j++) {
                count++;
                System.out.print(a[i][j] + " ");
                if (count == 4) {
                    System.out.println();
                }
            }

        }
    }

            /* out
            1 2 3 4
            5 6 7 8
            9 10 11 12
            13 14 15 16
            */


}
