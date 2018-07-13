package sort;/**
 * Created by Stelawliet on 18/6/13.
 */

import org.junit.Test;

import java.util.Arrays;

import static sort.TestArray.copyArray;
import static sort.TestArray.getRandom0;
import static sort.TestArray.isEquals;
import static sort.TestArray.print;

/**
 * @program: exam
 * @description:
 * @author: Stelawliet
 * @create: 2018-06-13 15:54
 **/
public class GetMax {
    public static int getMax(int[] array, int l, int r) {
        int mid = l + ((r - l) >> 1);
        if (l == r) return array[l];
        return Math.max(getMax(array, l, mid), getMax(array, mid + 1, r));
    }

    private static int getMax(int[] array) {

        return getMax(array, 0, array.length - 1);
    }

    public static int getMax0(int[] array) {
        int max = 0;
        for (int i : array) {
            max = i > max ? i : max;
        }
        return max;
    }


    public static void main(String[] args) {
        int[] a = getRandom0(10*10000, 100*10000);
        int[] a0 = copyArray(a);
        int[] a1 = copyArray(a);
        int[] a2 = copyArray(a);
        System.out.println(isEquals(a,a0));
        long s = System.currentTimeMillis();
//        System.out.println(getMax0(a));
        InsertSort.insertSort(a);
        System.out.println( System.currentTimeMillis() -s);
         s = System.currentTimeMillis();
//        System.out.println(getMax(a));
        MyMergeSort.mergeSort(a0);
        System.out.println( System.currentTimeMillis() - s);
        s = System.currentTimeMillis();
//        System.out.println(getMax(a));
        Arrays.sort(a1);
        System.out.println( System.currentTimeMillis() - s);
        System.out.println(isEquals(a,a1));
    }
    @Test
    public  void fun1(){
        short s0=18; s0+=1;
        float f = 1;
        StringBuilder stringBuilder =new StringBuilder();
        String s="hwlll";
        System.out.println();
        s.substring(s.indexOf("w"),s.length());


    }

}
