package jian.zhi.offer;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个字符串，找出该字符串中字符的所有排列
 * 可扩展至八皇后问题
 * Created by Jokeria on 2016/12/19.
 */
public class Permutation {
    public List<String> permutation(String str) {
        if (str == null || str.isEmpty()) {
            return null;
        }

        List<String> list = new ArrayList<String>();
        permutation(str.toCharArray(), 0, list);

        return list;
    }

    public void permutation(char[] chars, int lo, List<String> list) {
        if (lo == chars.length - 1) {
            list.add(String.valueOf(chars));
            return;
        }

        permutation(chars, lo + 1, list);
        // lo位置元素分别与后面的元素交换，递归求lo之后位置元素的全排列
        for (int i = lo + 1; i < chars.length; i++) {
//            // 排除重复元素 并不能解决有重复元素的问题，如baa
//            if (chars[i] == chars[lo]) {
//                continue;
//            }
            // 交换lo和i位置的元素
            char temp = chars[i];
            chars[i] = chars[lo];
            chars[lo] = temp;
            // 递归求lo位置之后的全排列
            permutation(chars, lo + 1, list);
            // 还原数组，再次交换lo和i位置的元素
            temp = chars[i];
            chars[i] = chars[lo];
            chars[lo] = temp;
        }
    }

    public List<String> combination(String str) {
        if(str == null || str.isEmpty()) {
            return null;
        }

        List<String> list = new ArrayList<String>();
        combination(str.toCharArray(), 0, "", list);
        return list;
    }

    public void combination(char[] chars, int lo, String pre, List<String> list) {
        if(lo >= chars.length) {
            if(!pre.isEmpty()) {
                list.add(pre);
            }
            return;
        }
        combination(chars, lo+1, pre, list);
        combination(chars, lo+1, pre + chars[lo], list);
    }

    public static void main(String[] args) {
        Permutation instance = new Permutation();
//        String str = "abb";
//        List<String> strs = instance.permutation(str);
//        String str = "abc";
//        List<String> strs = instance.combination(str);
//        for(String s : strs) {
//            System.out.print(s + "  ");
//        }
//        System.out.println();

        int[] nums = {1,1,3,4,5,6,7,8};
        instance.isCube(nums);
    }

    public boolean isCube(int[] nums) {
        if(nums == null || nums.length != 8) {
                return false;
        }

        return permination(nums, 0);
    }

    boolean permination(int[] nums, int lo) {
        if(lo == 8) {
            if(isEquals(nums)) {
                for(int num : nums) {
                    System.out.print(num + " ");
                }
                return true;
            }
            return false;
        }

        if(permination(nums, lo + 1)) {
            return true;
        }

        for(int i = lo + 1; i < 8; i++) {
            if(nums[i] != nums[lo]) {
                int temp = nums[i];
                nums[i] = nums[lo];
                nums[lo] = temp;

                if(permination(nums, lo+1)) {
                    return true;
                }
                temp = nums[i];
                nums[i] = nums[lo];
                nums[lo] = temp;
            }
        }

        return false;
    }

    boolean isEquals(int[] nums) {
        if((nums[0] + nums[1] + nums[2] + nums[3] == nums[4] + nums[5] + nums[6] + nums[7])
                && (nums[1] + nums[3] + nums[5] + nums[7] == nums[0] + nums[2] + nums[4] + nums[6])
                && (nums[0] + nums[1] + nums[4] + nums[5] == nums[2] + nums[3] + nums[6] + nums[7])){
            return true;
        } else {
            return false;
        }
    }
}
