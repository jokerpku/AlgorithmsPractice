package algorithms.practice;

/**
 * Created by Simple on 2016/11/8.
 */
public class TestFinal {
    public static void main(String[] args) {
        FA fa1 = new FA();
        fa1.b = 1;

        FA fa2 = new FB();
        fa2.b = 1;
        test(fa1, fa2);
    }

    static void test(final FA fa1, FA fa2) {
        fa1.b = 2;
        fa2.b = 2;
//        fa1 = fa2;
    }
}

class FA {
    public final int a;
    public int b;

    public FA() {
        a = 1;
    }

    public FA(int v) {
        a = 1;
    }

    public final void test() {
//        a = 1;
        System.out.println("Base class final method;");
    }
}

class FB extends FA {
    //    public void test() {
//        System.out.println("Derived class final method;");
//    }
    public void test2() {
        System.out.println("Derived class method;");
    }
}

