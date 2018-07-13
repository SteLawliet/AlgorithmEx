package DataStructure;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * @program: exam
 * @description: 双队列实现栈
 * @author: Zhaoziqi
 * @create: 2018-07-03 18:32
 **/
public class StackImpQueue<T> {
    private Stack<T> aStack;
    private Stack<T> bStack;

    public StackImpQueue() {
       aStack = new Stack<>();
       bStack = new Stack<>();
    }

    public T poll(){
        return bStack.pop();
    }

    public void add(T t){
        while (!bStack.empty()){
            aStack.push(bStack.pop());
        }
        aStack.push(t);
        while (!aStack.empty()){
            bStack.push(aStack.pop());
        }
    }


    public boolean isEmpty() {
        return aStack.size() < 1 && bStack.size() < 1;
    }

    public static void main(String[] args) {
        StackImpQueue<Integer> queue = new StackImpQueue<>();
        int[] a = {0,1,2,3,4,7,8};
        for (int i = 0; i < a.length; i++) {
            int i1 = a[i];
            queue.add(i1);
            String s = "";
        }
        while (!queue.isEmpty()){
            System.out.print(" "+queue.poll());
        }
    }
}
