package a.DynamicArray;

import java.util.Arrays;
import java.util.Iterator;

@SuppressWarnings("unchecked")
public class Array<T> implements Iterable<T> {
    private T[] arr;
    private int len;
    private int capacity;

    public Array() {
        this.len = 0;
        this.capacity = 0;
        this.arr = (T[]) new Object[16];
    }

    public Array(int capacity) {
        if (capacity < 0) {
            throw new IllegalArgumentException("Capacity must be a positive integer");
        }
        this.capacity = capacity;
        this.arr = (T[]) new Object[capacity];
    }

    public int size() {
        return len;
    }

    public boolean isEmpty() {
        return size() == 0;
    }

    public T get(int index) {
        if (index < 0 || index >= len) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + len);
        }
        return arr[index];
    }

    public void clear() {
        for (int i = 0; i < len; i++) {
            arr[i] = null;
        }
        len = 0;
    }

    public void add(T value) {
        if (len + 1 >= capacity) {
            if (capacity == 0) {
                capacity = 1;
            } else {
                capacity *= 2;
            }
            T[] newArr = (T[]) new Object[capacity];
            System.arraycopy(arr, 0, newArr, 0, len);
            arr = newArr;
        }
        arr[len++] = value;
        System.gc();
    }

    public T removeAt(int index) {
        if (index < 0 || index >= len) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + len);
        }
        T value = arr[index];
        T[] newArr = (T[]) new Object[len - 1];
        for (int i = 0, j = 0; i < len; i++, j++) {
            if (i == index) {
                j--;
            } else {
                newArr[j] = arr[i];
            }
        }
        arr = newArr;
        capacity = --len;
        return value;
    }

    public boolean remove(T value) {
        for (int i = 0; i < len; i++) {
            if (arr[i].equals(value)) {
                removeAt(i);
                return true;
            }
        }
        return false;
    }

    public int indexOf(T value) {
        for (int i = 0; i < len; i++) {
            if (arr[i].equals(value)) {
                return i;
            }
        }
        return -1;
    }

    public boolean contains(T value) {
        return indexOf(value) != -1;
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            int index = 0;

            @Override
            public boolean hasNext() {
                return index < len;
            }

            @Override
            public T next() {
                return arr[index++];
            }
        };
    }

    @Override
    public String toString() {
        if (len == 0) return "[]";
        StringBuilder sb = new StringBuilder("[");
        for (int i = 0; i < len - 1; i++) {
            sb.append(arr[i]).append(", ");
        }
        sb.append(arr[len - 1]).append("]");
        return sb.toString();
    }
}
