package Sort.Review;

import algorithms.practice.SortAlgorithm;
import practice.util.Util;

/**
 * Created by Jokeria on 2016/12/10.
 */
public class BubbleSort extends SortAlgorithm {
    public void sort(Comparable[] nums) {
        if(nums == null || nums.length == 0) {
            return;
        }

        int len = nums.length - 1;
        boolean hasExch = true;
        while(len > 0 && hasExch) {
            int i = 0;
            hasExch = false;
            for(int j = 1; j <= len; j++) {
                if(less(nums[i], nums[j])) {
                    i = j;
                } else {
                    hasExch = true;
                }
            }
            exch(nums, i, len);
            len--;
        }
    }

    public static void main(String args[]) {
        Integer[] nums = Util.getRandomArray();

        BubbleSort sort = new BubbleSort();
        sort.show(nums);
        sort.sort(nums);
        sort.show(nums);
    }
}
