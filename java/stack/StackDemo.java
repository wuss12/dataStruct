package stack;

import java.util.EmptyStackException;
import java.util.Stack;

public class StackDemo<E> {
    private Object[] arr;
    private int maxSize;
    private int position;
    public StackDemo(int size){
        if(size < 0){
            throw new IllegalArgumentException("illegal size: "+size);
        }
        this.maxSize = size;
        arr = new Object[size];
        position = -1;
    }
    public boolean isEmpty(){
       return position == -1;
    }
    public boolean isFull(){
        return position == maxSize -1;
    }

    public boolean push(E value){
        if(position < maxSize -1){
            arr[++position] = value;
            return true;
        }
        return false;
    }
    public E peek(){
        return (E) arr[position];
    }

    public E pop(){
        if(position >=0){
            return (E)arr[position--];
        }
        throw new EmptyStackException();
    }

    public static void main(String[] args) {
        testInt();
        testChar();
    }

    private static void testInt() {
        StackDemo stackDemo = new StackDemo(10);
        for (int i=0;i<10;i++){
            stackDemo.push(i+1);
        }
        while (!stackDemo.isEmpty()){
            System.out.print(stackDemo.pop());
        }
        System.out.println();
    }
    private static void testChar() {
        String str = "i love you";
        StackDemo stackDemo = new StackDemo(str.length());
        for (int i=0;i<str.length();i++){
            stackDemo.push(str.charAt(i));
        }
        while (!stackDemo.isEmpty()){
            System.out.print(stackDemo.pop());
        }
        System.out.println();
    }
}
