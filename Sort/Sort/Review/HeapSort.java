package Sort.Review;

import algorithms.practice.SortAlgorithm;
import practice.util.Util;

/**
 * Created by Simple on 2016/12/8.
 */
public class HeapSort extends SortAlgorithm{
    @Override
    public void sort(Comparable[] array) {
        if(array == null || array.length == 0) {
            return;
        }
        int len = array.length-1;
        for(int i = len/2; i > 0; i--) {
            sink(array, i, len);
        }

        int end = len;
        while(end > 0) {
            exch(array, 1, end);
            sink(array, 1, --end);
        }
    }

    private void sink(Comparable[] array, int k, int end) {
        while(2*k <= end) {
            int i = 2*k;
            if(i < end && less(array[i], array[i+1])) {
                i++;
            }
            if(less(array[k], array[i])) {
                exch(array, k, i);
                k = i;
            } else {
                break;
            }
        }
    }

    public static void main(String[] args) {
        Integer[] array = Util.getRandomArray();
        HeapSort instance = new HeapSort();
        instance.sort(array);
        instance.show(array);
    }
}
