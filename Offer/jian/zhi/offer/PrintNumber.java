package jian.zhi.offer;

/**
 * Created by Jokeria on 2016/12/16.
 */

/**
 * 顺序打印从1开始到最大n位数，如n为3时，打印1,2,3，。。。，999
 */
public class PrintNumber {
    public void printNumber(int n) {
        if(n <= 0) {
            return;
        }

        // 考虑可能出现大数情况，用字符数组存储数值
        char[] chars = new char[n];
        printNumber(chars, n, 0);
        System.out.println();
    }

    /**
     * 打印数值，chars存储数值，n为最大位数，m表示最高m位值已确定
     * @param chars
     * @param n
     * @param m
     */
    public void printNumber(char[] chars, int n, int m) {
        if(m == n) {
            printChars(chars);
            return;
        }
        for(int i = 0; i < 10; i++) {
            chars[m] = (char) ('0' + i);
            printNumber(chars, n, m+1);
        }
    }

    /**
     * 从第一个非零位开始打印
     * @param chars
     */
    public void printChars(char[] chars) {
        boolean isBegin = false;
        for(int i = 0; i < chars.length; i++) {
            if(isBegin) {
                System.out.print(chars[i]);
            } else if(chars[i] != '0'){
                isBegin = true;
                System.out.print(chars[i]);
            }
        }
        System.out.print(" ");
    }

    public static void main(String[] args) {
        PrintNumber instance = new PrintNumber();
        instance.printNumber(0);
        instance.printNumber(1);
        instance.printNumber(2);
    }
}
