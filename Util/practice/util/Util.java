package practice.util;

import java.util.Random;

/**
 * Created by Jokeria on 2016/11/18.
 */
public class Util {
    public static <T> void show(T[] nums) {
        if(nums == null || nums.length == 0) {
            System.out.println("The array is empty.");
        }

        for(T ele : nums) {
            System.out.print(ele.toString() + " ");
        }
        System.out.println();
    }

    public static <T> void exch(T[] nums, int a, int b) {
        T temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }

    public static Integer[] getRandomArray() {
        Integer[] array = new Integer[10];
        long mill = System.currentTimeMillis();
        Random random = new Random(mill);
        for(int i = 0; i < 10; i++) {
            array[i] = (random.nextInt() % 20) + 1;
        }
        return array;
    }

}
