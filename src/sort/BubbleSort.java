package sort;/**
 * Created by Stelawliet on 18/6/13.
 */

import java.util.Arrays;

import static sort.TestArray.copyArray;
import static sort.TestArray.getRandom0;
import static sort.TestArray.isEquals;
import static sort.TestArray.print;

/**
 * @program: exam
 * @description: BubbleSort
 * @author: Stelawliet
 * @create: 2018-06-13 19:30
 **/
public class BubbleSort {
    public static void bubbleSort0(int[] a) {
        for (int end = a.length - 1; end > 0; end--) {
            for (int i = 0; i < end; i++) {
                if (a[i] > a[i + 1]) InsertSort.swap(a, i, i + 1);
            }
        }
    }

    public static void bubbleSort(int[] a) {
        for (int i = 0; i < a.length - 1; i++) {
            for (int j = 0; j < a.length - 1 - i; j++) {
                if (a[j] > a[j + 1]) InsertSort.swap(a, j, j + 1);
            }
        }
    }

    public static void main(String[] args) {
        int[] a0 = getRandom0(30, 30);
        int[] a1 = copyArray(a0);
        bubbleSort(a0);
        print(a0);
        Arrays.sort(a1);
        print(a1);
        System.out.println(isEquals(a0, a1));
    }
}
