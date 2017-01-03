package jian.zhi.offer;

import java.util.Arrays;

/**
 * 数组中的两个数字，如果前面的数字大于后面的数字，则这两个数字构成一个逆序对；给定一个数组，求这个数组的逆序对数量
 * Created by Simple on 2017/1/1.
 */
public class ReversePairs {
    public int getReversePairs(int[] nums) {
        if(nums == null || nums.length <= 1) {
            return 0;
        }

        int[] aux = new int[nums.length];
        return getReversePairs(nums, aux, 0, nums.length - 1);
    }

    int getReversePairs(int[] nums, int[] aux, int lo, int hi) {
        if(lo >= hi) {
            return 0;
        }

        int mid = lo + (hi - lo) / 2;
        int left = getReversePairs(nums, aux, lo, mid);
        int right = getReversePairs(nums, aux, mid+1, hi);
        int merge = countWhenMerge(nums, aux, lo, mid, hi);

        return left + right + merge;
    }

    int countWhenMerge(int[] nums, int[] aux, int lo, int mid, int hi) {
        for(int i = lo; i <= hi; i++) {
            aux[i] = nums[i];
        }

        int count = 0;
        int left = lo;
        int right = mid + 1;
        int index = lo;
        while(left <= mid && right <= hi) {
            if(aux[left] <= aux[right]) {
                nums[index] = aux[left];
                left++;
            }

            if(aux[right] < aux[left]) {
                nums[index] = aux[right];
                count += mid - left + 1;
                right++;
            }

            index++;
        }

        while(left <= mid) {
            nums[index] = aux[left];
            index++;
            left++;
        }

        while(right <= hi) {
            nums[index] = aux[right];
            index++;
            right++;
        }

        return count;
    }

    public static void main(String[] args) {
        ReversePairs instance = new ReversePairs();
        int[] nums = {7,5,6,4,3};
        int res = instance.getReversePairs(nums);
        System.out.println(res);
    }

}
