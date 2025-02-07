package a.DynamicArray;

public class ArrayImpl {
    public static void main(String[] args) {
        Array<Integer> arr = new Array<>();
        arr.add(1);
        arr.add(2);
        arr.add(3);
        arr.add(4);
        arr.add(5);
        System.out.println(arr);
        arr.remove(2);
        System.out.println(arr);
        System.out.println(arr.get(3));
        System.out.println(arr.indexOf(5));
        System.out.println(arr.contains(8));
    }
}
