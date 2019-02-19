package Graph;

import org.junit.Test;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * @program: exam
 * @description:
 * @author: Zhaoziqi
 * @create: 2018-07-16 11:10
 **/
public class Graph {
    HashMap<Integer, Node> nodes = new HashMap<>();
    HashSet<Edge> edges = new HashSet<>();

    public Graph(int[][] arr)  {
        for (int[] ints : arr) {
            int weight = ints[0];
            int from = ints[1];
            int to = ints[2];
            if (!nodes.containsKey(from)){
                nodes.put(from,new Node(from));
            }
            if (!nodes.containsKey(to)){
                nodes.put(to,new Node(to));
            }
            Node f = nodes.get(from);
            Node t = nodes.get(to);
            f.nodeList.add(t);
            f.out++;
            t.in++;
            edges.add(new Edge(weight,f,t));
        }
    }

    public static void BFS0(Node head) {

        if (head.nodeList.size()<1){
            return;
        }
    }
        public static void BFS(Node head) {
        HashSet<Node> hashSet = new HashSet<>();
        Queue<Node> queue = new LinkedList<>();
        queue.add(head);
        System.out.println(head.value + " - ");
        hashSet.add(head);
        while (!queue.isEmpty()) {
            Node node = queue.poll();
            for (Node next : node.nodeList) {
                if (!hashSet.contains(next)) {
                    hashSet.add(next);
                    System.out.print(next.value + " - ");
                    queue.add(next);
                }
            }
        }
    }

    public static void DFS0(Node head) {
        HashSet<Node> hashSet = new HashSet<>();
        Stack<Node> stack = new Stack<>();
        stack.push(head);
        hashSet.add(head);
        System.out.println(head.value);
        while (!stack.isEmpty()) {
            Node node = stack.pop();
            for (Node next : node.nodeList) {
                if (!hashSet.contains(next)) {
                    hashSet.add(next);
                    System.out.println(next.value);
                    stack.add(node);
                    stack.add(next);
                    break;
                }
            }
        }
    }

    public static void DFS(Node head){
        HashSet<Node> hashSet = new LinkedHashSet<Node>();
        DFS(head,hashSet);
    }

    public static void DFS(Node head,HashSet<Node> hashSet){
        System.out.println(head.value);
        hashSet.add(head);
        for (Node node : head.nodeList) {
            if (!hashSet.contains(node)){
                DFS(node,hashSet);
            }
        }
    }



    @Test
    public static void main(String[] args) {
        int[][] a = {
                {1,1,2},
                {1,2,3},
                {1,3,4},
                {1,4,5},
                {1,5,6},
                {1,6,7},
                {1,7,8},
                {1,8,1},
                {1,6,1},
                {1,4,2}
        };
        Graph graph = new Graph(a);
        DFS(graph.nodes.get(1));
//        BFS(graph.nodes.get(1));
        System.out.println("graph = " + graph);
    }

}
