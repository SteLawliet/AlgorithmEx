package sort;

import java.util.Arrays;

import static sort.TestArray.copyArray;
import static sort.TestArray.getRandom;
import static sort.TestArray.isEquals;
import static sort.TestArray.print;

/**
 * @program: exam
 * @description: HeapSort
 * @author: Zhaoziqi
 * @create: 2018-06-15 16:28
 **/
public class MyHeapSort {

    public static void heapSort(int[] a) {
        if (a == null || a.length < 2) {
            return;
        }

        for (int i = 0; i < a.length; i++) {
            heapInsert(a, i);
        }
        int size = a.length;
//        swap(a,0, --size);
        while (size > 0) {
            swap(a, 0, --size);
            heapIfy(a, size);
        }
    }

    private static void heapInsert(int[] a, int index) {
        while (a[index] > a[(index - 1) / 2]) {
            swap(a, index, (index - 1) / 2);
            index = (index - 1) / 2;
        }
    }

    private static void heapIfy(int[] a, int size) {
        int index = 0;
        while (index * 2 + 1 < size) {
            int left = index * 2 + 1;
            int largest = left + 1 < size && a[left] < a[left + 1] ? left + 1 : left;
            if (a[index] < a[largest]) {
                swap(a, index, largest);
                index = largest;
            } else break;
        }
    }

    private static void swap(int[] a, int i, int j) {
        int t = a[i];
        a[i] = a[j];
        a[j] = t;
    }

    public static void main(String[] args) {
        int[] a0 = getRandom(30, 40);
        int[] a1 = copyArray(a0);
        Arrays.sort(a0);
        System.out.println("-------------sys");
        print(a0);
        heapSort(a1);
        System.out.println("-------------heap");
        print(a1);
        System.out.println(isEquals(a0, a1));
        for (int i = 0; i < 10000; i++) {
            a0 = getRandom(100, 100);
            a1 = copyArray(a0);
            Arrays.sort(a0);
            heapSort(a1);
            if (!isEquals(a0, a1)) {
                System.out.println(false);
                break;
            }
            if (i == 1000) {
                print(a0);
                print(a1);
            }
        }

    }
}
