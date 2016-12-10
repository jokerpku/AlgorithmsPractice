package Sort.Review;

import algorithms.practice.SortAlgorithm;
import practice.util.Util;

/**
 * Created by Simple on 2016/12/8.
 */
public class QuickSort extends SortAlgorithm {
    private int partition(Comparable[] nums, int start, int end) {
        Comparable value = nums[start];
        int lo = start;
        int hi = end+1;
        while(true) {
            while(less(nums[++lo], value)) {
                if(lo == end) {
                    break;
                }
            }
            while(less(value, nums[--hi])) {
                if(start == hi) {
                    break;
                }
            }
            if(lo >= hi) {
                break;
            }
            exch(nums, lo, hi);
        }
        exch(nums, start, hi);
        return hi;
    }


    private void sort(Comparable[] nums, int lo, int hi) {
        if(lo >= hi) {
            return;
        }
        int mid = partition(nums, lo, hi);
        sort(nums, lo, mid-1);
        sort(nums, mid+1, hi);
    }

    public void sort(Comparable[] nums) {
        if(nums == null) {
            return;
        }
        sort(nums, 0, nums.length-1);
    }

    public static void main(String[] args) {
        Integer[] array = Util.getRandomArray();
        QuickSort instance = new QuickSort();
        instance.sort(array);
        instance.show(array);
    }

}
