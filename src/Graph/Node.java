package Graph;

import java.util.ArrayList;
import java.util.List;

/**
 * @program: exam
 * @description:
 * @author: Zhaoziqi
 * @create: 2018-07-16 11:13
 **/
public class Node {
     int value;
     int in;
     int out;
     List<Node> nodeList = new ArrayList<>();
     List<Edge> edgeList = new ArrayList<>();

    public Node(int value) {
        this.value = value;
    }

    public Node() {
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public int getIn() {
        return in;
    }

    public void setIn(int in) {
        this.in = in;
    }

    public int getOut() {
        return out;
    }

    public void setOut(int out) {
        this.out = out;
    }

    public List<Node> getNodeList() {
        return nodeList;
    }

    public void setNodeList(List<Node> nodeList) {
        this.nodeList = nodeList;
    }

    public List<Edge> getEdgeList() {
        return edgeList;
    }

    public void setEdgeList(List<Edge> edgeList) {
        this.edgeList = edgeList;
    }
}
