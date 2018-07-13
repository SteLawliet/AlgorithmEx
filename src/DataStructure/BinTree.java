package DataStructure;

import java.util.HashMap;

import ArraysEx.Fanb;

/**
 * @program: exam
 * @description:
 * @author: Zhaoziqi
 * @create: 2018-06-20 20:59
 **/
public class BinTree {
    /*
       0
     1   2
   3  4
     */
    public static void print(Tree root){
        if (root == null){
            return;
        }
        System.out.println(root.value);
        print(root.left);
        print(root.right);
    }

    public static Tree created(int[] arr){
        return  new Tree();

    }


    public static void main(String[] args) {
        Fanb fanb = new Fanb();
        Tree root =new Tree(0);
        root.left = new Tree(1);
        root.right = new Tree(2);
        root.left.left = new Tree(3);
        root.left.right = new Tree(4);
        print(root);
    }
}
