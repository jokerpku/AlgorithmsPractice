package algorithms.practice;

/**
 * Created by Simple on 2016/11/5.
 */
public class MergeBUSort extends MergeSort {
    @Override
    public void sort(Comparable[] array) {
        int length = array.length;
        aux = new Comparable[length];

        for(int sz = 1; sz < length; sz = sz + sz) {
            for(int lo = 0; lo < length/sz; lo = lo+sz+sz) {
                int hi = Math.min(lo+sz+sz-1, length-1);
                merge(array, lo, lo+sz-1, hi);
            }

        }
    }
}
