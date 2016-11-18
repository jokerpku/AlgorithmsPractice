package impl;

import javax.print.attribute.IntegerSyntax;

/**
 * Created by Jokeria on 2016/7/4.
 */
import java.util.Map;
import java.util.HashMap;
import java.util.Set;
public class IntersectionOfTwoArrays {
    public static void main() {
        int[] nums1 = {0,5,8,7,2,9,7,5};
        int[] nums2 = {1,4,8,9};
        IntersectionOfTwoArrays obj = new IntersectionOfTwoArrays();
        obj.intersection(nums1, nums2);
        return;
    }
        public int[] intersection(int[] nums1, int[] nums2) {
            if(nums1 == null || nums2 == null) {
                return null;
            } else if(nums1.length == 0 || nums2.length == 0) {
                return (new int[0]);
            }
            quickSort(nums2, 0, nums2.length-1);
            Map<Integer, Integer> map = new HashMap<Integer, Integer>();
            for(int num1 : nums1) {
                int index = binarySearch(nums2, 0, nums2.length-1, num1);
                if(index != -1) {
                    map.put(num1, index);
                }
            }
            Set<Integer> set = map.keySet();
            int[] result = new int[set.size()];
            int i = 0;
            for(int num : set) {
                result[i++] = num;
            }
            return result;
        }

        public void quickSort(int[] array, int start, int end) {
            if(start >= end) {
                return;
            }

            int left = start;
            int right = end;
            int value = array[start];
            while(left != right) {
                if(array[left+1] > value) {
                    int temp = array[right];
                    array[right] = array[left+1];
                    array[left+1] = temp;
                    right--;
                } else {
                    array[left] = array[left+1];
                    left++;
                }
            }
            array[left] = value;
            quickSort(array, start, left-1);
            quickSort(array, left+1, end);
        }

        public int binarySearch(int[] array, int start, int end, int value) {
            if ((start > end) || ((start == end) && (array[start] != value))) {
                return -1;
            }

            int index = (end + start) / 2;
            if (array[index] == value) {
                return index;
            } else if (array[index] > value) {
                return binarySearch(array, index + 1, end, value);
            } else {
                return binarySearch(array, start, index - 1, value);
            }

        }
}
