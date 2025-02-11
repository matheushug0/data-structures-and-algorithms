package c.Stack;

public class StackImpl {
    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        stack.push(5);
        System.out.println(stack);
        System.out.println("Popped Element: " + stack.pop());
        System.out.println("Popped Element: " + stack.pop());
        System.out.println(stack);
        System.out.println("Peek: " + stack.peek());
        System.out.println("Stack Size: " + stack.size());

        for (Integer i : stack) {
            System.out.println(i);
        }
    }
}
