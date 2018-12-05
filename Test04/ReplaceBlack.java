package Test04;

/**
 * Created by Yan_Jiang on 2018/12/5.
 *
 * 实现一个函数，把字符串中的每个空格替换成"%20"，例如“We are happy.”，则输出“We%20are%20happy.”
 */
public class ReplaceBlack {

    public static void main(String[] args) {

        String s = "We are happy";
        System.out.println(method1(s));

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

    //手动实现算法
    public static String method3(String s) {
        return null;
    }


}
