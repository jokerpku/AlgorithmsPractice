package algorithms.practice;

import java.util.Comparator;

/**
 * Created by Simple on 2016/11/5.
 */
public class MergeSort extends SortAlgorithm {
    protected Comparable[] aux;

    @Override
    public void sort(Comparable[] array) {
        int length = array.length;
        aux = new Comparable[length];
        sort(array, 0, length-1);
    }

    public void sort(Comparable[] array, int lo, int hi) {
        if(lo >= hi) {
            return;
        }

        int mid = lo + (hi - lo)/2;
        sort(array, lo, mid);
        sort(array, mid+1, hi);
        merge(array, lo, mid, hi);
    }

    protected void merge(Comparable[] array, int lo, int mid, int hi) {
        for(int i = 0; i < array.length; i++) {
            aux[i] =array[i];
        }
        int i = lo;
        int j = mid+1;
        for(int k = lo; k <= hi; k++) {
            if(i > mid) {
                array[k] = aux[j++];
            } else if (j > hi) {
                array[k] = aux[i++];
            } else if(less(aux[j], aux[i])) {
                array[k] = aux[j++];
            } else {
                array[k] = aux[i++];
            }
        }
    }

}
