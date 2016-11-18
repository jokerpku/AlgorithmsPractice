package algorithms.practice;

/**
 * Created by Jokeria on 2016/11/4.
 */
public class Insertion extends SortAlgorithm {

    @Override
    public void sort(Comparable[] array) {
        if(array == null || array.length == 0) {
            return;
        }
        for(int i = 1; i< array.length; i++) {
            for(int j = i; j > 0 && less(array[j], array[j - 1]); j--) {
                exch(array, j-1, j);
            }

        }
    }

}
