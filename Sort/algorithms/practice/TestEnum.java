package algorithms.practice;

/**
 * Created by Simple on 2016/11/8.
 */
public class TestEnum {

    public static void main(String[] args) {
        System.out.println();
        int i = EA.RED.hashCode();
        EA[] eaArray = EA.values();

        test(EA.RED);
    }

    static void test(Enum e) {
        Enum[] es = e.getClass().getEnumConstants();
        for(Enum ele : es) {
            if(ele instanceof EA) {
                System.out.println(((EA)ele).toString());
            }
        }
    }
}

enum EA {
    RED(1),
    GREEN(2),
    YELLOW(3);

    int val;

    private EA(int v) {
        val = v;
    }

}

enum EB {
    YEAR,
    MONTH,
    DAY;
}

//enum EC extends EB {
//
//}


