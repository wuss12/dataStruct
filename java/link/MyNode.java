package link;

public class MyNode<E> {
   public E value;
    public MyNode next;

    public MyNode(E value,MyNode next){
        this.value = value;
        this.next = next;
    }
    public MyNode( E value){
        this(value,null);
    }
    public void show(){
        System.out.print(value);
    }

    @Override
    public String toString() {
        return value.toString();
    }
}
