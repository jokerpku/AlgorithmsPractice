package jian.zhi.offer;

/**
 * Created by Jokeria on 2016/12/16.
 */
public class PrintMatrixClockwisely {
    public void printMatrixClockwisely(int[][] nums) {
        if(nums == null) {
            return;
        }
        int colums = nums.length;
        int rows = nums[0].length;
        int i = 0;
        while((2 * i) < colums && (2 * i) < rows) {
            printOneCycle(nums, i);
            i++;
        }
    }

    public void printOneCycle(int[][] nums, int lo) {

        // TODO: 2016/12/16
    }
}
