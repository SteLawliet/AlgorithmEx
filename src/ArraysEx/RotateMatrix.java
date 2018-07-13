package ArraysEx;

import org.junit.Test;

import java.util.Scanner;

/**
 * @program: exam
 * @description: rotate matrix
 * @author: Zhaoziqi
 * @create: 2018-06-19 14:56
 **/
public class RotateMatrix {
    //  00 01 02
//  10 11 12
//  20 21 22
    public static int[][] rotate(int[][] a) {
        int tR = 0;
        int tC = 0;
        int dR = a.length - 1;
        int dC = dR;
        int count = 0;
        while (tC < dC) {
            count = dC - tC;
            for (int i = 0; i < count; i++) {
                swap4(a, new P(tR, tC + i), new P(tR + i, dC), new P(dR, dC - i), new P(dR - i, tC));
            }
            tR++;
            tC++;
            dC--;
            dR--;
        }

        return a;
    }

    public static void swap4(int[][] arr, P a, P b, P c, P d) {
        int a0 = arr[a.x][a.y];
        int b0 = arr[b.x][b.y];
        int c0 = arr[c.x][c.y];
        int d0 = arr[d.x][d.y];
        arr[a.x][a.y] = d0;
        arr[b.x][b.y] = a0;
        arr[c.x][c.y] = b0;
        arr[d.x][d.y] = c0;
    }

    public static int[][] initial2Array(int a, int b) {
        int[][] arr = new int[a][b];
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                arr[i][j] = i * 10 + j;
            }
        }
        return arr;
    }

    public static void swap(int[][] arr, P a, P b) {
        int t = arr[a.x][a.y];
        arr[a.x][a.y] = arr[b.x][b.y];
        arr[b.x][b.y] = t;
    }


    public static void swap0(int[][] arr, int a, int b, int i, int j) {
        int t = arr[a][b];
        arr[a][b] = arr[i][j];
        arr[i][j] = t;
    }

    public static void print(int[][] a) {
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[i].length; j++) {
                System.out.print(a[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void print0(int[][] a) {
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[i].length; j++) {
                if (a[i][j] < 10) {
                    System.out.print("0" + a[i][j] + " ");
                } else System.out.print(a[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void printEdge1(int[][] a, int tR, int tC, int dR, int dC) {
        while (tC <= dC) {
            int status = 0;
            if (tC == dC) {
                System.out.print(" " + a[tR][tC]);
            }
            for (int i = tC; i < dC; i++, status = i == dC ? 1 : 0) {
                System.out.print(" " + a[tR][i]);
            }
            System.out.println();
            for (int i = tR; i < dR; i++, status = i == dR ? 2 : 1) {
                System.out.print(" " + a[i][dC]);
            }
            System.out.println();

            for (int i = dC; i > tC; i--, status = i == tC ? 3 : 2) {
                System.out.print(" " + a[dR][i]);
            }
            System.out.println();

            for (int i = dR; i > tR; i--, status = i == tR ? 4 : 3) {
                System.out.print(" " + a[i][tC]);
            }
            System.out.println();

            tR++;
            tC++;
            dC--;
            dR--;
        }

    }

    public static void printEdge0(int[][] a) {
        printEdge2(a, 0, 0, a.length - 1, a.length - 1);
    }

    public static void printEdge2(int[][] a, int tR, int tC, int dR, int dC) {

        for (; tC <= dC; ) {
            int curC = tC;
            int curR = tR;
            if (tR == dR) {
                System.out.print(a[tR][tC] + " ");
            }
            while (curC != dC) {
                System.out.print(a[curR][curC] + " ");
                curC++;
            }
            System.out.println();

            while (curR != dR) {
                System.out.print(a[curR][curC] + " ");

                curR++;
            }
            System.out.println();

            while (curC != tC) {
                System.out.print(a[curR][curC] + " ");

                curC--;
            }
            System.out.println();

            while (curR != tR) {
                System.out.print(a[curR][curC] + " ");
                curR--;
            }
            System.out.println();


            tR++;
            tC++;
            dC--;
            dR--;

        }


    }


    @Test
    public void swapTest() {
//        int[][] b = initial2Array(7, 7);


    }

    public static void main(String[] args) {
        int[][] b = new int[7][7];
        b[0] = new int[]{1, 1, 1, 1, 1, 1, 1};
        b[1] = new int[]{1, 1, 1, 1, 1, 1, 1};
        for (int i = 0; i < b.length; i++) {
            b[i][0] = 1;
            b[i][1] = 1;
        }

        print(b);
        System.out.println("-------------");
        rotate(b);
        print(b);
        while (true){
            Scanner scanner = new Scanner(System.in);
            String s = scanner.nextLine();
            System.out.println(s);

            System.out.println("-------------");
            rotate(b);
            print(b);
        }

    }
}
