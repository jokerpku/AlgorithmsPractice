package algorithms.practice;

import java.util.Map;

/**
 * Created by Simple on 2016/11/8.
 */
public class TestParam {

    public static void main(String[] args) {
        int a = 1;
        Integer a1 = 1;
        String s = "1";

        int as[] = {1, 1};
        String ss[] = {"1", "1"};

        test(a);
        System.out.println("a = " + a);
        test(a1);
        System.out.println("a1 = " + a1);
        test(s);
        System.out.println("s = " + s);
        test(as);
        System.out.println("as[0] = " + as[0]);
        test2(as);
        System.out.println("as[0] = " + as[0]);//
        test(ss);
        System.out.println("ss[0] = " + ss[0]);
        test2(ss);
        System.out.println("ss[0] = " + ss[0]);//
    }


    static void test(int a) { //
        a = 2;
    }

    static void test(Integer a) {
        a = 2;
    }

    static void test(String a) {
        a = "2";
    }

    static void test(int[] a) {
        int b[] = {2, 2};
        a = b;
    }

    static void test2(int[] a) {
        int b[] = {2, 2};
        a[0] = b[0];
    }

    static void test(String[] a) {
        String b[] = {"2", "2"};
        a = b;
    }

    static void test2(String[] a) {
        String b[] = {"2", "2"};
        a[0] = b[0];

    }


}


