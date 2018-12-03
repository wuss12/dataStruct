package link;

public class LinkedStack<E extends Comparable> {
    LinkedList<E> linkedList;
   public LinkedStack (){
       linkedList = new LinkedList<>();
   }
    public boolean isEmpty(){
        return linkedList.isEmpty();
    }
    public void push(E value){
        linkedList.insertFirst(value);
    }
    public E pop(){
        MyNode<E> deleteNode = linkedList.deleFirst();
        return deleteNode == null? null: deleteNode.value;
    }

    public void show(){
        linkedList.display();
    }
    public static void main(String[] args) {
        LinkedStack<Integer> stack = new LinkedStack<>();
        for (int i=1;i<5;i++){
            stack.push(i);
        }
        stack.show();
        System.out.println(stack.pop());
        stack.show();
        System.out.println(stack.pop());
        stack.show();
    }

}
