package DS.DoublyLinkedList;

import java.util.Iterator;

public class DoublyLinkedList<T> implements Iterable<T> {
    private int size;
    private Node<T> head;
    private Node<T> tail;

    public DoublyLinkedList() {
        this.size = 0;
        head = tail = null;
    }

    public void addFirst(T data) {
        Node<T> newNode = new Node<>(data);
        if (head == null && tail == null) {
            head = tail = newNode;
        } else {
            head.prev = newNode;
            head.prev.next = head;
            head = head.prev;
        }
        size++;
    }

    public void addLast(T data) {
        Node<T> newNode = new Node<>(data);
        if (head == null && tail == null) {
            head = tail = newNode;
        } else {
            newNode.prev = tail;
            tail.next = newNode;
            tail = tail.next;
        }
        size++;
    }

    public T peekFirst() {
        if (isEmpty()) {
            throw new RuntimeException("Empty list");
        }
        return head.data;
    }

    public T peekLast() {
        if (isEmpty()) {
            throw new RuntimeException("Empty list");
        }
        return tail.data;
    }

    public T removeFirst() {
        if (isEmpty()) {
            throw new RuntimeException("Empty list");
        }
        T data = head.data;
        head = head.next;
        size--;
        if (isEmpty()) {
            tail = null;
        } else {
            head.prev = null;
        }
        return data;
    }

    public T removeLast() {
        if (isEmpty()) {
            throw new RuntimeException("Empty list");
        }
        T data = tail.data;
        tail = tail.prev;
        size--;
        if (isEmpty()) {
            head = null;
        } else {
            tail.next = null;
        }
        return data;
    }

    private T remove(Node<T> node) {
        if (node.prev == null) {
            return removeFirst();
        }
        if (node.next == null) {
            return removeLast();
        }
        //Make the pointers of adjacent nodes skip over 'node'
        node.next.prev = node.prev;
        node.prev.next = node.next;

        //Temporary storage the 'node' data
        T data = node.data;

        //Cleaning the memory
        node.data = null;
        node.prev = node.next = null;

        size--;
        return data;
    }

    public boolean remove(Object obj) {
        Node<T> trav = head;

        //Searching for null
        if (trav == null) {
            for (trav = head; trav != null; trav = trav.next) {
                if (trav.data == null) {
                    remove(trav);
                    return true;
                }
            }
            //Searching for non null Object
        } else {
            for (trav = trav.next; trav != null; trav = trav.next) {
                if (obj.equals(trav.data)) {
                    remove(trav);
                    return true;
                }
            }
        }
        return false;
    }

    public T removeAt(int index) {
        //Checking if the index is valid
        if (index < 0 || index >= size) {
            throw new RuntimeException("Index out of bounds");
        }
        int i;
        Node<T> trav;

        //Searching from the head of the list
        if (index < size / 2) {
            for (i = 0, trav = head; i != index; i++) {
                trav = trav.next;
            }
            //Searching from the tail of the list
        } else {
            for (i = size - 1, trav = tail; i != index; i--) {
                trav = trav.prev;
            }
        }
        return remove(trav);
    }

    public int indexOf(Object obj) {
        int index = 0;
        Node<T> trav = head;
        if (obj == null) {
            for (trav = head; trav != null; trav = trav.next, index++) {
                if (trav.data == null) {
                    return index;
                }
            }
            //Searching for non-null Object
        } else {
            for (trav = head; trav != null; trav = trav.next, index++) {
                if (obj.equals(trav.data)) {
                    return index;
                }
            }
        }
        return -1;
    }

    public boolean contains(Object obj) {
        return indexOf(obj) != -1;
    }

    public void clear() {
        Node<T> temp = head;
        while (temp != null) {
            Node<T> next = temp.next;
            temp.next = null;
            temp.data = null;
            temp = next;
        }
        head = null;
        tail = null;
        size = 0;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            private Node<T> current = head;

            @Override
            public boolean hasNext() {
                return current != null;
            }

            @Override
            public T next() {
                T data = current.data;
                current = current.next;
                return data;
            }
        };
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        Node<T> current = head;
        while (current != null) {
            if (current.next == null) {
                sb.append(current.data);
            } else {
                sb.append(current.data + ", ");
            }
            current = current.next;
        }
        sb.append("]");
        return sb.toString();
    }
}
