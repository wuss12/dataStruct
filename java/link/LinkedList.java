package link;

public class LinkedList<E extends Comparable> {
    private MyNode<E> first;
    public LinkedList(){
        first = null;
    }
    public boolean isEmpty(){
        return first == null;
    }
    public void insertFirst(E value){
        MyNode newNode = new MyNode(value);
        if(first == null){
            first = newNode;

        }else {
            newNode.next = first;
            first = newNode;
        }
    }

    public MyNode<E> deleFirst(){
        if(first == null){
            return null;
        }
        MyNode<E>  temp = first;
        first = temp.next;
        return temp;
    }

    public void display(){
        MyNode temp = first;
        while (temp!= null){
            temp.show();
            System.out.print("\t");
            temp = temp.next;
        }
        System.out.println();
    }
    public MyNode<E> find(E value){
        MyNode<E> temp = first;
        while (temp != null){
            if(temp.value.compareTo(value) == 0){
                return temp;
            }else {
                temp = temp.next;
            }
        }
        return null;
    }

    public MyNode<E> delete(E value){
        MyNode<E> temp = first;
        MyNode<E> preNode = first;
        while (temp.value.compareTo(value)!=0){
            if(temp.next == null){
                return null;
            }else {
                preNode = temp;
                temp = temp.next;
            }
        }
        if(temp == first){
            first = temp.next;
        }else {
            preNode.next = temp.next;
        }
        return temp;
    }
}
