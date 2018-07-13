package sort;

import org.junit.Test;

import java.util.Arrays;
import java.util.Random;

import static sort.TestArray.copyArray;
import static sort.TestArray.getRandom;
import static sort.TestArray.isEquals;
import static sort.TestArray.print;

/**
 * @program: exam
 * @description: QuickSort
 * @author: Zhaoziqi
 * @create: 2018-06-15 13:58
 **/
public class QuickSort {
    public static void quickSort(int[] a) {
        if (a == null || a.length < 2) {
//            throw new Exception("array is null or length less 2");
            return;
        }
        quickSort(a, 0, a.length - 1);
    }

    private static void quickSort(int[] a, int l, int r) {
        if (l < r) {
            int[] p = divide(a, l, r);
            quickSort(a, l, p[0] - 1);
            quickSort(a, p[1] + 1, r);

        }
    }

    private static int[] divide(int[] a, int l, int r) {
        int less = l - 1;
        int more = r;
        swap(a, new Random().nextInt(r - l + 1) + l, r);
        while (l < more) {
            if (a[l] < a[r]) swap(a, l++, ++less);
            else if (a[l] > a[r]) swap(a, l, --more);
            else l++;
        }
        swap(a, r, more);
        return new int[]{++less, more};
    }

    private static void swap(int[] a, int i, int j) {
        int t = a[i];
        a[i] = a[j];
        a[j] = t;
    }

    @Test
    public void fun0() {
        int[] a0 = getRandom(30, 100);
        int[] a1 = copyArray(a0);
        System.out.println("-------------sys");
        Arrays.sort(a0);
        print(a0);
        System.out.println("-------------quick");
        quickSort(a1);
        print(a1);
        System.out.println(isEquals(a0, a1));

    }
}
