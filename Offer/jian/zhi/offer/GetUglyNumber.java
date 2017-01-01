package jian.zhi.offer;

/**
 * 找到第n个丑数
 * 丑数的定义为只包含2,3,5因子的整数
 * 如6,8是丑数，而14不是
 * 第一个丑数是1
 * Created by Simple on 2017/1/1.
 */
public class GetUglyNumber {
    public int getUglyNumber(int n) {
        if(n <= 0) {
            return 0;
        }

        int[] nums = new int[n];
        nums[0] = 1;
        int index2 = 0;
        int index3 = 0;
        int index5 = 0;
        for(int i = 1; i < n; i++) {
            int min = Math.min(nums[index5] * 5, Math.min(nums[index2] * 2, nums[index3] * 3));
            nums[i] = min;
            while(min >= (nums[index2] * 2)) {
                index2++;
            }
            while(min >= (nums[index3] * 3)) {
                index3++;
            }
            while(min >= (nums[index5] * 5)) {
                index5++;
            }
        }

        return nums[n - 1];
    }

    public static void main(String[] args) {
        GetUglyNumber instance = new GetUglyNumber();
        int res = instance.getUglyNumber(1500);
        System.out.println(res);
    }

}
