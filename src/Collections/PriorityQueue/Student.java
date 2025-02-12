package Collections.PriorityQueue;

public class Student implements Comparable<Student> {
    private int grade;
    private String name;
    public Student(int grade, String name) {
        this.grade = grade;
        this.name = name;
    }

    @Override
    public int compareTo(Student o) {
        return this.grade - o.grade;
    }

    @Override
    public String toString() {
        return String.format("Name: %s | Grade: %s", name, grade);
    }
}
