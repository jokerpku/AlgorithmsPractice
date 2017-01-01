package jian.zhi.offer;

/**
 * 找出字符串中第一个只出现一次的字符
 * Created by Simple on 2017/1/1.
 */
public class FirstNotRepeatingChar {
    public char firstNotRepeatingChar(String str) {
        if(str == null || str.isEmpty()) {
            return '\0';
        }

        if(str.length() == 1) {
            return str.charAt(0);
        }

        int[] feqs = new int[256];
        for(int i = 0; i < str.length(); i++) {
            feqs[str.charAt(i)]++;
        }

        for(int i = 0; i < str.length(); i++) {
            if(feqs[str.charAt(i)] == 1) {
                return str.charAt(i);
            }
        }
        return '\0';
    }

    public static void main(String[] args) {
        FirstNotRepeatingChar instance = new FirstNotRepeatingChar();
        char c = instance.firstNotRepeatingChar("abaccdeff");
        System.out.println(c);
    }
}
