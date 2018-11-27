package queue;

public class QueueDemo1<E> {
    int maxSize;
    Object[] arr;
    int front;//头,从头移除
    int rear;//尾，从尾插入
    int size;

    public QueueDemo1(int maxSize) {
        this.maxSize = maxSize;
        arr = new Object[maxSize];
        front = 0;
        rear = -1;
        size = 0;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public boolean isFull() {
        return size == maxSize;
    }

    public void add(E value) {
        if (isFull()) {
            throw new RuntimeException("queue is full can not add");
        }
        if (rear == maxSize - 1) {
            rear = -1;
        }
        arr[++rear] = value;
        size++;
    }

    public boolean hasNext() {
        return !isEmpty();
    }
    public int size(){
        return size;
    }


    public E remove() {
        if (isEmpty()) {
            throw new RuntimeException("queue is empty can not remove");
        }
        if (front == maxSize) {
            front = 0;
        }
        E value = (E) arr[front++];
        size--;
        return value;
    }


    public static void main(String[] args) {
        QueueDemo1<Integer> queue = new QueueDemo1<>(10);

        queue.add(1);
        queue.add(2);
        queue.remove();
        queue.remove();
        for (int i = 0; i < 10; i++) {

            queue.add(3 + i);
        }
        while (queue.hasNext()) {
            System.out.print(queue.remove());
        }


    }
}
