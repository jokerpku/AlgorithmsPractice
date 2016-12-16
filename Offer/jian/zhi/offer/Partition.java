package jian.zhi.offer;

import practice.util.Util;

/**
 * Created by Jokeria on 2016/12/16.
 */

interface Division {
    public boolean inFront(int num);
}

public class Partition {

    public int partition(Integer[] arrays, Division division) {
        if (arrays == null) {
            return 0;
        }
        int lo = 0;
        int hi = arrays.length - 1;
        while (lo < hi) {
            while (lo < hi && division.inFront(arrays[lo])) {
                lo++;
            }
            while (lo < hi && !division.inFront(arrays[hi])) {
                hi--;
            }
            if (lo < hi) {
                Util.exch(arrays, lo, hi);
            }
        }
        return lo;
    }

    public static void main(String[] args) {
        Partition instance = new Partition();
        Integer[] nums = Util.getRandomArray();
        Util.show(nums);
        int index = instance.partition(nums, new Division() {
            @Override
            public boolean inFront(int num) {
                if ((num & 0x1) == 0) {
                    return true; // 偶数在前
                }
                return false;
            }
        });
        Util.show(nums);
        System.out.println(index);

        index = instance.partition(nums, new Division() {
            @Override
            public boolean inFront(int num) {
                if ((num % 3) == 0) {
                    return true; // 3的整倍数在前
                }
                return false;
            }
        });
        Util.show(nums);
        System.out.println(index);
    }
}
