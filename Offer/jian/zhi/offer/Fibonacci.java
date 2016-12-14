package jian.zhi.offer;

/**
 * Created by Simple on 2016/12/14.
 */
public class Fibonacci {
    public long getFibonacci(int n) {
        if(n <= 0) {
            return 0;
        } else if(n == 1) {
            return 1;
        }

        int pre1 = 1;
        int pre2 = 0;
        for(int i = 2; i < n; i++) {
            int temp = pre1 + pre2;
            pre2 = pre1;
            pre1 = temp;
        }

        return pre1 + pre2;
    }

    public static void main(String[] args) {
        Fibonacci instance = new Fibonacci();
        System.out.println(instance.getFibonacci(3));
        System.out.println(instance.getFibonacci(10));
    }
}
