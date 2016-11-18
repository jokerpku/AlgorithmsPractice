package inteview;

import practice.util.Util;

/**
 * Created by Jokeria on 2016/11/18.
 */
public class ThirdMaximumNumber {
    public int thirdMax(Integer[] nums) {

        int count = 0;
        for(int len = nums.length-1; len > 0; len--) {
            int maxIndex = 0;
            boolean flag = false;
            for(int i = 1; i <= len; i++) {
                if(nums[i] >= nums[maxIndex]) {
                    maxIndex = i;
                } else {
                    flag = true;
                }
            }
            if(!flag) {
                break;
            }
            if(maxIndex != len) {
                int temp = nums[maxIndex];
                nums[maxIndex] = nums[len];
                nums[len] = temp;
            }
            if(len == nums.length-1 || nums[len] != nums[len+1]) {
                count++;
                if(count == 3) {
                    return nums[len];
                }
            }
        }

        count = 1;
        for(int len = nums.length-2; len >= 0; len--) {
            if(nums[len] != nums[len+1]) {
                count++;
                if(count == 3) {
                    return nums[len];
                }
            }
        }

        return nums[nums.length-1];
    }

    public static void main(String[] args) {
        Integer[] nums = {4,3,2,5,1};
        ThirdMaximumNumber solution = new ThirdMaximumNumber();
        int res = solution.thirdMax(nums);
        Util.show(nums);
        System.out.println(res);
    }
}
