package sort;

import java.util.Arrays;

import static sort.TestArray.*;

/**
 * @program: exam
 * @description: ClassicalQuickSort
 * @author: Zhaoziqi
 * @create: 2018-06-14 16:36
 **/
public class ClassicalQuickSort {
    public static void quickSort(int[] a) {
        if (a == null || a.length < 2) {
            return;
        }
        quickSort(a, 0, a.length - 1);
    }

    public static void quickSort(int[] a, int l, int r) {
        if (l < r) {
            int p = divide(a, l, r);
            quickSort(a, l, p - 1);
            quickSort(a, p + 1, r);
        }
    }

    public static int divide(int[] a, int l, int r) {
        int less = l - 1;
        int center = a[r];
        int more = r;
        while (l < more) { //分析错误（less<more)
            if (a[l] <= center) {
                swap(a, l++, ++less);
            } else {
                swap(a, l, --more);
            }
        }
        swap(a, r,more);
        return more;
    }

    public static void swap(int[] a, int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    public static void main(String[] args) {
        int[] a0 = getRandom(30,30);
        int[] a1 = copyArray(a0);
        Arrays.sort(a0);
        System.out.println("-------------sys");
        print(a0);
        quickSort(a1);
        System.out.println("-------------quick");
        print(a1);
        System.out.println(isEquals(a0,a1));
        for (int i = 0; i < 1000; i++) {
            a0 = getRandom(100,100);
            a1 = copyArray(a0);
            Arrays.sort(a0);
            quickSort(a1);
            if (!isEquals(a0,a1)) System.out.println(false);
        }

    }
}
