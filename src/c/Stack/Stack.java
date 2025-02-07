package c.Stack;

import b.DoublyLinkedList.DoublyLinkedList;

import java.util.Iterator;

public class Stack<T> implements Iterable<T> {
    DoublyLinkedList<T> list = new DoublyLinkedList<T>();

    public Stack() {
    }

    public Stack(T element) {
        list.addFirst(element);
    }

    public int size(){
        return list.size();
    }

    public boolean isEmpty(){
        return list.isEmpty();
    }

    public void push(T element) {
        list.addLast(element);
    }

    public T pop() {
        return list.removeLast();
    }

    public T peek() {
        return list.peekLast();
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
