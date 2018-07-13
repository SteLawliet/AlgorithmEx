package ArraysEx;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @program: exam
 * @description:
 * @author: Zhaoziqi
 * @create: 2018-06-19 15:46
 **/
public class Fanb {

    public static int fan(int n){
        if(n==1||n==2){
            return 1;
        }
        return fan(n-2)+fan(n-1);
    }
    public static int fan0(int n){
        if(n==1||n==2){
            return 1;
        }
        //1,1,2,3,5
        int res1  = 1;
        int res2 = 1;
        int res3 = 0;
        for (int i = 3; i <= n ; i++) {
            res3 = res1 + res2;
            res1 = res2;
            res2 = res3;
        }
        return res3;
    }

    public static void main(String[] args) {

        int fan = fan(20);
        System.out.println("fan = " + fan);


        List<Integer> integers = new ArrayList<>();
        for (int i = 0; i <10 ; i++) {
            integers.add(i);
        }
        System.out.println(integers);
        String s0 = "";

        for (int i :integers){
            s0+="i"+"i"+"i";
        }

    }

}
