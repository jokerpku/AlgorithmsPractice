package jian.zhi.offer;

/**
 * 问题一：输入一个英文句子，翻转句子中单词的顺序，但是单词内字符的顺序不变
 * 问题二：左旋字符串，把字符串前面若干个字符转换到字符串的尾部
 * Created by Jokeria on 2017/1/3.
 */
public class ReverseSentence {
    public String reverseSentence(String sentence) {
        if(sentence == null || sentence.isEmpty()) {
            return sentence;
        }

        String[] strs = sentence.split(" ");
        if(strs.length == 0) {
            return sentence;
        }

        reverseStringArray(strs);

        StringBuilder builder = new StringBuilder(strs[0]);
        for(int i = 1; i < strs.length; i++) {
            builder.append(" " + strs[i]);
        }
        return builder.toString();
    }

    void reverseStringArray(String[] strs) {
        if(strs == null || strs.length == 0) {
            return;
        }

        int lo = 0;
        int hi = strs.length - 1;
        while(lo < hi) {
            String temp = strs[lo];
            strs[lo] = strs[hi];
            strs[hi] = temp;
            lo++;
            hi--;
        }
    }

    public String leftRotateString(String str, int n) {
        if(str == null || str.length() < n) {
            return null;
        }

        StringBuilder left = new StringBuilder(str.substring(0, n));
        StringBuilder right = new StringBuilder(str.substring(n));
        right.append(left);

        return right.toString();
    }

    public static void main(String[] args) {
        ReverseSentence instance = new ReverseSentence();
//        String sentence = " ";//"Hello"; //"Hello World. Liu";
//        String res = instance.reverseSentence(sentence);
//        System.out.println(res);

        String str = "abcdefgh";
        String res = instance.leftRotateString(str, 3);
        System.out.println(res);
    }

}
