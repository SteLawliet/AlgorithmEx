package sort;

import org.junit.Test;

import java.util.Arrays;
import java.util.Random;

import static sort.TestArray.*;

/**
 * @program: exam
 * @description: RandomQuickSort
 * @author: Zhaoziqi
 * @create: 2018-06-14 16:25
 **/
public class RandomQuickSort {
    private static void quickSort(int[] a) {
        if (a == null || a.length < 2) {
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
        int random = new Random().nextInt(r-l+1)+l;
        swap(a,random,r);
        int more = r;
        while (l < more) { //分析错误（less<more)
            if (a[l] < a[r]) {
                swap(a, l++, ++less);
            } else if (a[l] > a[r]) {
                swap(a, l, --more);
            } else {
                l++;
            }
        }
        swap(a, r,more);
        return new int[]{++less,more};
    }

    private static void swap(int[] a, int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    public static void main(String[] args) {
        int[] a0 = getRandom(20,3000);
        int[] a1 = copyArray(a0);
        Arrays.sort(a0);
        System.out.println("-------------sys");
        print(a0);
        quickSort(a1);
        System.out.println("-------------quick");
        print(a1);
        System.out.println(isEquals(a0,a1));
        for (int i = 0; i < 1000; i++) {
            a0 = getRandom(10000,10000);
            a1 = copyArray(a0);
            Arrays.sort(a0);
            quickSort(a1);
            if (!isEquals(a0,a1)) System.out.println(false);
        }
    }
    @Test
    public void testRandomLR(){
        int L = 0;
        int R = 9;
        Random r = new Random();

        for (int i = 0; i < 20; i++) {
            int r0 = r.nextInt(R-L+1)+L;
            int r1 = (int) ((Math.random()*(R-L+1))+L);   //[0,1) 0.00000  16
            System.out.print(r1+" - ");
        }
    }
}
