package tree;

public class Node<T extends Comparable> {
    public T data;
    public Node leftChild;
    public Node rightChild;

    public Node(T data) {
        this.data = data;
        leftChild = null;
        rightChild = null;
    }

}
