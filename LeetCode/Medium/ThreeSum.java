package Medium;

import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by Jokeria on 2016/11/24.
 */
public class ThreeSum {
    public List<List<Integer>> threeSum(int[] nums) {
        if (nums == null || nums.length < 3) {
            return Collections.emptyList();
        }

        Arrays.sort(nums);
        int max = nums[nums.length - 1];
        if (nums[0] * 3 > 0 || max * 3 < 0) {
            return Collections.emptyList();
        }

        List<List<Integer>> res = new LinkedList<List<Integer>>();
        for (int i = 0; i < nums.length - 2; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            if (nums[i] * 3 > 0) {
                break;
            }
            if (nums[i] + max * 2 < 0) {
                continue;
            }
            twoSum(nums, i + 1, -1 * nums[i], res, nums[i]);
        }

        return res;
    }

    void twoSum(int[] nums, int lo, int target, List<List<Integer>> res, int pre) {
        if (nums.length - lo < 2) {
            return;
        }

        int hi = nums.length - 1;
        while (lo < hi) {
            int sum = nums[lo] + nums[hi];
            if (sum == target) {
                res.add(Arrays.asList(pre, nums[lo], nums[hi]));
                lo++;
                hi--;
                while (lo < hi && nums[hi] == nums[hi + 1]) {
                    hi--;
                }
                while (lo < hi && nums[lo] == nums[lo - 1]) {
                    lo++;
                }
            } else if (sum > target) {
                hi--;
                while (lo < hi && nums[hi] == nums[hi + 1]) {
                    hi--;
                }
            } else {
                lo++;
                while (lo < hi && nums[lo] == nums[lo - 1]) {
                    lo++;
                }
            }
        }
    }

    public static void main(String[] args) {
        ThreeSum instance = new ThreeSum();
        int nums[] = {-1, 0, 1};
//        int target = 0;
        instance.threeSum(nums);
    }
}
