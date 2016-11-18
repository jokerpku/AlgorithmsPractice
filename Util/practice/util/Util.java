package practice.util;

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

}
