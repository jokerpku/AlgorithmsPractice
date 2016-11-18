package inteview;

/**
 * Created by Jokeria on 2016/11/17.
 * 交班费，排成一排，若身高比周围的人高，则不能比周围人交的少，最少1块，尽量少交，输出最少能收班费数目
 */
public class Expensive {
    public int expensive(int[] nums, int[] exps) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        if (nums.length == 1) {
            return 1;
        }
//        // exps数组记录每个人交钱的数目
//        int[] exps = new int[nums.length];

        // 判断第一个人的缴费数目
        if (nums[0] <= nums[1]) {
            exps[0] = 1;
        }
        // 第一次遍历，从前往后遍历，判断中间的人的缴费数目，只能判断出不比后面人高的同学的缴费数目
        for (int i = 1; i < nums.length - 2; i++) {
            if (nums[i] <= nums[i - 1] && nums[i] <= nums[i + 1]) { // 不比周围人高，直接为1
                exps[i] = 1;
            } else if (nums[i] <= nums[i + 1]) { // 不比后面的人高，则前面人缴费加1
                exps[i] = exps[i - 1] + 1;
            }// 比后面的人高，则暂时未知
        }
        // 判断最后一个人的缴费数目
        if (nums[nums.length - 1] > nums[nums.length - 2]) { // 最后一个人较前一个人高
            exps[nums.length-1] = exps[nums.length-2] + 1;
        } else {
            exps[nums.length-1] = 1;
        }

        // 第二次遍历，从后往前遍历，判断中间的人的缴费数目，判断出比后面人高的同学的缴费数目
        int sum = exps[nums.length-1];
        for (int i = nums.length - 2; i > 0; i--) {
            if(exps[i] == 0) {
                if (nums[i] > nums[i - 1]) { // 比周围人都高
                    exps[i] = Math.max(exps[i - 1], exps[i + 1]) + 1;
                } else { // 只比后面的人高
                    exps[i] = exps[i + 1] + 1;
                }
            }
            sum += exps[i];
        }
        // 判断第一个人的缴费数目
        if (nums[0] > nums[1]) {
            exps[0] = exps[1] + 1;
        }
        sum += exps[0];
        return sum;
    }

    public static void main(String[] args) {
        Expensive exp = new Expensive();
        // exps数组记录每个人交钱的数目
        int[] exps = new int[10];
        int[] array = {10, 4, 2, 20, 1, 4, 13, 14, 32, 4};
        int res = exp.expensive(array, exps);
        System.out.println("sum = " + res);
        exp.show(array);
        exp.show(exps);

    }

    public void show(int[] array) {
        for(int i = 0; i < array.length; i++) {
            System.out.printf("%02d ", array[i]);
        }
        System.out.println();
    }
}
