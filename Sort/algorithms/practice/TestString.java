package algorithms.practice;

/**
 * Created by Simple on 2016/11/8.
 */
public class TestString {
    public static void main(String[] args) {
        StringBuilder str = new StringBuilder("一二三四五六七");
//        StringBuilder str = new StringBuilder("abcdefg");
        str.reverse();
        System.out.println(str);
        System.out.println(reverse2(str.toString()));
    }

    public static String reverse2(String s){
        //若参数为空或去掉两边空格为"" 返回值为参数自身
        if (s==null||s.trim()=="") {
            return s;
        }
        //获得字符串的字符数组
        char[] chs = s.toCharArray();
        //获得字符串的长度
        int length = s.length();
        //循环交换数组中对称位置的字符
        for (int i = 0; i < length/2; i++) {
            char c = chs[i];
            chs[i]=chs[length-1-i];
            chs[length-1-i]=c;
        }
        //返回由交换过的数组构成的新字符串
        return new String(chs);
    }
}
