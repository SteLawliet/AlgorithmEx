package DataStructure;

import org.junit.Test;

import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @program: exam
 * @description:
 * @author: Zhaoziqi
 * @create: 2018-07-03 18:22
 **/
public class MyQueue {
    @Test
    public void testQueue2Stack() {

    }

    public static void main(String[] args) {
        Queue<Integer> queue = new LinkedList<>();
        boolean add = queue.add(1);
        boolean add0 = queue.add(2);
        boolean add1 = queue.add(3);
        boolean add2 = queue.add(4);
        Integer poll = queue.poll();
        Integer poll0 = queue.poll();
        System.out.println("poll = " + poll);
        System.out.println("poll0 = " + poll0);
    }
}
