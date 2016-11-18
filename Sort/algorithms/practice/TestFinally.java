package algorithms.practice;

/**
 * Created by Simple on 2016/11/8.
 */
public class TestFinally {

    public static void main(String[] args) {
        int v = test();
        System.out.println(v);
    }

    static int test() {
        try {
            System.out.println("try");
            return 1;
        } catch(Exception e) {
            System.out.println("catch");
            return 2;
        } finally {
            System.out.println("finally");
            return 3;
        }
    }
}
