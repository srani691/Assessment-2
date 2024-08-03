
/**
 * Write a description of class StudentMarks here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
import java.io.*;
import java.util.*;
public class StudentMarks
{
    static class Student {
        String lastName;
        String firstName;
        String studentId;
        double[] marks = new double[3];
        double totalMarks;
        public Student(String lastName, String firstName, String studentId, double a1, double a2, double a3) {
            this.lastName = lastName;
            this.firstName = firstName;
            this.studentId = studentId;
            this.marks[0] = a1;
            this.marks[1] = a2;
            this.marks[2] = a3;
            this.totalMarks = a1 + a2 + a3;
        }
        @Override
        public String toString() {
            return lastName + " " + firstName + " (ID: " + studentId + ") - A1: " + marks[0] + ", A2: " + marks[1] + ", A3: " + marks[2] + ", Total: " + totalMarks;
        }
    }
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        List<Student> students = new ArrayList<>();
        String filename = "../data/prog5001_students_grade_2022.csv";

        // Debugging: Print the current working directory
        System.out.println("Current working directory: " + new File(".").getAbsolutePath());
        // Check if the file exists
        File file = new File(filename);
        if (!file.exists()) {
            System.out.println("File not found: " + file.getAbsolutePath());
            return;
        }
    }
}
