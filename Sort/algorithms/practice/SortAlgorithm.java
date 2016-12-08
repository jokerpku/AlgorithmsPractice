package algorithms.practice;

import java.util.Random;

/**
 * Created by Jokeria on 2016/11/4.
 */
public abstract class SortAlgorithm {

    public abstract void sort(Comparable[] array);

    protected boolean less(Comparable a, Comparable b) {
        return a.compareTo(b) < 0;
    }

    protected void exch(Comparable[] array, int i, int j) {
        Comparable t = array[i];
        array[i] = array[j];
        array[j] = t;
    }

    public boolean isSorted(Comparable[] array) {
        for(int i = 1; i < array.length; i++) {
            if(less(array[i], array[i-1])) {
                return false;
            }
        }
        return true;
    }

    public void show(Comparable[] array) {
        for(int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
        System.out.println();
    }


}
