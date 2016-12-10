package algorithms.practice;

/**
 * Created by Simple on 2016/11/8.
 */
public class TestStatic {

    public static void main(String[] args) {
//        A a = new A();
//        A ab = new B();
//        B b = new B();
//
//        System.out.println(a.v);
//        System.out.println(ab.v);
//        System.out.println(b.v);
////        System.out.println(ab.getClass().v);
//
//        a.test(); //1 3
//        ab.test(); //1 3 2 4
//        b.test(); // 1 3 2 4
//
//        a.test2(); //1
//        ab.test2(); //1
//        b.test2(); //2

//        C c = new C();
//        C ce = new E();
//        D d = new C.D();
//        C.D d = new C.D();
//        E.D d = new E.D();
        E.F f = new E.F();
    }


}

class A {
    public static int v = 1;
    public int t = 3;

    public void test(){
        System.out.println(this.t);
        System.out.println(this.v);
    }

    public static void test2(){
        System.out.println(v);
//        System.out.println(this.v);
    }

}

class B extends A {
    public static int v = 2;
    public int t = 4;

    public void test(){
        System.out.println(super.t);
        System.out.println(super.v);
        System.out.println(this.t);
        System.out.println(this.v);
    }
    public static void test2() {
        System.out.println(v);
    }
}

class C {


    {
        System.out.println("base class code.");
    }
    public static int v = 1;
    static {
        System.out.println("base class static code.");
    }

    public C() {
        System.out.println("base class constructor.");
    }

    static class D {
        {
            System.out.println("nested class code.");
        }
        public static int v = 1;

        static {
            System.out.println("nested class static code.");
        }

        public D() {
            System.out.println("nested class constructor.");
        }
    }

}

class E extends C {
    {
        System.out.println("derived class code.");
    }
    public static int v = 1;
    static {
        System.out.println("derived class static code.");
    }

    public E() {
        System.out.println("derived class constructor.");
    }

    static class F extends C.D {
        {
            System.out.println("derived nested class code.");
        }
        public static int v = 1;

        static {
            System.out.println("derived nested class static code.");
        }

        public F() {
            System.out.println("derived nested class constructor.");
        }
    }

}
