package jian.zhi.offer;

/**
 * Created by Jokeria on 2016/12/19.
 */
public class VerifySequenceBST {
    public boolean verifySequenceBST(int[] nums) {
        if(nums == null) {
            return false;
        }
        return verifySequenceBST(nums, 0, nums.length-1);

    }

    private boolean verifySequenceBST(int[] nums, int lo, int hi) {
        if(lo >= hi) {
            return true;
        }
        int root = nums[hi];

        int mid = lo;
        while(mid < hi && nums[mid] < root) {
            mid++;
        }

        for(int i = mid; i < hi; i++) {
            if(nums[i] < root) {
                return false;
            }
        }

        boolean left = verifySequenceBST(nums, lo, mid-1);
        if(left) {
            return verifySequenceBST(nums, mid, hi-1);
        }

        return false;
    }

    public static void main(String[] args) {
        VerifySequenceBST instance = new VerifySequenceBST();
        int[] nums = {5,7,6,13,11,12,8};
        boolean res = instance.verifySequenceBST(nums);
        System.out.println(res);
    }
}
