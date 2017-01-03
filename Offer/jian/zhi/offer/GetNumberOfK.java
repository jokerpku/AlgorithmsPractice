package jian.zhi.offer;

/**
 * 统计一个数字在排序数组中出现的次数
 * Created by Jokeria on 2017/1/3.
 */
public class GetNumberOfK {
    public int getNumbetOfK(int[] nums, int k) {
        if(nums == null) {
            return 0;
        }

        int first = getFirstIndexOfK(nums, k, 0, nums.length - 1);
        if(first != -1) {
            int last = getLastIndexOfK(nums, k, 0, nums.length - 1);
            if(last != -1) {
                return last - first + 1;
            }
        }

        return 0;
    }

    int getFirstIndexOfK(int[] nums, int k, int lo, int hi) {
        if(lo > hi) {
            return -1;
        }
        if(lo == hi) {
            if(nums[lo] == k) {
                return lo;
            } else {
                return -1;
            }
        }

        if(nums[lo] > k || nums[hi] < k) {
            return -1;
        }

        int mid = lo + (hi - lo) / 2;
        if(nums[mid] > k) {
            return getFirstIndexOfK(nums, k, lo, mid - 1);
        } else if(nums[mid] < k) {
            return getFirstIndexOfK(nums, k, mid + 1, hi);
        } else if(mid == lo || nums[mid - 1] < k){
            return mid;
        } else {
            return getFirstIndexOfK(nums, k, lo, mid - 1);
        }
    }

    int getLastIndexOfK(int[] nums, int k, int lo, int hi) {
        if(lo > hi) {
            return -1;
        }
        if(lo == hi) {
            if(nums[lo] == k) {
                return lo;
            } else {
                return -1;
            }
        }

        if(nums[lo] > k || nums[hi] < k) {
            return -1;
        }

        int mid = lo + (hi - lo) / 2;
        if(nums[mid] > k) {
            return getLastIndexOfK(nums, k, lo, mid - 1);
        } else if(nums[mid] < k) {
            return getLastIndexOfK(nums, k, mid + 1, hi);
        } else if(mid == hi || nums[mid + 1] > k){
            return mid;
        } else {
            return getLastIndexOfK(nums, k, mid + 1, hi);
        }
    }

    public static void main(String[] args) {
        GetNumberOfK instance = new GetNumberOfK();
        int[] nums = {1,2,3,3,3,3,3,3,4,5,5,6};

        long start = System.nanoTime();
        int res = instance.getNumbetOfK(nums, 7);
        long end = System.nanoTime();

        System.out.println(res);
        System.out.println((end - start) + "ns");
    }
}
