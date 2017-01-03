package jian.zhi.offer;

/**
 * 给定一个数组，除了两个数字只出现一次以外，其他数字都出现两次，找出这两个数字
 * Created by Jokeria on 2017/1/3.
 */
public class FindNumbersAppearOnce {
    public int[] findNumbersAppearOnce(int[] nums) {
        if(nums == null || nums.length < 2) {
            return null;
        }

        int xorAll = 0;
        for(int i = 0; i < nums.length; i++) {
            xorAll ^= nums[i];
        }

        // 找出异或值第一个1的位置作为分界线
        int div = xorAll & (-xorAll);

        int[] res = new int[2];
        res[0] = 0;
        for(int i = 0; i < nums.length; i++) {
            if((nums[i] & div) == 0) {
                res[0] ^= nums[i];
            }
        }

        res[1] = xorAll ^ res[0];
        return res;
    }


    public static void main(String[] args) {
        FindNumbersAppearOnce instance = new FindNumbersAppearOnce();
        int[] nums = {-2,-4,-1,-3,-5,-7,-3,-4,-2,-7};
        int[] res = instance.findNumbersAppearOnce(nums);
        System.out.println(res[0] + " " + res[1]);
    }
}
