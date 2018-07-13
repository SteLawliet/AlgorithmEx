package ArraysEx;

import java.util.Arrays;
import java.util.Random;

import sort.TestArray;

import static sort.TestArray.copyArray;
import static sort.TestArray.getRandom;
import static sort.TestArray.isEquals;
import static sort.TestArray.print;

/**
 * @program: exam
 * @description:
 * @author: Zhaoziqi
 * @create: 2018-06-25 20:03
 **/
public class QuickS {
    public static void quickSort(int[] a) {
        if (a==null||a.length<2){
            return;
        }
        quickSort(a,0,a.length-1);
    }
    public static void quickSort(int[] a,int l ,int r) {
        if ( l<r ){
            int[] p =divide(a, l,  r);
            quickSort(a,l,p[0]-1);
            quickSort(a,p[1]+1,r);
        }

    }
        public static int[] divide(int[] a, int l, int r) {
        int more = r;
        int less = l - 1;
        int rVal = new Random().nextInt(r - l + 1) + l;
        swap(a,r,rVal);
        while (l < more) {
            if (a[l]>a[r]){
                swap(a,l,--more);
            } else if (a[l] < a[r]){
                swap(a,++less,l++);
            }else {
                l++;
            }
        }
        swap(a,r,more);
        return new int[]{less+1,more};
    }

    public static void swap(int[] a, int i, int j) {
        int t = a[i];
        a[i] = a[j];
        a[j] = t;
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
}
