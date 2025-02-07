package b.DoublyLinkedList;

public class DoublyLinkedListImpl {
    public static void main(String[] args) {
        DoublyLinkedList<Integer> list = new DoublyLinkedList<Integer>();
        list.addFirst(1);
        list.addLast(2);
        list.addLast(3);
        list.addLast(4);
        list.addFirst(-1);
        list.addFirst(-2);
        System.out.println(list);
        System.out.println("First: " + list.peekFirst());
        System.out.println("Last: " + list.peekLast());
        System.out.println("Size List: " + list.size());
        System.out.println("Removed: " + list.removeLast());
        System.out.println("Last: " + list.peekLast());
        System.out.println("Contains First: " + list.contains(1));
        System.out.println("Remove First: " + list.remove(1));
        System.out.println("Remove at index: " + list.removeAt(0));
        System.out.println("Index of First: " + list.indexOf(1));
        list.clear();
        System.out.println(list);

    }
}
