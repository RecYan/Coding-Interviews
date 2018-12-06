package Test04;

/**
 * Created by Yan_Jiang on 2018/12/5.
 *
 * 实现一个函数，把字符串中的每个空格替换成"%20"，例如“We are happy.”，则输出“We%20are%20happy.”
 */
public class ReplaceBlank {

    public static void main(String[] args) {

        String s = "We are happy";
        System.out.println(method1(s));
        System.out.println(method2(s));
        System.out.println(method3(s));

    }

    //使用StringAPI来解决
    public static String method1(String s) {

        if (s == null || s.length() <= 0) {
            return null;
        }
        return s.replace(" ", "%20");
    }

    //使用StringBuffer
    public static String method2(String s) {

        if (s == null || s.length() <= 0) {
            return null;
        }
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < s.length(); i++) {
            if(s.charAt(i) == ' '){
                sb.append("%20");
            }else{
                sb.append(s.charAt(i));
            }
        }
        return sb.toString();

    }

    //手动实现算法 -- 为了减少数组中字符的移动次数，将从后向前进行替换操作<所有的字符都只移动一次>
    public static String method3(String s) {
        if (s == null || s.length() <= 0) {
            return "输出的字符串错误";
        }
        //计算字符串中空格数量
        int blankNum = 0;
        for (int i = 0; i < s.length(); i++) {
            if(s.charAt(i) == ' ') {
                blankNum ++;
            }
        }
        // 扩容字符串数组长度
        char[] newChar = new char[s.toCharArray().length + blankNum * 2];

        int p1 = s.length() - 1; //指向初始数组尾部
        int p2 = newChar.length - 1; //指向扩容后数组尾部

        while(p1 >= 0 && p2 >=0) {
            if(s.toCharArray()[p1] == ' ') { //p1遇到空格 p2进行替换
                newChar[p2--] = '0';
                newChar[p2--] = '2';
                newChar[p2--] = '%';
            } else { //移动数组中的字符
                newChar[p2--] = s.toCharArray()[p1];
            }
            p1 --;
        }


        return new String(newChar,0,newChar.length);
    }


}
