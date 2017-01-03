package jian.zhi.offer;

/**
 * Created by Simple on 2017/1/1.
 */
public class NumberOf1Between1AndN {

    public int numberOf1Between1AndN(int n) {
        if(n <= 0) {
            return 0;
        }

        char[] chars = String.valueOf(n).toCharArray();
        return numberOf1(chars, 0);
    }

    public int numberOf1(char[] chars, int lo) {
        if(chars == null || chars.length <= lo) {
            return 0;
        }

        if(chars[lo] > '9' || chars[lo] < '0') {
            return 0;
        }

        if(lo == (chars.length - 1)) {
            if(chars[lo] == '0') {
                return 0;
            } else {
                return 1;
            }
        }

        int numberFirstDigit = 0;
        int first = chars[lo] - '0';
        if(first == 1) {
            numberFirstDigit = tailNumber(chars, lo) + 1;
        } else if(first > 1) {
            numberFirstDigit = powerBase10(chars.length - lo -1);
        }

        int numberOtherDigits = first * powerBase10(chars.length - lo - 2);
        int numberRecursive = numberOf1(chars, lo + 1);

        return numberFirstDigit + numberOtherDigits + numberRecursive;

    }

    public int powerBase10(int n) {
        int result = 1;
        for(int i = 0; i < n; i++) {
            result *= 10;
        }

        return result;
    }

    public int tailNumber(char[] chars, int lo) {
        if(lo >= (chars.length - 1)) {
            return 0;
        }
        String subStr = String.valueOf(chars, lo + 1, chars.length - lo - 1);
        return Integer.parseInt(subStr);
    }

    public static void main(String[] args) {
        NumberOf1Between1AndN instance = new NumberOf1Between1AndN();
        int res = instance.numberOf1Between1AndN(45);
        System.out.println(res);
    }
}
