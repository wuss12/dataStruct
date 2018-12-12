package tree;

public class Tree<T extends Comparable> {
    private Node<T> root;

    public Node find(T value) {
        Node<T> temp = root;
        while (temp != null) {
            if (temp.data.compareTo(value) == 0) {
                return temp;
            }
            if (temp.data.compareTo(value) > 0) {
                temp = temp.leftChild;

            } else {
                temp = temp.rightChild;
            }

        }
        return temp;
    }

    public void insert(T value) {
        Node<T> node = root;
        Node newNode = new Node(value);
        if (root == null) {
            node = newNode;
            root = node;
            return;
        }
        while (node != null) {
            if (node.data.compareTo(value) > 0) {
                if (node.leftChild == null) {
                    node.leftChild = newNode;
                    return;
                }
                node = node.leftChild;

            } else {
                if (node.rightChild == null) {
                    node.rightChild = newNode;
                    return;
                }
                node = node.rightChild;
            }
        }

    }

    public void show(Node<T> node){
        if(node == null){
            return;
        }
        show(node.leftChild);
        System.out.print(node.data+"  ");
        show(node.rightChild);

    }

    public Node<T> delete(T value){
        Node<T> current = root;
        Node<T> parent = root;
        boolean isLeft = true;
        int result = current.data.compareTo(value);
        while (result != 0){
            parent = current;
            if(result > 0){
                current = current.leftChild;
                isLeft = true;
            }else {
                current = current.rightChild;
                isLeft = false;
            }
            if(current == null){
                return null;
            }
            result = current.data.compareTo(value);
        }

        //叶子节点 start
        if(current.leftChild == null && current.rightChild == null){
            if (current == root){
                root = null;
            }
            if(isLeft){
                parent.leftChild = null;
            }else {
                parent.rightChild = null;
            }
            return current;
        }
        //叶子节点 end
        //if no left child,replace with right subtree
        if(current.leftChild ==  null ){
            if(current == root){
                root = current.rightChild;
                return current;
            }
            if(isLeft){
                parent.leftChild = current.rightChild;
            }else {
                parent.rightChild = current.rightChild;
            }
            return current;
        }
        // if no right child,replace with left subtree
        if(current.rightChild ==  null ){
            if(current == root){
                root = current.leftChild;
                return current;
            }
            if(isLeft){
                parent.leftChild = current.leftChild;
            }else {
                parent.rightChild = current.leftChild;
            }
            return current;
        }
        //two child,replace with inorder successor
        Node successor = getSuccessor(current);
        if(root == successor){
            root = current;
            return current;
        }
        if(isLeft){
            parent.leftChild = successor;
        }else {
            parent.rightChild = successor;
        }
        successor.leftChild = current.leftChild;
        return current;


    }
    // 把后继节点的 右孩子树代替该节点位置，把 该后继节点的 右孩子指向，要删除节点的 右孩子树
    private Node<T>  getSuccessor(Node<T> delNode){
        Node<T> successorParent = delNode;
        Node<T> successor = delNode;
        Node<T> current = delNode.rightChild;
        while (current != null){
            successorParent = successor;
            successor = current;
            current = current.leftChild;
        }
        if(successor != delNode.rightChild){
            successorParent.leftChild = current.rightChild;
            successor.rightChild = delNode.rightChild;
        }
        return successor;
    }

    public static void main(String[] args) {
        Tree<Integer> tree = new Tree<>();
        tree.insert(5);
        for (int i=1;i<10;i++){
            tree.insert(i);
        }
        tree.show(tree.root);
        System.out.println();
       for (int i=1;i<5;i++){
           tree.delete(i);
           tree.show(tree.root);
           System.out.println();
       }
        for (int i=5;i<10;i++){
            tree.delete(i);
            tree.show(tree.root);
            System.out.println();
        }


    }
}
