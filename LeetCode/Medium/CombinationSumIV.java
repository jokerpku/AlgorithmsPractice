package Medium;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Jokeria on 2016/11/22.
 */
public class CombinationSumIV {

    public int combinationSum4(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        return combinationSum4(nums, target, map);
    }

    public int combinationSum4(int[] nums, int target, Map<Integer, Integer> map) {
        if (nums == null || nums.length == 0 || target == 0) {
            return 0;
        }

        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            int key = target - nums[i];
            if (key == 0) {
                count++;
                continue;
            } else if (key > 0) {
                if (map.containsKey(key)) {
                    count += map.get(key);
                } else {
                    int value = combinationSum4(nums, key, map);
                    map.put(key, value);
                    count += value;
                }
            }
        }

        return count;
    }

    public static void main(String[] args) {
        CombinationSumIV instance = new CombinationSumIV();
        int[] nums = new int[]{1, 2, 3};
        int target = 4;
        int res = instance.combinationSum4(nums, target);
    }

}
