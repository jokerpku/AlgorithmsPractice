package jian.zhi.offer;

import java.util.Arrays;

/**
 * 将n个骰子掷在地上，朝上的一面和为s，求s所有可能的值出现的概率
 * Created by Jokeria on 2017/1/3.
 */
public class PrintProbability {
    static int MAX_VALUE = 6;
    public int[] printProbability(int n) {
        if(n <= 0) {
            return null;
        }

        int[][] counts = new int[2][MAX_VALUE * n + 1];
        int flag = 0;
        for(int i = 1; i <= MAX_VALUE; i++) {
            counts[0][i] = 1;
        }
        for(int i = 2; i <= n; i++) {
            for(int j = i; j <= i * MAX_VALUE; j++) {
                int temp = 0;
                for(int k = 1; k <= MAX_VALUE; k++) {
                    if(j - k > 0) {
                        temp += counts[flag][j - k];
                    }
                }
                if(flag == 0) {
                    counts[1][j] = temp;
                } else {
                    counts[0][j] = temp;
                }
            }
            flag = flag ^ 1;
        }

        double total = Math.pow(MAX_VALUE, n);
        counts[flag][0] = (int) total;
        for(int i = 1; i < n; i++) {
            counts[flag][i] = 0;
        }

        return counts[flag];
    }

    public static void main(String[] args) {
        PrintProbability instance = new PrintProbability();
        int[] res = instance.printProbability(3);
        System.out.println();
    }
}
