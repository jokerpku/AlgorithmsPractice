package algorithms.practice;

/**
 * Created by Jokeria on 2016/11/5.
 */
public class SingleNumber {

    // 用ones保存第一次遍历到的数字，twos保存第二次遍历到的数字，第三次遍历到时，从twos中删除
    public int findAOnesInThree(int[] nums) {
        int ones = 0;
        int twos = 0;
        for (int num : nums) {
            ones = (num ^ ones) & (~twos);
            twos = (num ^ twos) & (~ones);
        }

        return ones;
    }

    /**
     * 用状态机的方法求解
     * 元素最多出现三次，因此状态机的位数为2，a0，b0表示上一状态
     * 遍历到的数字为c
     * 则，状态转移规则如下
     * a0    b0   c   a   b
     * 0    0    0   0   0
     * 0    0    1   0   1 表示第一次出现
     * 0    1    0   0   1
     * 0    1    1   1   0 表示第二出现
     * 1    0    0   1   0
     * 1    0    1   0   0 表示第三次出现
     * 只关心1的情况，因此对于a，011和100；对于b，001,010
     *
     * @param nums
     * @return
     */
    public int findAOnesInThree2(int[] nums) {
        int a = 0;
        int b = 0;
        for (int num : nums) {
            int t = a;
            a = (~a & b & num) | (a & ~b & ~num);
            b = (~t & ~b & num) | (~t & b & ~num);
        }

        return a | b;
    }

    /**
     * 思路：问题的关键在于如何区分两个数，根据不同点，将数组分成两类，分别异或，得出两个数即为结果
     * 两个数至少有一个位置有且只有一个为1，找出这个位置。根据两个数的异或结果，在结果中随便找出一个为1的位置即可
     *
     * @param nums
     */
    public int[] findTwoOnesInTwos(int[] nums) {
        int xor = 0;
        for (int num : nums) {
            xor ^= num;
        }

        int diff = xor & (-xor); // 找到第一个1的位置
        int[] result = {0, 0};
        for (int num : nums) {
            if ((num & diff) == 0) {
                result[0] ^= num;
            } else {
                result[1] ^= num;
            }
        }

        return result;

    }
}
