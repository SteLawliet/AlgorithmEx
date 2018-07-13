package DataStructure;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @program: exam
 * @description: 双队列实现栈
 * @author: Zhaoziqi
 * @create: 2018-07-03 18:32
 **/
public class QueueImpStack<T> {
    private Queue<T> aQueue;
    private Queue<T> bQueue;

    public QueueImpStack() {
        aQueue = new LinkedList<>();
        bQueue = new LinkedList<>();
    }

    private void swap() {
        Queue<T> tQueue = aQueue;
        aQueue = bQueue;
        bQueue = tQueue;
    }

    private boolean aQueueIsEmpty() {
        return aQueue.isEmpty();
    }

    private boolean bQueueIsEmpty() {
        return bQueue.isEmpty();
    }


    public T pop() {
        return bQueue.poll();
    }

    public void push(T t) {
        aQueue.add(t);
        while (!bQueue.isEmpty()) {
            aQueue.add(bQueue.poll());
        }
        swap();
    }

    public boolean isEmpty() {
        return aQueue.size() < 1 && bQueue.size() < 1;
    }

    public static void main(String[] args) {
        QueueImpStack<Integer> stack = new QueueImpStack<>();
        int[] a = {1,2,3,4,5,6};
        for (int i = 0; i < a.length; i++) {
            int i1 = a[i];
            stack.push(i1);
        }
        while (!stack.isEmpty()){
            System.out.print(" "+stack.pop());
        }
    }
}
