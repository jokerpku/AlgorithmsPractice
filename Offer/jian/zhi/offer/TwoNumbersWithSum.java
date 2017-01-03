package jian.zhi.offer;

/**
 * 问题一：给定一个排序数组和数字sum，找出数组中两个数字的和为sum的组合，若有多对，则找出任意一对即可。
 * 两个指针分别指向数组首尾，从两头向中间遍历。
 * 问题二：给定正整数sum，找出所有和为sum的连续正整数序列（至少包含两个数字），如sum=15，则有三个序列1~5,4~6，7~8
 * 用两个数small和big分别表示序列的最小值和最大值，初始为1,2，向后扫描
 * Created by Jokeria on 2017/1/3.
 */
public class TwoNumbersWithSum {
    public int[] twoNumbersWithSum(int[] nums, int sum) {
        if(nums == null || nums.length < 2) {
            return null;
        }

        int lo = 0;
        int hi = nums.length - 1;
        while(lo < hi) {
            int temp = (nums[lo] + nums[hi]);
            if(temp < sum) {
                lo++;
            } else if(temp > sum) {
                hi--;
            } else {
                int[] res = new int[2];
                res[0] = nums[lo];
                res[1] = nums[hi];
                return res;
            }
        }

        return null;
    }

    public void continuesSequenceWithSum(int sum) {
        if(sum <= 2) {
            return;
        }

        int small = 1;
        int big = 2;
        int count = 3;
        while(small != big && small <= (sum - 1)/2) {
            if(sum > count) {
                big++;
                count += big;
            } else if(sum < count) {
                count -= small;
                small++;
            } else {
                printContinuesSequence(small, big);
                big++;
                count += big;
            }
        }

    }

    void printContinuesSequence(int small, int big) {
        for(int i = small; i <= big; i++) {
            System.out.print(i + " ");
        }

        System.out.println();
    }

    public static void main(String[] args) {
        TwoNumbersWithSum instance = new TwoNumbersWithSum();
//        int[] nums = {1,2,3,4,5,6,7,8,9};
//        int[] res = instance.twoNumbersWithSum(nums, 8);
//        System.out.println(res[0] + " " + res[1]);
        instance.continuesSequenceWithSum(100);

    }
}
