package jian.zhi.offer;

/**
 * Created by Jokeria on 2016/12/20.
 */
public class MoreThanHalfNumber {
    public int MoreThanHalfNumberByPartition(int[] nums) {
        if(nums == null || nums.length == 0) {
            return 0;
        }

        int midNumber = findMidNumber(nums);
        boolean moreThanHalf = checkMoreThanHalf(nums, midNumber);
        if(moreThanHalf) {
            return midNumber;
        } else {
            throw new RuntimeException("Not exist more than half number.");
        }
    }

    // 找中位数
    int findMidNumber(int[] nums) {
        if(nums == null || nums.length == 0) {
            throw new RuntimeException("Invalid input.");
        }
        int mid = nums.length >> 1;
        int lo = 0;
        int hi = nums.length - 1;
        int index = partition(nums, lo, hi);
        while(index != mid) {
            if(index > mid) {
                hi = index-1;
            } else {
                lo = index+1;
            }
            index = partition(nums, lo, hi);
        }
        return nums[mid];
    }

    // 分割函数，返回切割位置
    int partition(int[] nums, int start, int end) {
        if(start >= end) {
            return start;
        }
        int lo = start;
        int hi = end-1;
        int target = nums[end];
        while(lo < hi) {
            while(lo < hi && nums[lo] <= target) {
                lo++;
            }
            while(lo < hi && nums[hi] > target) {
                hi--;
            }
            if(lo < hi) {
                int temp = nums[lo];
                nums[lo] = nums[hi];
                nums[hi] = temp;
            }
        }
        nums[end] = nums[lo];
        nums[lo] = target;
        return lo;
    }

    // 检查元素是否出现超过一半
    boolean checkMoreThanHalf(int[] nums, int target) {
        int count = 0;
        for(int i = 0; i < nums.length; i++) {
            if(nums[i] == target) {
                count++;
            }
        }
        if(count > (nums.length >> 1)) {
            return true;
        } else {
            return false;
        }
    }

    public int MoreThanHalfNumberByCount(int[] nums) {
        if(nums == null || nums.length == 0) {
            return 0;
        }

        int res = nums[0];
        int count = 1;
        for(int i = 1; i < nums.length; i++) {
            if(nums[i] == res) {
                count++;
            } else {
                if(count == 0) {
                    res= nums[i];
                    count = 1;
                } else {
                    count--;
                }
            }
        }

        if(count > 0) {
            return res;
        } else {
            throw new RuntimeException("Not exist more than half number.");
        }
    }

    public static void main(String[] args) {
        MoreThanHalfNumber instance = new MoreThanHalfNumber();
        int[] nums = {2,1,2,3,4,2,5,2,6,2,1,2,2,2,2,5};
//        int[] nums = {2,1,2,1,1};
//        int res = instance.MoreThanHalfNumberByCount(nums);
        int res = instance.MoreThanHalfNumberByPartition(nums);
        System.out.println(res);
    }
}
