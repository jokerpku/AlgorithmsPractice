package jian.zhi.offer;

import Medium.FindRightInterval;

/**
 * Created by Jokeria on 2016/12/14.
 */
public class FindInTwoDimArrays {
    /**
     * 二维数组为n*n大小，每行为递增数列，每列为递增数列
     * 从右上角或者左下角开始查找。以从右上角开始为例：
     * 若当前位置元素比目标值大，则排除当前位置所在的列；若比目标值小，则排除当前位置所在的行
     * @param arrays
     * @param target
     * @return
     */
    public boolean find(int[][] arrays, int target) {
        if(arrays == null) {
            return false;
        }
        int len = arrays.length - 1;
        int n = len;
        int m = 0;
        while(m <= len && n >= 0) {
            if(arrays[m][n] == target) {
                return true;
            } else if(arrays[m][n] < target) {
                m++;
            } else {
                n--;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[][] arrays = {{11,13,14,16},{12,15,17,19},{17,18,19,21},{17,19,22,24}};
        FindInTwoDimArrays instance = new FindInTwoDimArrays();
        boolean res = instance.find(arrays, 23);
        System.out.println();
    }
}
