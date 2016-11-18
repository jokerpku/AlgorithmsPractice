package algorithms.practice;

/**
 * Created by Jokeria on 2016/11/4.
 */
public class QuickSort extends SortAlgorithm {
    @Override
    public void sort(Comparable[] array) {
        if(array == null || array.length == 0) {
            return;
        }

        subSort(array, 0, array.length - 1);
    }

    public void subSort(Comparable[] array, int start, int end) {
        if(end <= start) {
            return;
        }

        int left = start;
        int right = end+1;
        Comparable value = array[start];
        while(true) {
            while(less(array[++left], value)) {
                if(left == end) {
                    break;
                }
            }
            while(less(value, array[--right])) {
                if(right == start) {
                    break;
                }
            }
            if(left >= right) {
                break;
            }
            exch(array, left, right);
        }

        exch(array, start, right);
        subSort(array, start, right-1);
        subSort(array, right+1, end);
    }
}
