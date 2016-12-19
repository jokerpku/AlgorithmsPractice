package jian.zhi.offer;

import java.util.Stack;

/**
 * Created by Jokeria on 2016/12/19.
 */
public class IsPopOrder {
    public boolean isPopOrder(int[] nums, int[] pops) {

        if(nums == null || pops == null) {
            return false;
        }

        if(nums.length < pops.length) {
            return false;
        }

        Stack<Integer> stack = new Stack<Integer>();
        int j = 0;
        for(int i = 0; i < pops.length; i++) {
            if(!stack.isEmpty() && stack.peek() == pops[i]) {
                stack.pop();
            } else {
                while(j < nums.length && nums[j] != pops[i]) {
                    stack.push(nums[j++]);
                }
                if(j >= nums.length) {
                    return false;
                } else {
                    j++;
                }
            }

        }

        return true;
    }

    public static void main(String[] args) {
        IsPopOrder instance = new IsPopOrder();
        int[] nums = {1,2,3,4,5};
        int[] popOrder = {4,3,5,1,2};
        boolean res = instance.isPopOrder(nums, popOrder);
        System.out.println(res);
    }

}
