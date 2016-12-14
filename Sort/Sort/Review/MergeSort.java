package Sort.Review;

import algorithms.practice.SortAlgorithm;
import practice.util.Util;

/**
 * Created by Jokeria on 2016/12/10.
 */
public class MergeSort extends SortAlgorithm {
    @Override
    public void sort(Comparable[] nums) {
        if (nums == null || nums.length == 0) {
            return;
        }

        aux = new Comparable[nums.length];
        sort(nums, 0, nums.length - 1);


    }

    private void sort(Comparable[] nums, int lo, int hi) {
        if (lo >= hi) {
            return;
        }
        int mid = lo + (hi - lo) / 2;
        sort(nums, lo, mid);
        sort(nums, mid + 1, hi);
        merge(nums, lo, mid, hi);
    }
//
//    private void merge(Comparable[] nums, int lo, int mid, int hi) {
//        Comparable[] res = new Comparable[nums.length];
//        int index = 0;
//        int i = lo;
//        int j = mid + 1;
//        while (i <= mid || j <= hi) {
//            if (i <= mid && j <= hi) {
//                if (less(nums[i], nums[j])) {
//                    res[index++] = nums[i++];
//                } else {
//                    res[index++] = nums[j++];
//                }
//            } else if (i <= mid) {
//                while (i <= mid) {
//                    res[index++] = nums[i++];
//                }
//            } else {
//                while (j <= hi) {
//                    res[index++] = nums[j++];
//                }
//            }
//        }
//
//        index = 0;
//        for(i = lo; i <= hi; i++) {
//            nums[i] = res[index++];
//        }
//    }

    private Comparable[] aux;

    private void merge(Comparable[] nums, int lo, int mid, int hi) {
        for(int i = lo; i <= hi; i++) {
            aux[i] = nums[i];
        }

        int left = lo;
        int right = mid+1;
        for(int i = lo; i <= hi; i++) {
            if(left > mid) {
                nums[i] = aux[right++];
            } else if(right > hi) {
                nums[i] = aux[left++];
            } else if(less(aux[left], aux[right])) {
                nums[i] = aux[left++];
            } else {
                nums[i] = aux[right++];
            }
        }
    }


    public static void main(String[] args) {
        Integer[] nums = Util.getRandomArray();
//        Integer[] nums = {18, 6, 8, 4,5,7,-1};
        MergeSort sort = new MergeSort();
        sort.show(nums);
        sort.sort(nums);
        sort.show(nums);
    }
}
