package jian.zhi.offer;

import java.util.Arrays;
import java.util.Comparator;

/**
 * 输入一个正整数数组，把数组中所有的数字拼接成一个数字，找出最小的数字
 * Created by Simple on 2017/1/1.
 */
public class PrintMinNumber {
    public String getMinNumber(int[] nums) {
        if(nums == null || nums.length == 0) {
            return "";
        }

        String[] strs = new String[nums.length];
        for(int i = 0; i < nums.length; i++) {
            strs[i] = String.valueOf(nums[i]);
        }

        Arrays.sort(strs, new Comparator<String>() {
            @Override
            public int compare(String n1, String n2) {
                String str1 = n1 + n2;
                String str2 = n2 + n1;
                return str2.compareTo(str1);
            }
        });

        StringBuilder builder = new StringBuilder();
        for(String str : strs) {
            builder.append(str);
        }
        return builder.toString();
    }

    public static void main(String[] args) {
        PrintMinNumber instance = new PrintMinNumber();
        int[] nums = {12, 34, 0};
        String res = instance.getMinNumber(nums);
        System.out.println(res);
    }
}
