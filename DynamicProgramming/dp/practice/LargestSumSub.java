package dp.practice;

/**
 * Created by Jokeria on 2016/11/9.
 */

/**
 * 最大和子序列
 */
public class LargestSumSub {
    public static void main(String[] args) {
        int nums[] = {5, -4, 2, 5, -1};
//        int res[] = lss(nums);
//        for(int num : res) {
//            System.out.println(num + " ");
//        }

        System.out.println(largestSum(nums));

    }

    static int[] lss(int[] nums) {
        if(nums == null || nums.length == 0) {
            return new int[0];
        }

        int max = nums[0];
        int maxLo = 0;
        int maxHi = 0;
        int lo = 0;
        int sum = max;
        for(int i = 1; i < nums.length; i++) {
            sum += nums[i];
            if(sum <= 0) {
                sum = 0;
                lo = i+1;
            } else if(sum > max) {
                max = sum;
                maxLo = lo;
                maxHi = i;
            }
        }

        int result[] = new int[maxHi - maxLo + 1];
        int m = 0;
        for(int i = maxLo; i <= maxHi; i++) {
            result[m++] = nums[i];
        }

        return result;

    }

    static int largestSum(int[] nums) {
        if(nums == null || nums.length == 0) {
            return 0;
        }

        int max = Integer.MIN_VALUE;
        int sum = 0;
        for(int num : nums) {
            sum += num;
            if(sum > max) {
                max = sum;
            }
            if(sum < 0){
                sum = 0;
            }
        }
        return max;
    }

}
