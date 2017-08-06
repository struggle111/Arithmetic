package data;

/**
 * Created by baiyuanwei on 17/7/13.
 */
public class Node {

    private int data;
    private Node next;

    public Node(int data) {
        this.data = data;
    }

    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }

    public Node getNext() {
        return next;
    }

    public void setNext(Node node) {
        next = node;
    }
}
