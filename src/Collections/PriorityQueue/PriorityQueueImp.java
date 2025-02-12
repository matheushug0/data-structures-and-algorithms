package Collections.PriorityQueue;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class PriorityQueueImp {
    public static void main(String[] args) {
        PriorityQueue<Student> pq = new PriorityQueue<>();
        Student s1 = new Student(70, "John");
        Student s2 = new Student(80, "Jane");
        Student s3 = new Student(90, "Doe");
        Student s4 = new Student(50, "Kyle");
        Student s5 = new Student(49, "Jack");
        Student s6 = new Student(33, "Wan");
        Student s7 = new Student(40, "Jill");
        Student s8 = new Student(99, "Paul");
        pq.add(s1);
        pq.add(s2);
        pq.add(s3);
        pq.add(s4);
        pq.add(s8);
        pq.add(s5);
        pq.add(s7);
        pq.add(s6);

        List<Student> firstStudents = new ArrayList<>();
        firstStudents.add(pq.poll());
        firstStudents.add(pq.poll());
        firstStudents.add(pq.poll());
        System.out.println(firstStudents);

        PriorityQueue<Integer> pq2 = new PriorityQueue<>(new CustomComparator());
        pq2.add(100);
        pq2.add(200);
        pq2.add(20);
        pq2.add(2);

        System.out.println(pq2);
    }
}
