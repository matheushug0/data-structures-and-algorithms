package DS.Queue;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class Queue<T> implements Iterable<T> {
    private LinkedList<T> list = new LinkedList<>();

    public Queue() {
    }

    public Queue(T ...element) {
        this.list.addAll(List.of(element));
    }

    public int size() {
        return list.size();
    }

    public boolean isEmpty() {
        return list.isEmpty();
    }

    public T peek() {
        if (isEmpty()) {
            throw new RuntimeException("Queue is empty");
        }
        return list.peekFirst();
    }

    public T pool(){
        if (isEmpty()) {
            throw new RuntimeException("Queue is empty");
        }
        return list.pollFirst();
    }

    public void offer(T element) {
        list.addLast(element);
    }

    @Override
    public Iterator<T> iterator() {
        return list.iterator();
    }

    @Override
    public String toString() {
        return list.toString();
    }
}
