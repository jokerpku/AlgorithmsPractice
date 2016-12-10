package algorithms.practice;

import java.util.Random;
import java.util.RandomAccess;

/**
 * Created by Simple on 2016/11/4.
 */
public class HandWrittenTest {


    public static void main(String[] args) {
        Integer[] array = getRandomArray();
        show(array);
//        insertion(array);
//        quicksort(array);
//        selection(array);
        bubble(array);
        show(array);
    }

    private static Integer[] getRandomArray() {
        Integer[] array = new Integer[10];
        long mill = System.currentTimeMillis();
        Random random = new Random(mill);
        for(int i = 0; i < 10; i++) {
            array[i] = (random.nextInt() % 20) + 1;
        }
        return array;
    }
    private static boolean less(Comparable a, Comparable b) {
        return a.compareTo(b) < 0;
    }

    private static void exch(Comparable[] array, int i, int j) {
        Comparable temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    private static void show(Comparable[] array) {
        for(int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
        System.out.println();
    }


    public static void insertion(Comparable[] array) {
        if(array == null || array.length == 0) {
            return;
        }

        for(int i = 1; i < array.length; i++) {
            for(int j = i; j > 0; j--) {
                if(less(array[j], array[j-1])) {
                    exch(array, j, j-1);
                } else {
                    break;
                }
            }
        }
    }

    public static void quicksort(Comparable[] array) {
        if (array == null || array.length == 0) {
            return;
        }
        quicksort(array, 0, array.length - 1);
    }

    private static void quicksort(Comparable[] array, int lo, int hi) {
        if(lo >= hi) {
            return;
        }

        int left = lo;
        int right = hi+1;
        Comparable value = array[lo];
        while(true) {
            while(less(array[++left], value)) {
                if(left == hi) {
                    break;
                }
            }
            while(less(value, array[--right])) {
                if(right==lo) {
                    break;
                }
            }
            if(left >= right) {
                break;
            }
            exch(array,right, left);
        }
        exch(array,right, lo);

        quicksort(array, lo, right-1);
        quicksort(array, right+1, hi);
    }

    public static void selection(Comparable[] array) {
        if(array == null || array.length == 0) {
            return;
        }

        int length = array.length;
        for(int i = 0; i < length; i++) {
            int minIndex = getMinIndex(array, i, length);
            exch(array, i, minIndex);
        }
    }

    private static int getMinIndex(Comparable[] array, int start, int length) {
        int minIndex = start;
        for(int i = start+1; i < length; i++) {
            if(less(array[i], array[minIndex])) {
                minIndex = i;
            }
        }
        return minIndex;
    }

    public static void bubble(Comparable[] array) {
        if(array == null || array.length == 0) {
            return;
        }

        for(int i = array.length; i > 1; i--) {
            boolean hasExch = false;
            for(int j = 1; j < i; j++) {
                if(less(array[j], array[j-1])) {
                    exch(array, j-1, j);
                    hasExch = true;
                }
            }
            if(!hasExch) {
                break;
            }
        }
    }
}
