package org.seating;

import org.entities.Student;
import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter username:");
        String adminUsername = scanner.nextLine();
        System.out.println("Enter password:");
        String adminPassword = scanner.nextLine();
        if (!adminUsername.equals("admin") || !adminPassword.equals("password")) {
            System.out.println("Invalid credentials!!");
            return;
        }

        System.out.println("Enter number of students:");
        int numberOfStudents = scanner.nextInt();
        System.out.println("Enter number of available classes:");
        int numberOfClasses = scanner.nextInt();
        System.out.println("Enter number of seats per class:");
        int numberOfSeatsPerClass = scanner.nextInt();

        ArrayList<Student> students = new ArrayList<Student>();
        int i = 1;
        while (i <= numberOfStudents) {
            scanner.nextLine();
            System.out.println("Enter student name:" + i + ":");
            String name = scanner.nextLine();
            System.out.println("Enter student roll number:" + i + ":");
            String rollNumber = scanner.nextLine();
            System.out.println("Enter student branch:" + i + ":");
            String branch = scanner.nextLine();
            System.out.println("Enter student semester:" + i + ":");
            int semester = scanner.nextInt();
            System.out.println("Enter student year:" + i + ":");
            int year = scanner.nextInt();
            students.add(new Student(rollNumber,name,semester,branch,year));
            i++;
        }
        ExamSeatingSystem examSeatingSystem = new ExamSeatingSystem(students, numberOfStudents,
                numberOfClasses, numberOfSeatsPerClass);

        examSeatingSystem.generateSeatingArrangement();
    }

}