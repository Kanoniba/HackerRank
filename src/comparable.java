
import java.util.ArrayList;
import java.util.Collections;

public class comparable {
    public static void main(String[] args) {
        ArrayList<StudentComparable> al = new ArrayList<StudentComparable>();
        al.add(new StudentComparable(101, "AAA", 23));
        al.add(new StudentComparable(106, "BBB", 27));
        al.add(new StudentComparable(105, "CCC", 21));
        Collections.sort(al);
        for (StudentComparable st : al) {

            System.out.println(st.rollno + " " + st.name + " " + st.age);
            //105 CCC 21
            //101 AAA 23
            //106 BBB 27
        }
    }
}

class StudentComparable implements Comparable<StudentComparable> {
    int rollno;
    String name;
    int age;

    StudentComparable(int rollno, String name, int age) {
        this.rollno = rollno;
        this.name = name;
        this.age = age;
    }

    public int compareTo(StudentComparable st) {
        if (age == st.age)
            return 0;
        else if (age > st.age)
            return 1;
        else
            return -1;
    }
}