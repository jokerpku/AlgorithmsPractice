package jian.zhi.offer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by Jokeria on 2016/12/20.
 */
public class EightQueen {
    public List<List<Integer>> queen() {
        List<List<Integer>> lists = new LinkedList<List<Integer>>();
        int[] nums = {0, 1, 2, 3, 4, 5, 6, 7};
        permination(nums, 0, lists);
        return lists;
    }

    void permination(int[] nums, int lo, List<List<Integer>> lists) {
        if (lo == 8) {
            if (isSatisfy(nums)) {
                ArrayList<Integer> list = new ArrayList<Integer>();
                for(int num : nums) {
                    list.add(num);
                }
                lists.add(new ArrayList<Integer>(list));
//                for(int num : nums) {
//                    System.out.print(num + " ");
//                }
//                System.out.println();
            }
            return;
        }

        permination(nums, lo + 1, lists);

        for (int i = lo + 1; i < 8; i++) {
            Integer temp = nums[i];
            nums[i] = nums[lo];
            nums[lo] = temp;

            permination(nums, lo + 1, lists);

            temp = nums[i];
            nums[i] = nums[lo];
            nums[lo] = temp;
        }
    }

    boolean isSatisfy(int[] nums) {
        for (int i = 0; i < 7; i++) {
            for (int j = i + 1; j < 8; j++) {
                if (j - i == Math.abs(nums[i] - nums[j])) {
                    return false;
                }
            }
        }

        return true;
    }

    public static void main(String[] args) {
        EightQueen instance = new EightQueen();
        instance.queen();
        List<List<Integer>> lists = instance.queen();
        for(List<Integer> list : lists) {
            for(Integer i : list) {
                System.out.print(i + " ");
            }
            System.out.println();
        }
    }
}
