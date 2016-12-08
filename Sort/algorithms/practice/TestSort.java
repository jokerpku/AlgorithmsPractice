package algorithms.practice;

import practice.util.Util;

import java.util.Random;

/**
 * Created by Jokeria on 2016/11/4.
 */
public class TestSort {
    private static SortAlgorithm sortAlgorithm;


    public static void main(String[] args) {
//        Integer[] array = {10, 4, 6, 20, -1, 4, 13, 43, 32};
        Integer[] array = Util.getRandomArray();

//        sortAlgorithm = new Insertion();
//        sortAlgorithm = new Selection();
//        sortAlgorithm = new QuickSort();
//
//        sortAlgorithm = new HeapSort();
//        sortAlgorithm = new MergeSort();
        sortAlgorithm = new MergeBUSort();
        sortAlgorithm.show(array);
        sortAlgorithm.sort(array);
        sortAlgorithm.show(array);

//        MaxPQ<Integer> maxPQ = new MaxPQ<Integer>(20);
//        for(int i = 0; i < array.length; i++) {
//            maxPQ.insert(array[i]);
//        }
//
//        maxPQ.delMax();
//        maxPQ.insert(15);
//        System.out.println(maxPQ.max());

        testLongestFilePath();

    }



    public static void testSort() {
        SortAlgorithm sortAlgorithm;
        Integer[] array = {10, 4, 6, 20, -1, 4, 13, 43, 32};

//        sortAlgorithm = new Insertion();
//        sortAlgorithm = new Selection();
        sortAlgorithm = new QuickSort();

        sortAlgorithm.sort(array);
        sortAlgorithm.show(array);
    }

    public static void testSingleNumber() {
        SingleNumber single = new SingleNumber();
        int[] array = {4, 6, 6, -1, 4, 13, 13, 32};
        int[] result = single.findTwoOnesInTwos(array);
        System.out.println("single.findTwoOnesInTwos result is " + result[0] + " " + result[1]);

        int[] array2 = {5,8,4,3,5,3,2,4,8,8,3,5,4};
        System.out.println("single.findAOnesInThree result is " + single.findAOnesInThree(array2));
        System.out.println("single.findAOnesInThree2 result is " + single.findAOnesInThree2(array2));

    }

    public static void testLongestFilePath() {
        LongestFilePath longestFilePath = new LongestFilePath();
//        String input = "dir\n\tsubdir1\n\tsubdir2\n\t\tfile.ext";
//        String input = "dir\n\tsubdir1\n\t\tfile1.ext\n\t\tsubsubdir1\n\tsubdir2\n\t\tsubsubdir2\n\t\t\tfile2.ext";
        String input = "slkjd\n\tslkdjf\n\t\txckljv\n\t\t\tsldkjflskjd.lsdkj\n\t\tlckfjlakjerlkjlfjs.slkjflkje\n\tsldkfjlksj\n\t\tlkcjvlksj\n\t\tlkjlkasjdflkjawklf\n\tslkdfjslkjdfkl\n\t\tlskajflkasjklaj\n\t\tlskdjlsadjfklajfkls.sldkfjlksdjf\n\t\tsldfjlskdjfklsdjfksjdlfjsadkfjlsajf.lskdjflksadjfkljasdf\n\tsldkfjlksjdfklsdjfkljkcxkklckalkjf\n\t\tlckjlskadjfkljsdkljfx\n\t\tlkjlkjlkf.lfskjflkjsfslkjvlkjwaoijflksjkljsaoiuaiorfklsjfkljksjvklaiogsljgkljf\n\tsldkfjlksadjf\n\tslkjflksjfkljsklfj\n\txlkvjlaksjfljsaklfj\nslkfjskldajflkasjdfljskdfjxcvlkjirfijfkljvkljxviojgklfjlkvnblkjrlgjsljglkdbnlkjkbjkzzzzz\n\tzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzz.zzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzz";
        int length = longestFilePath.lengthLongestPath(input);
        System.out.println("lengthLongestPath result is " + length);
    }

}
