package sort;/**
 * Created by Stelawliet on 18/6/13.
 */

import java.util.Arrays;

import static java.lang.System.out;
import static sort.TestArray.copyArray;
import static sort.TestArray.getRandom;
import static sort.TestArray.isEquals;
import static sort.TestArray.print;

/**
 * @program: exam
 * @description: SelectionSort
 * @author: Stelawliet
 * @create: 2018-06-13 17:41
 **/
public class SelectionSort {
    public static void sort(int[] a) {
       // for 0 -> n-2 i++
        for (int i = 0; i < a.length-1; i++){
            //  for i -> n-2 j++
            for (int j = i; j < a.length -1 ; j++){
                if( a[i] > a[j+1]){
                    InsertSort.swap(a,i,j+1);
                }
            }
        }
    }

    public static void main(String[] args) {
        int[] a0=  getRandom(20,20);
        int[] a1 = copyArray(a0);
        out.println("-----------");
        sort(a0);
        out.println("----------- sel");

        print(a0);
        Arrays.sort(a1);
        out.println("-----------sys");

        print(a1);
        System.out.println(isEquals(a0,a1));

    }

}
