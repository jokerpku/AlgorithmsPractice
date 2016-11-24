package Medium;

import java.util.*;

/**
 * Created by Jokeria on 2016/11/24.
 */
public class FourSum {
    // public List<List<Integer>> fourSum(int[] nums, int target) {
    //     if(nums == null || nums.length < 4) {
    //         return Collections.emptyList();
    //     }

    //     Arrays.sort(nums);
    //     List<List<Integer>> res = new LinkedList<List<Integer>>();
    //     // 三重循环
    //     for(int i = 0; i < nums.length - 3; i++) {
    //         if(i > 0 && nums[i] == nums[i-1]) { // 去重
    //             continue;
    //         }
    //         for(int j = i+1; j < nums.length - 2; j++) {
    //             if(j != i+1 && nums[j] == nums[j-1]) { // 去重
    //                 continue;
    //             }
    //             // 从后面的数组中查找
    //             int lo = j+1;
    //             int hi = nums.length - 1;
    //             while(lo < hi) {
    //                 int sum = nums[i] + nums[j] + nums[lo] + nums[hi];
    //                 if(sum == target) {
    //                     res.add(Arrays.asList(nums[i], nums[j], nums[lo], nums[hi]));
    //                     hi--;
    //                     while(hi > lo && nums[hi] == nums[hi+1]) {
    //                         hi--;
    //                     }
    //                     lo++;
    //                     while(hi > lo && nums[lo] == nums[lo-1]) {
    //                         lo++;
    //                     }
    //                 } else if(sum > target) {
    //                     hi--;
    //                     while(hi > lo && nums[hi] == nums[hi+1]) {
    //                         hi--;
    //                     }
    //                 } else {
    //                     lo++;
    //                     while(hi > lo && nums[lo] == nums[lo-1]) {
    //                         lo++;
    //                     }
    //                 }
    //             }
    //         }
    //     }

    //     return res;

    // }

    public List<List<Integer>> fourSum(int[] nums, int target) {
        if(nums == null || nums.length < 4) {
            return Collections.emptyList();
        }

        Arrays.sort(nums);
        int max = nums[nums.length-1];
        if(nums[0] * 4 > target || max * 4 < target) { // target太小或者太小
            return Collections.emptyList();
        }
        List<List<Integer>> res = new LinkedList<List<Integer>>();
        for(int i = 0; i < nums.length - 3; i++) { // 从0到倒数第四位遍历
            if(i > 0 && nums[i] == nums[i-1]) { // 去重
                continue;
            }
            if(nums[i] * 4 > target) { // 当前值太大
                break;
            }
            if(max * 3 + nums[i] < target) { // 当前值太小
                continue;
            }
            threeSum(nums, target - nums[i], i+1, res, nums[i]);
        }

        return res;
    }

    void threeSum(int[] nums, int target, int lo, List<List<Integer>> res, int pre) {
        if(nums == null || nums.length - lo < 3) {
            return;
        }

        int max = nums[nums.length-1];
        if(nums[lo] * 3 > target || max * 3 < target) { // target太小或者太小
            return;
        }
        for(int i = lo; i < nums.length - 2; i++) { // 从lo到倒数第3位遍历
            if(i > lo && nums[i] == nums[i-1]) { // 去重
                continue;
            }
            if(nums[i] * 3 > target) { // 当前值太大
                break;
            }
            if(max * 2 + nums[i] < target) { // 当前值太小
                continue;
            }
            twoSum(nums, target - nums[i], i+1, res, pre, nums[i]);
        }

    }

    void twoSum(int[] nums, int target, int lo, List<List<Integer>> res, int pre, int pre2) {
        if(nums == null || nums.length - lo < 2) {
            return;
        }

        int max = nums[nums.length-1];
        if(nums[lo] * 2 > target || max * 2 < target) { // target太小或者太小
            return;
        }
        int hi = nums.length-1;
        while(lo < hi) {
            int sum = nums[lo] + nums[hi];
            if(sum == target) {
                res.add(Arrays.asList(pre, pre2, nums[lo], nums[hi]));
                lo++;
                hi--;
                while(lo < hi && nums[lo] == nums[lo-1]) {
                    lo++;
                }
                while(lo < hi && nums[hi] == nums[hi+1]) {
                    hi--;
                }
            } else if(sum > target) {
                hi--;
                while(lo < hi && nums[hi] == nums[hi+1]) {
                    hi--;
                }
            } else {
                lo++;
                while(lo < hi && nums[lo] == nums[lo-1]) {
                    lo++;
                }
            }
        }
    }

    public static void main(String[] args) {
        FourSum instance = new FourSum();
        int nums[] = {-3,-2,-1,0,0,1,2,3};
        int target = 0;
        instance.fourSum(nums, target);
    }
}
