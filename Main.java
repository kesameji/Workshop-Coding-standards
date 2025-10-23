import java.util.*;

class Student {
    String id;
    String name;
    List<Double> gradez;
    String pass = "unknown";
    boolean honor;

    public Student(String i, String n) {
        id = i;
        name = n;
        gradez = new ArrayList<>();
    }

    public void addGrade(Object g) {
        try{
            double grade = (double)g;
            gradez.add(grade);
        }
        catch (Exception ex){
            System.out.println("ERROR: grade is not a valid number between 0-100");
        }
    }

    public double average() {
        double total = 0;
        for (double g : gradez) {
            total += g; // ClassCastException
        }
        double avg = total / gradez.size();
        return avg;

    }

    public void checkHonorStatus() {
        if (average() > 90) {
            honor = true; // Type mismatch (boolean vs String), kept broken
        }

    }

    public void removeGrade(int i) {
        gradez.remove(i);
    }

    public void reportCard() {
        System.out.println("Student: " + name);
        System.out.println("ID: " + id);
        System.out.println("Grades #: " + gradez.size());
        System.out.println("Average: " + this.average()); 
        System.out.println("Honor Roll: " + this.honor); 
    }
}

public class Main {
    public static void main(String[] args) {
        Student s = new Student("abc", null);
        s.addGrade(100);
        // s.AddG("Ninety"); Invalid grade
        s.average();
        s.checkHonorStatus();
        s.removeGrade(9);
        s.reportCard();
    }
}
