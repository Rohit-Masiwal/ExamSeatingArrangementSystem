package org.seating;

import org.entities.Student;
import java.util.*;

class ExamSeatingSystem {
    private static ArrayList<Student> students = new ArrayList<Student>();
    private static int numberOfStudents;
    private static int numberOfClasses;
    private static int numberOfSeatsPerClass;

    public ExamSeatingSystem(ArrayList<Student> students, int numberOfStudents, int numberOfClasses, int numberOfSeatsPerClass) {
        this.students = students;
        this.numberOfStudents = numberOfStudents;
        this.numberOfClasses = numberOfClasses;
        this.numberOfSeatsPerClass = numberOfSeatsPerClass;
    }

    // Generate seating arrangement
    public void generateSeatingArrangement() {
        int totalSeats = numberOfClasses * numberOfSeatsPerClass;
        if (numberOfStudents > totalSeats) {
            System.out.println("No seats are available");
            return;
        }

        // Sort students by roll number
        Collections.sort(students, new Comparator<Student>() {
            public int compare(Student s1, Student s2) {
                return s1.getRollNumber().compareTo(s2.getRollNumber());
            }
        });

        int numberOfSeatCount = 0;
        int numberOfRows = 1;
        for (Student student : students) {
            int seatNumber = numberOfSeatCount % numberOfSeatsPerClass + 1;
            student.setSeatNumber(seatNumber);
            student.setRowNumber(numberOfRows);
            numberOfSeatCount++;

            if (numberOfSeatCount % numberOfSeatsPerClass == 0) {
                numberOfRows++;
            }
        }

        System.out.println("Seating arrangement:");
        int classNumber = 1;
        while (classNumber <= numberOfClasses) {
            System.out.println("Class " + classNumber + ":");
            int seatNumber = 1;
            while (seatNumber <= numberOfSeatsPerClass) {
                System.out.print("Seat " + seatNumber + ": ");
                for (Student student : students) {
                    if (student.getSeatNumber() == seatNumber && student.getRowNumber() == classNumber) {
                        System.out.print(student.getName() + " (" + student.getRollNumber() + ")");
                    }
                }
                System.out.println();
                seatNumber++;
            }
            classNumber++;
        }
    }
}