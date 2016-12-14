package jian.zhi.offer;

/**
 * Created by Simple on 2016/12/14.
 */
public class NumberOf1 {
    public int numberOf1(int n) {
        if(n == 0) {
            return 0;
        }
        int count = 1;
        n = n & (n-1);
        while(n != 0) {
            count++;
            n = n & (n-1);
        }

        return count;
    }

    public static void main(String[] args) {
        NumberOf1 instance = new NumberOf1();
        System.out.println(instance.numberOf1(1024));
        System.out.printf("%08x", 1024);
    }
}
