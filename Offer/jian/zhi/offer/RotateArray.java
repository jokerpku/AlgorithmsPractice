package jian.zhi.offer;

/**
 * Created by Simple on 2016/12/14.
 */
public class RotateArray {
    public int getMin(int[] nums) {
        if (nums == null) {
            throw new RuntimeException("The array is null.");
        }

        int lo = 0;
        int hi = nums.length - 1;
        if (nums[lo] < nums[hi]) { // 边界情况，表示数组并未被旋转，为提高效率，做特殊处理。
            return nums[lo];
        }
//        while(nums[lo] >= nums[hi] && lo < hi) {
        while (lo < hi) {
            int mid = lo + (hi - lo) / 2;
            if (nums[mid] > nums[hi]) { // mid及之前有序，说明最小值在mid后面
                lo = mid + 1;
            } else if (nums[mid] == nums[hi] && nums[lo] == nums[hi]) { // 特殊情形，无法判断最小值在前半段还是后半段，只能遍历数组。如：3333123,3123333
                int min = nums[lo]; // 从lo到hi，遍历查找最小值
                while (lo < hi) {
                    if (min > nums[++lo]) {
                        min = nums[lo];
                    }
                }
                return min;
            } else { // mid及之后有序，说明最小值在mid及前面
                hi = mid;
//                lo++;
            }
        }

        return nums[lo];
    }

    public int getIndex(int[] nums, int target) {
        if (nums == null) {
            return -1;
        }
        int lo = 0;
        int hi = nums.length - 1;
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            if (nums[mid] == target) {
                return mid;
            }

            if (nums[mid] > nums[hi]) { // mid及之前有序
                if (nums[mid] > target && nums[lo] <= target) {
                    hi = mid - 1;
                } else {
                    lo = mid + 1;
                }
            } else if (nums[mid] == nums[hi] && nums[lo] == nums[mid]) { // 特殊情况，无法判断，只能遍历如：3333123,3123333找2
                for (int i = lo; i <= hi; i++) {
                    if (nums[i] == target) {
                        return i;
                    }
                }
                return -1;
            } else { // mid及之后有序
                if (nums[mid] < target && nums[hi] >= target) {
                    lo = mid + 1;
                } else {
                    hi = mid - 1;
                }
            }
        }

        return lo;
    }

//    public static void main(String[] args) {
//        RotateArray instance = new RotateArray();
//
//        int[] nums = {3, 4, 5, 6, 1, 2};
//        int res = instance.getMin(nums);
//        System.out.println(res);
//        int[] nums0 = {5, 6, 1, 2, 3, 4};
//        res = instance.getMin(nums0);
//        System.out.println(res);
//        int[] nums1 = {1, 2, 3, 4, 5, 6};
//        res = instance.getMin(nums1);
//        System.out.println(res);
//        int[] nums2 = {2, 3, 4, 5, 6, 1};
//        res = instance.getMin(nums2);
//        System.out.println(res);
//        int[] nums3 = {2, 3, 3, 5, 6, 1};
//        res = instance.getMin(nums3);
//        System.out.println(res);
//        int[] nums4 = {3, 5, 6, 1, 2, 3};
//        res = instance.getMin(nums4);
//        System.out.println(res);
//        int[] nums5 = {1, 1, 1, 1, 0, 1};
//        res = instance.getMin(nums5);
//        System.out.println(res);
//        int[] nums6 = {1, 0, 1, 1, 1, 1};
//        res = instance.getMin(nums6);
//        System.out.println(res);
//    }

    public static void main(String[] args) {
        RotateArray instance = new RotateArray();

        int[] nums = {3, 4, 5, 6, 1, 2};
        int res = instance.getIndex(nums, 2);
        System.out.println(res);
        int[] nums0 = {5, 6, 1, 2, 3, 4};
        res = instance.getIndex(nums0, 2);
        System.out.println(res);
        int[] nums1 = {1, 2, 3, 4, 5, 6};
        res = instance.getIndex(nums1, 2);
        System.out.println(res);
        int[] nums2 = {2, 3, 4, 5, 6, 1};
        res = instance.getIndex(nums2, 2);
        System.out.println(res);
        int[] nums3 = {2, 3, 3, 5, 6, 1};
        res = instance.getIndex(nums3, 2);
        System.out.println(res);
        int[] nums4 = {3, 5, 6, 1, 2, 3};
        res = instance.getIndex(nums4, 2);
        System.out.println(res);
        int[] nums5 = {8, 0, 1, 3, 3, 3, 3};
        res = instance.getIndex(nums5, 1);
        System.out.println(res);
        int[] nums6 = {7, 8, 9, 3, 3, 3, 3};
        res = instance.getIndex(nums6, 8);
        System.out.println(res);
        int[] nums7 = {3, 3, 3, 3, 0, 1, 3};
        res = instance.getIndex(nums7, 1);
        System.out.println(res);
        int[] nums8 = {3, 0, 1, 3, 3, 3, 3};
        res = instance.getIndex(nums8, 1);
        System.out.println(res);
    }

}
