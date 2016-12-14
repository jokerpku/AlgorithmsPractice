package Sort.Review;

import algorithms.practice.SortAlgorithm;
import practice.util.Util;

/**
 * Created by Jokeria on 2016/12/10.
 */
public class InsertSort extends SortAlgorithm {

    public void sort(Comparable[] nums) {
        if(nums == null || nums.length == 0) {
            return;
        }

        for(int i = 1; i < nums.length; i++) {
            for(int j = i; j > 0; j--) {// 从后向前比较
                if(less(nums[j], nums[j-1])){
                    exch(nums, j, j-1);
                } else {
                    break;
                }
            }
        }
    }

    public static void main(String[] args) {
        Integer[] nums = Util.getRandomArray();
        BubbleSort sort = new BubbleSort();
        sort.show(nums);
        sort.sort(nums);
        sort.show(nums);
    }
}
