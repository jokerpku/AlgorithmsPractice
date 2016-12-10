package algorithms.practice;

/**
 * Created by Simple on 2016/11/5.
 */
public class MaxPQ<T extends Comparable<T>> {
    private T[] pq;
    private int N = 0;
    public static final int MAX_N = 30;

    public MaxPQ(int max){
        pq = (T[]) (new Comparable[max + 1]);
        N = 0;
    }

    public MaxPQ(T[] array) {
        pq = (T[]) (new Comparable[MAX_N + 1]);
        N = array.length;
        for(int i = 0; i < N; i++) {
            pq[i+1] = array[i];
        }
    }

    public T max() {
        return pq[1];
    }

    public T delMax() {
        T m = max();
        exch(1, N--);
        pq[N+1] = null;
        sink(1);
        return m;
    }

    public void insert(T v) {
        pq[++N] = v;
        swim(N);
    }

    private void sink(int k) {
        while(2*k <= N) {
            int i = 2 * k;
            if(i < N && less(i, i+1)) {
                i++;
            }
            if(!less(k, i)) {
                break;
            }
            exch(k, i);
            k = i;
        }
    }

    private void swim(int k) {
        while(k>1 && less(k/2, k)) {
            exch(k/2, k);
            k = k/2;
        }
    }

    public int size() {
        return N;
    }

    public boolean isEmpty() {
        return N == 0;
    }

    private void exch(int a, int b) {
        T temp = pq[a];
        pq[a] = pq[b];
        pq[b] = temp;
    }

    private boolean less(int a, int b) {
        return pq[a].compareTo(pq[b]) < 0;
    }

}
