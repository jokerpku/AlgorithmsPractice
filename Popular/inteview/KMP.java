package inteview;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by Simple on 2016/12/8.
 */
public class KMP {

    // next数组的含义即为如果str数组中i位置没有匹配上，则应该跳到next[i]位置重新开始匹配
    public int[] getNext(String str) {
        if(str == null || str.length() == 0) {
            return new int[0];
        }
        int len = str.length();
        int[] next = new int[len+1];
        next[0] = 0;
        next[1] = 0;
        int j = 0; // 目前匹配到的最大公共子串的位置+1，即长度
        for(int i = 1; i < len; i++) {
            while(j > 0 && str.charAt(j) != str.charAt(i)) {
                j = next[j];
            }
            if(str.charAt(j) == str.charAt(i)) {
                j++;
            }
            next[i+1] = j;
        }

        return next;
    }

    public List<Integer> kmp(String a, String b) {
        if(a == null || b == null || b.length() == 0 || a.length() < b.length()) {
            return Collections.emptyList();
        }
        List<Integer> res = new LinkedList<Integer>();
        int[] next = getNext(b);
        int j = 0; // 目前匹配到的b串中的位置
        for(int i = 0; i < a.length(); i++) {
            while(j > 0 && a.charAt(i) != b.charAt(j)) {
                j = next[j];
            }
            if(a.charAt(i) == b.charAt(j)) {
                j++;
            }
            if(j == b.length()) {
                res.add(i-j+1);
            }
        }
        return res;
    }
}
