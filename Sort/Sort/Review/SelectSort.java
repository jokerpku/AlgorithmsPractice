package Sort.Review;

import algorithms.practice.SortAlgorithm;
import practice.util.Util;

/**
 * Created by Jokeria on 2016/12/10.
 */
public class SelectSort extends SortAlgorithm {
    @Override
    public void sort(Comparable[] nums) {
        if(nums == null || nums.length == 0) {
            return;
        }

//        for(int len = nums.length - 1; len >= 1; len--) {
//            int max = 0;
//            for(int i = 1; i <= len; i++) {
//                if(less(nums[max], nums[i])) {
//                    max = i;
//                }
//            }
//            exch(nums, max, len);
//        }

        for(int i = 0; i < nums.length - 1; i++) {
            int min = findMin(nums, i);
            exch(nums, min, i);
        }
    }

    private int findMin(Comparable[] nums, int start) {
        int min = start;
        for(int i = start+1; i < nums.length; i++) {
            if(less(nums[i], nums[min])) {
                 min = i;
            }
        }

        return min;
    }

    public static void main(String[] args) {
        Integer[] nums = Util.getRandomArray();
//        Integer[] nums = {18, 6, 8, 4};
        SelectSort sort = new SelectSort();
        sort.show(nums);
        sort.sort(nums);
        sort.show(nums);
    }

}
