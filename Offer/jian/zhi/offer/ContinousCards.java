package jian.zhi.offer;

import java.util.Arrays;

/**
 * 从扑克牌中随机抽取5张，判断是不是一个顺子，大小王可认为任意数
 * 第一种解法：排序，对0的数量和空隙的数量计数并比较
 * 第二种解法：用一个大小为14的数组，记录每张牌出现的次数，遍历这个大小为14的数组判断是否连续
 * Created by Jokeria on 2017/1/3.
 */
public class ContinousCards {
    public boolean isContinousCards(int[] nums) {
        if(nums == null || nums.length <= 1) {
            return true;
        }

        Arrays.sort(nums);
        int numsOfZero = 0;
        for(int i = 0; i < nums.length; i++) {
            if(nums[i] == 0) {
                numsOfZero++;
            } else {
                break;
            }
        }

        int numsOfGap = 0;
        for(int i = numsOfZero; i < nums.length - 1; i++) {
            if(nums[i] == nums[i+1]) {
                return false;
            }
            numsOfGap += nums[i+1] - nums[i] - 1;
        }

        if(numsOfGap <= numsOfZero) {
            return true;
        } else {
            return false;
        }
    }

    public boolean isContinousCards2(int[] nums) {
        if(nums == null || nums.length <= 1) {
            return true;
        }

        int[] feqs = new int[14];
        for(int i = 0; i < nums.length; i++) {
            if(nums[i] < 0 || nums[i] > 13) {
                return false;
            }

            if(nums[i] != 0 && feqs[nums[i]] != 0) {
                return false;
            }

            feqs[nums[i]]++;
        }

        boolean isStart = false;
        int numsOfZero = feqs[0];
        for(int i = 1; i < 14; i++) {
            if(!isStart && feqs[i] == 1) {
                isStart = true;
            } else if(isStart){
                if(feqs[i] == 0) {
                    numsOfZero--;
                } else if(numsOfZero < 0){
                    return false;
                }
            }
        }

        return true;
    }

    public static void main(String[] args) {
        ContinousCards instance = new ContinousCards();
        int[] nums = {5,6,4,4,3};
        boolean res = instance.isContinousCards(nums);
        System.out.println(res);
    }
}
