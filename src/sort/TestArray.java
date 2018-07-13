package sort;

import org.junit.Test;

import java.util.Random;

import static java.lang.System.out;

/**
 * @program: exam
 * @description: judge array equal
 * @author: Stelawliet
 * @create: 2018-06-13 13:45
 **/
public class TestArray {
    private static final Random random = new Random();


    public static boolean isEquals(int[] arr0, int[] arr1) {
        if (arr0 == null || arr1 == null) {
            return false;
        }
        if (arr0.length != arr1.length) {
            return false;
        }

        for (int i = 0; i < arr0.length; i++) {
            if (arr0[i] != arr1[i]) return false;
        }
        return true;
    }

    public static int[] getRandom0(int size, int maxValue) {
        int[] randomArray = new int[size];
        for (int i = 0; i < size; i++) {
            randomArray[i] = random.nextInt(maxValue + 1);
        }
        return randomArray;
    }


    public static int[] getRandom(int maxSize, int maxValue) {
        int size = random.nextInt(maxSize + 1);
        int[] randomArray = new int[size];
        for (int i = 0; i < size; i++) {
            randomArray[i] = random.nextInt(maxValue + 1);
        }
        return randomArray;
    }

    public static void print(int[] array) {
        for (int i = 0; i < array.length; i++) {
            if (i == 0) {
                out.print("{" + array[i] + ",");
            } else if (i == array.length - 1) {
                out.print(array[i] + "}");
            } else {
                out.print(array[i] + ",");
            }
        }
        out.println();
    }

    public static int[] copyArray(int[] array) {
        int[] copyArray = new int[array.length];
        System.arraycopy(array, 0, copyArray, 0, array.length);
        return copyArray;
    }

    public static void test(int[] a0, int[] a1) {

    }

    @Test
    public void testRandom() {
        System.out.println(isEquals(new int[]{1, 3, 3}, new int[]{1, 2}));

        out.println("-------------");
        int[] arr = getRandom(20, 20);
        print(arr);
        print(copyArray(arr));
    }

    @Test
    public void fun0() {
        for (int i = 0; i < 20; i++) {
            System.out.print(random.nextInt(12 - 10 + 1) + 10 + " - ");
        }
    }
}
