package Medium;

import java.util.Arrays;

/**
 * Created by Simple on 2016/11/26.
 */
public class ThreeSumClosest {
    public int threeSumClosest(int[] nums, int target) {
        // if(nums == null || nums.length < 3) {
        //     return Collections.emptyList();
        // }

        Arrays.sort(nums);
        int max = nums[nums.length-1];
        if(nums[0] * 3 > target) {
            return nums[0] * 3;
        }
        if(max * 3 < target) {
            return max * 3;
        }

        int gap = nums[0] + nums[1] + nums[2] - target;
        // int gap = 100;
        for(int i = 0; i < nums.length - 2; i++) {
            if(gap == 0) {
                return target;
            }
            if(i > 0 && nums[i] == nums[i-1]) {
                continue;
            }
            // int loGap = nums[i] * 3 - target;
            // if(loGap > 0) {
            //     if(Math.abs(gap) > loGap) {
            //         gap = loGap;
            //     }
            //     break;
            // }
            // int hiGap = nums[i] - max * 2 - target;
            // if(hiGap < 0) {
            //     if(Math.abs(gap) > (-1 * hiGap)) {
            //         gap = hiGap;
            //     }
            //     continue;
            // }
            int tempGap = twoSumClosest(nums, i+1, target - nums[i]) + nums[i] - target;
            if(Math.abs(gap) > Math.abs(tempGap)) {
                gap = tempGap;
            }
        }

        return gap + target;
    }

    int twoSumClosest(int[] nums, int lo, int target) {
        // System.out.println(lo + ", " + target + ", " + pre);
        // if(nums.length - lo < 2) {
        //     return;
        // }

        int gap = nums[lo] + nums[lo+1] - target;
        int hi = nums.length - 1;
        while(lo < hi) {
            int tempGap = nums[lo] + nums[hi] - target;
            if(tempGap == 0) {
                return target;
            } else if(Math.abs(gap) > Math.abs(tempGap)) {
                gap = tempGap;
            }

            if(tempGap > 0) {
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

        return gap + target;
    }

    public static void main(String[] args) {
        ThreeSumClosest instance = new ThreeSumClosest();
        int[] nums = {1,1,1,0};
        int res = instance.threeSumClosest(nums, -100);
        System.out.println(res);
    }
}
