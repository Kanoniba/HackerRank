import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;

public class comparator {

    public static void main(String[] args) {


        PriorityQueue<Student> pq = new PriorityQueue<>(1000, new StudentComparator());
        pq.add(new Student("bb", "20.3", "23"));
        pq.add(new Student("cc", "15.1", "27"));
        pq.add(new Student("aa", "31.1", "21"));
        System.out.println(pq);
        int size = pq.size();
        for (int i = 0; i < size; i++) {
            Student st = pq.poll();
            System.out.println(st.getName() + " cgpa:" + st.getCGPA() + " id:" + st.getID());
            //aa cgpa:31.1 id:21
            //bb cgpa:20.3 id:23
            //cc cgpa:15.1 id:21
        }
    }
}

class LongComparator implements Comparator<Long>
{
    public int compare(Long a, Long b)
    {
        return Long.compare(a,b);
    }
}
class StudentComparator implements Comparator<Student> {
    public int compare(Student A, Student B) {
        // System.out.println(A.getName() +" cgpa:"+A.getCGPA() + " id:"+A.getID() );
        // System.out.println(B.getName() +" cgpa:"+B.getCGPA() + " id:"+B.getID() );
        if (A.getCGPA() > B.getCGPA())
            return -1;
        else if (A.getCGPA() < B.getCGPA())
            return 1;
        else if (A.getName().equals(B.getName())) {
            return A.getID() - B.getID();
        } else {
            return A.getName().compareTo(B.getName());
        }
    }
}

class Student {
    int id;
    String name;
    double cgpa;

    Student() {
    }

    Student(String name, String cgpa, String id) {
        this.name = name;
        this.cgpa = Double.valueOf(cgpa);
        this.id = Integer.valueOf(id);
    }

    int getID() {
        return id;
    }

    String getName() {
        return name;
    }

    double getCGPA() {
        return cgpa;
    }
}