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
        int endX = nums[0].length - lo - 1;
        int endY = nums.length - lo - 1;

        // 从左到右打印一行
        for(int i = lo; i <= endX; i++) {
            System.out.print(nums[lo][i] + " ");
        }

        // 从上到下打印一列
        for(int i = lo + 1; i <= endY; i++) {
            System.out.print(nums[i][endX] + " ");
        }

        // 从右到左打印一行
        if(endY > lo) {
            for (int i = endX - 1; i >= lo; i--) {
                System.out.print(nums[endY][i] + " ");
            }
        }

        // 从下到上打印一列
        if(lo < endX) {
            for (int i = endY - 1; i > lo; i--) {
                System.out.print(nums[i][lo] + " ");
            }
        }

        System.out.print("### ");
    }

    public static void main(String[] args) {
//        int[][] nums = {{1,2,3,4},{5,6,7,8},{9,10,11,12},{13,14,15,16},{17,18,19,20}};
//        int[][] nums = {{1,2,3},{4,5,6},{7,8,9},{10,11,12},{13,14,15}};
//        int[][] nums = {{1,2,3,4,5},{6,7,8,9,10},{11,12,13,14,15},{16,17,18,19,20}};
//        int[][] nums = {{1,2,3,4,5},{6,7,8,9,10},{11,12,13,14,15}};
//        int[][] nums = {{1,2,3,4},{5,6,7,8},{9,10,11,12},{13,14,15,16}};
        int[][] nums = {{1,2,3,4,5},{6,7,8,9,10},{11,12,13,14,15},{16,17,18,19,20},{21,22,23,24,25}};
        PrintMatrixClockwisely instance = new PrintMatrixClockwisely();
        instance.printMatrixClockwisely(nums);
    }
}
