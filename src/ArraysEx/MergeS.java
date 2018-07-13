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
 * @create: 2018-06-25 20:35
 **/
public class MergeS {
    public static void mergeSort(int[] a) {
        if (a == null || a.length < 2) {
            return;
        }
        mergeSort(a, 0, a.length - 1);
    }

    private static void mergeSort(int[] a, int l, int r) {
        if (l == r) {
            return;
        }
        int mid = (l + r) >> 1;
        mergeSort(a, l, mid);
        mergeSort(a, mid + 1, r);
        merge(a, l, r, mid);
    }

    private static void merge(int[] a, int l, int r, int mid) {

        int[] help = new int[r - l + 1];
        int p1 = l;
        int p2 = mid + 1;
        int i = 0;
        while (p1 <= mid && p2 <= r) {
            help[i++] = a[p1] < a[p2] ? a[p1++] : a[p2++];
        }
        while (p1 <= mid) {
            help[i++] = a[p1++];
        }
        while (p2 <= r) {
            help[i++] = a[p2++];
        }
//        for (int i0 = 0; l <= r; l++, i0++) {
//            a[l] = help[i0];
//        }
        System.arraycopy(help,0,a,l,help.length);
    }

    public static void main(String[] args) {
        int[] a0 = getRandom(20,3000);
        int[] a1 = copyArray(a0);
        Arrays.sort(a0);
        System.out.println("-------------sys");
        print(a0);
        mergeSort(a1);
        System.out.println("-------------quick");
        print(a1);
        System.out.println(isEquals(a0,a1));
        for (int i = 0; i < 1000; i++) {
            a0 = getRandom(10000,10000);
            a1 = copyArray(a0);
            Arrays.sort(a0);
            mergeSort(a1);
            if (!isEquals(a0,a1)) System.out.println(false);
        }
    }
}
