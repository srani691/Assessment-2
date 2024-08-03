
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
        try {
            students = readDataFromFile(filename);
        } catch (IOException e) {
            System.out.println("Error reading the file: " + e.getMessage());
            return;
        }
    }
    private static List<Student> readDataFromFile(String filename) throws IOException {
         List<Student> students = new ArrayList<>();
         BufferedReader reader = new BufferedReader(new FileReader(filename));
        String line;
        reader.readLine(); // skip the first line (Unit)
        reader.readLine(); // skip the second line (header)
         while ((line = reader.readLine()) != null) {
            if (line.startsWith("#")) continue; // skip comments
            String[] data = line.split(",");
            if (data.length >= 6) {
                String lastName = data[0].trim();
                String firstName = data[1].trim();
                String studentId = data[2].trim();
                double a1 = data[3].trim().isEmpty() ? 0 : Double.parseDouble(data[3].trim());
                double a2 = data[4].trim().isEmpty() ? 0 : Double.parseDouble(data[4].trim());
                double a3 = data[5].trim().isEmpty() ? 0 : Double.parseDouble(data[5].trim());
                students.add(new Student(lastName, firstName, studentId, a1, a2, a3));
            }
        }
        reader.close();
        return students;
    }
}
