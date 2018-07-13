package sort;

/**
 * Created by Stelawliet on 18/6/12.
 */

import java.util.Arrays;

import static java.lang.System.out;
import static sort.TestArray.*;

/**
 * @program: exam
 * @description:
 * @author: Stelawliet
 * @create: 2018-06-12 10:00
 **/
public class MyMergeSort {

    public static void mergeSort(int[] arr) {
        // 1 判断数组合理
        if (arr == null || arr.length < 2) {
            return;
        }
        //开始进入排序递归函数，传入的L和R是为了记录递归压栈时的状态变量，
        mergeSort(arr, 0, arr.length - 1);
    }

    public static void mergeSort(int[] arr, int l, int r) {
        if (l == r) {
            return;
        }
        int mid = (l + r) >> 1;
        mergeSort(arr, l, mid);
        mergeSort(arr, mid + 1, r);
        merge(arr, l, mid, r);
    }

    public static void merge(int[] a, int l, int m, int r) {
        //create help array
        int[] help = new int[r - l + 1];
        int p1 = l;
        int p2 = m + 1;
        int i = 0;
        while (p1 <= m && p2 <= r) {
            help[i++] = a[p1] < a[p2] ? a[p1++] : a[p2++];
        }
        while (p1 <= m) {
            help[i++] = a[p1++];
        }
        while (p2 <= r) {
            help[i++] = a[p2++];
        }
        for (i = 0; i < help.length; i++) {
                    a[l + i] = help[i] ;
        }

    }


    public static void main(String[] args) {
        int[] a = getRandom0(20,20);
        int[] a0 = copyArray(a);
        out.println("-------------------");
        print(a);
        out.println("-------------------sys");
        Arrays.sort(a0);
        print(a0);
        out.println("-------------------my");
        mergeSort(a);
        print(a);
        out.println("-------------------");

        out.println(isEquals(a,a0));
        for(int i = 0; i < 10000; i++){
            int[] arr = getRandom0(2000,2000);
            int[] arr0 = copyArray(arr);
            Arrays.sort(arr);
            mergeSort(arr0);
            if (!isEquals(arr0,arr)){
                System.out.println(false);
                return;
            }
        }
        System.out.println(true);
    }
}

