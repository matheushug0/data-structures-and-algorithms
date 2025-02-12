package DS.Queue;

public class QueueImp {
    public static void main(String[] args) {
        Queue<Integer> queue = new Queue<>(1,2,3,4,5);
        System.out.println(queue);
        System.out.println("Peek: " + queue.peek());
        queue.offer(6);
        System.out.println(queue);
        System.out.println("Pool: " + queue.pool());
        System.out.println(queue);
        System.out.println("Size: " + queue.size());
        System.out.println("Is empty: " + queue.isEmpty());
    }
}
