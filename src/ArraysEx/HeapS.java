package ArraysEx;

import java.util.Arrays;

import static sort.TestArray.copyArray;
import static sort.TestArray.getRandom;
import static sort.TestArray.isEquals;
import static sort.TestArray.print;

/**
 * @program: exam
 * @description:
 * @author: Zhaoziqi
 * @create: 2018-06-25 21:19
 **/
public class HeapS {
    //2*i+1 left
    //2*i+2 right
    //(i-1)/2 parent
    //     0
    //   1   2
    // 3  4  5  6
    //
    public static void heapSort(int[] a) {
        heapSort(a, a.length);
    }

    public static void heapSort(int[] a, int size) {
        heapSet(a, size);
        for (int i = size - 1; i > 0; ) {
            swap(a, 0, i--);
            heapFiy(a, i+1);
        }
    }

    public static void heapSet(int[] a, int size) {
        for (int i = 0; i < size; i++) {
            while (i > 0 && a[i] > a[(i - 1) / 2]) {
                swap(a, i, (i - 1) / 2);
                i = (i - 1) / 2;
            }
        }
    }

    public static void heapFiy(int[] a, int size) {
        int left;
        int right;
        for (int i = 0; i * 2 + 1 < size; ) {
            left = i * 2 + 1;
            right = i * 2 + 2;
            int max = right < size && a[right] > a[left] ? right : left;
            max = a[i] > a[max] ? i : max;
            if (max == i) return;
            swap(a, max, i);
            i = max;
        }
    }

    public static void swap(int[] a, int i, int j) {
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
