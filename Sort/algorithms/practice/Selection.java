package algorithms.practice;

/**
 * Created by Jokeria on 2016/11/4.
 */
public class Selection extends SortAlgorithm {
    @Override
    public void sort(Comparable[] array) {
        if(array == null || array.length == 0) {
            return;
        }

        for(int i = 0; i < array.length - 1; i++) {
            int minIndex = findMin(array, i);
            exch(array, i, minIndex);
        }
    }

    private int findMin(Comparable[] array, int start) {
        int result = start;
        for(int i = start + 1; i < array.length; i++) {
            if(less(array[i], array[result])) {
                result = i;
            }
        }
        return result;
    }
}
