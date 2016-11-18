package algorithms.practice;

/**
 * Created by Simple on 2016/11/5.
 */
public class HeapSort extends SortAlgorithm {
    public void sort(Comparable[] array) {
        int N = array.length - 1;
        for(int k = N/2; k > 0; k--) {
            sink(array, k, N);
        }

        while(N > 1) {
            exch(array, 1, N--);
            sink(array, 1, N);
        }
    }

    private void sink(Comparable[] array, int k, int N) {
        while(k*2 <= N) {
            int i = k*2;
            if(i < N && less(array, i, i+1)) {
                i++;
            }
            if(!less(array, k, i)) {
                break;
            }
            exch(array, i, k);
            k = i;
        }
    }

    private void swim(Comparable[] array, int k, int N) {
        while(k>1 && less(array, k/2, k)) {
            exch(array, k, k/2);
            k = k/2;
        }
    }

    private boolean less(Comparable[] array, int a, int b) {
        return array[a].compareTo(array[b]) < 0;
    }
}
