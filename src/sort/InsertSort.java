package sort;/**
 * Created by Stelawliet on 18/6/12.
 */

import java.sql.SQLOutput;
import java.util.Arrays;

import static java.lang.System.out;
import static sort.TestArray.copyArray;
import static sort.TestArray.getRandom0;
import static sort.TestArray.isEquals;
import static sort.TestArray.print;

/**
 * @program: exam
 *
 * @description: insert
 *
 * @author: Stelawliet
 *
 * @create: 2018-06-12 18:31
 **/
public class InsertSort {

    // a b    c d e
    // 0 1    3 4 2

//1 0


    public static void insertSort0(int[] arr){
        for (int i = 1; i < arr.length; i++ ){
            for ( int j = i; j > 0 && arr[j] < arr[j-1] ; j--){
                  swap(arr,j-1,j);
            }
        }
    }
    public static void insertSort(int[] arr){
        for (int i = 1; i < arr.length; i++ ){
            for ( int j = i; j > 0   ; j--){
                if(arr[j] < arr[j-1]) swap(arr,j-1,j);
                else break;
            }
        }
    }

    public static void swap(int[] arr, int a,int b){
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }

    public static void main(String[] args) {
        int[] arr = getRandom0(200,300);
        int[] arr0 = copyArray(arr);
        out.println("-----beforeSort-----");
        out.println("arr: ");
        print(arr);
        out.println("arr0: ");

        print(arr0);

        Arrays.sort(arr0);
        insertSort(arr);
        out.println("-----afterSort-----");
        out.println("arr: ");

        print(arr);
        out.println("arr0: ");
        print(arr0);

        boolean flag = isEquals(arr0,arr);

        if (flag) out.println("成功");
        else out.println("错误");

    }


}
