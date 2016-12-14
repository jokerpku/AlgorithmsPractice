package jian.zhi.offer;

/**
 * Created by Jokeria on 2016/12/14.
 */
//public class Singleton {
//    private static Singleton instance = new Singleton();
//
//    private Singleton() {}
//
//    public static Singleton getInstance() {
//        return instance;
//    }
//
//}
//
//public class Singleton {
//    private static Singleton instance = null;
//
//    private Singleton() {}
//
//    public static synchronized Singleton getInstance() {
//        if(null == instance) {
//            instance = new Singleton();
//        }
//        return instance;
//    }
//
//}
//
//public class Singleton {
//    private static Singleton instance = null;
//
//    private Singleton() {}
//
//    public static Singleton getInstance() {
//        if(null == instance) {
//             synchronized (Singleton.class) {
//                 if(null == instance) {
//                     instance = new Singleton();
//                 }
//             }
//        }
//        return instance;
//    }
//
//}

//public class Singleton {
//    private static volatile Singleton instance = null;
//
//    private Singleton() {}
//
//    public static Singleton getInstance() {
//        if(null == instance) {
//            synchronized (Singleton.class) {
//                if(null == instance) {
//                    instance = new Singleton();
//                }
//            }
//        }
//        return instance;
//    }
//
//}

public enum Singleton {
    instance;
    public void anyMethod() {

    }
}