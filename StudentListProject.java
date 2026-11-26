import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Collections;
import java.util.Scanner;

public class StudentListProject {

    static ArrayList<Integer> studentIds = new ArrayList<>();
    static ArrayList<String> studentNames = new ArrayList<>();
    static ArrayList<Integer> studentMarks = new ArrayList<>();
    static LinkedList<String> attendance = new LinkedList<>();

    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {

        int choice;

        do {
            System.out.println("\n====================================");
            System.out.println("       STUDENT MANAGEMENT SYSTEM");
            System.out.println("====================================");
            System.out.println("1. Add Student");
            System.out.println("2. Display All Students");
            System.out.println("3. Search Student");
            System.out.println("4. Update Student Marks");
            System.out.println("5. Remove Student");
            System.out.println("6. Add Student Attendance");
            System.out.println("7. Display Attendance");
            System.out.println("8. Remove Attendance");
            System.out.println("9. Display Student Statistics");
            System.out.println("10. Sort Student Names");
            System.out.println("11. Exit");

            System.out.print("Enter Your Choice: ");
            choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1:
                    addStudent();
                    break;

                case 2:
                    displayStudents();
                    break;

                case 3:
                    searchStudent();
                    break;

                case 4:
                    updateMarks();
                    break;

                case 5:
                    removeStudent();
                    break;

                case 6:
                    addAttendance();
                    break;

                case 7:
                    displayAttendance();
                    break;

                case 8:
                    removeAttendance();
                    break;

                case 9:
                    displayStatistics();
                    break;

                case 10:
                    sortStudentNames();
                    break;

                case 11:
                    System.out.println("Exiting Student Management System...");
                    break;

                default:
                    System.out.println("Invalid Choice! Try Again.");
            }

        } while (choice != 11);

        sc.close();
    }

    // 1. Add Student
    static void addStudent() {

        System.out.print("Enter Student ID: ");
        int id = sc.nextInt();
        sc.nextLine();

        if (studentIds.contains(id)) {
            System.out.println("Student ID already exists!");
            return;
        }

        System.out.print("Enter Student Name: ");
        String name = sc.nextLine();

        System.out.print("Enter Student Marks: ");
        int marks = sc.nextInt();
        sc.nextLine();

        if (marks < 0 || marks > 100) {
            System.out.println("Marks must be between 0 and 100!");
            return;
        }

        studentIds.add(id);
        studentNames.add(name);
        studentMarks.add(marks);

        System.out.println("Student Added Successfully!");
    }

    // 2. Display All Students
    static void displayStudents() {

        if (studentNames.isEmpty()) {
            System.out.println("No Student Records Available!");
            return;
        }

        System.out.println("\n--------- STUDENT RECORDS ---------");
        System.out.printf("%-10s %-20s %-10s%n", "ID", "Student Name", "Marks");

        for (int i = 0; i < studentNames.size(); i++) {
            System.out.printf("%-10d %-20s %-10d%n",
                    studentIds.get(i),
                    studentNames.get(i),
                    studentMarks.get(i));
        }

        System.out.println("Total Students: " + studentNames.size());
    }

    // 3. Search Student
    static void searchStudent() {

        if (studentNames.isEmpty()) {
            System.out.println("No Student Records Available!");
            return;
        }

        System.out.print("Enter Student Name: ");
        String name = sc.nextLine();

        int index = studentNames.indexOf(name);

        if (index != -1) {
            System.out.println("\nStudent Found!");
            System.out.println("ID: " + studentIds.get(index));
            System.out.println("Name: " + studentNames.get(index));
            System.out.println("Marks: " + studentMarks.get(index));
        } else {
            System.out.println("Student Not Found!");
        }
    }

    // 4. Update Student Marks
    static void updateMarks() {

        if (studentNames.isEmpty()) {
            System.out.println("No Student Records Available!");
            return;
        }

        System.out.print("Enter Student Name: ");
        String name = sc.nextLine();

        int index = studentNames.indexOf(name);

        if (index != -1) {

            System.out.print("Enter New Marks: ");
            int newMarks = sc.nextInt();
            sc.nextLine();

            if (newMarks < 0 || newMarks > 100) {
                System.out.println("Marks must be between 0 and 100!");
                return;
            }

            studentMarks.set(index, newMarks);

            System.out.println("Student Marks Updated Successfully!");
            System.out.println("Name: " + studentNames.get(index));
            System.out.println("Updated Marks: " + studentMarks.get(index));

        } else {
            System.out.println("Student Not Found!");
        }
    }

    // 5. Remove Student
    static void removeStudent() {

        if (studentNames.isEmpty()) {
            System.out.println("No Student Records Available!");
            return;
        }

        System.out.print("Enter Student Name: ");
        String name = sc.nextLine();

        int index = studentNames.indexOf(name);

        if (index != -1) {

            studentIds.remove(index);
            studentNames.remove(index);
            studentMarks.remove(index);

            attendance.remove(name);

            System.out.println("Student Removed Successfully!");

        } else {
            System.out.println("Student Not Found!");
        }
    }

    // 6. Add Student Attendance
    static void addAttendance() {

        if (studentNames.isEmpty()) {
            System.out.println("No Students Available!");
            return;
        }

        System.out.print("Enter Student Name: ");
        String name = sc.nextLine();

        if (!studentNames.contains(name)) {
            System.out.println("Student Not Found in Student Records!");
            return;
        }

        if (attendance.contains(name)) {
            System.out.println("Attendance Already Marked!");
            return;
        }

        System.out.println("1. Add at Beginning");
        System.out.println("2. Add at End");
        System.out.print("Enter Position Choice: ");
        int position = sc.nextInt();
        sc.nextLine();

        if (position == 1) {
            attendance.addFirst(name);
            System.out.println("Attendance Added at Beginning!");
        } else if (position == 2) {
            attendance.addLast(name);
            System.out.println("Attendance Added at End!");
        } else {
            System.out.println("Invalid Position Choice!");
        }
    }

    // 7. Display Attendance
    static void displayAttendance() {

        if (attendance.isEmpty()) {
            System.out.println("Attendance List is Empty!");
            return;
        }

        System.out.println("\n--------- ATTENDANCE LIST ---------");

        for (String name : attendance) {
            System.out.println(name);
        }

        System.out.println("Total Present Students: " + attendance.size());
    }

    // 8. Remove Attendance
    static void removeAttendance() {

        if (attendance.isEmpty()) {
            System.out.println("Attendance List is Empty!");
            return;
        }

        System.out.print("Enter Student Name to Remove Attendance: ");
        String name = sc.nextLine();

        if (attendance.contains(name)) {
            attendance.remove(name);
            System.out.println("Attendance Removed Successfully!");
        } else {
            System.out.println("Student Not Found in Attendance!");
        }
    }

    // 9. Display Student Statistics
    static void displayStatistics() {

        if (studentMarks.isEmpty()) {
            System.out.println("No Student Records Available!");
            return;
        }

        int highest = studentMarks.get(0);
        int lowest = studentMarks.get(0);
        int total = 0;
        int above75 = 0;

        for (int marks : studentMarks) {

            if (marks > highest) {
                highest = marks;
            }

            if (marks < lowest) {
                lowest = marks;
            }

            total += marks;

            if (marks > 75) {
                above75++;
            }
        }

        double average = (double) total / studentMarks.size();

        System.out.println("\n--------- STUDENT STATISTICS ---------");
        System.out.println("Total Students: " + studentNames.size());
        System.out.println("Highest Marks: " + highest);
        System.out.println("Lowest Marks: " + lowest);
        System.out.println("Average Marks: " + average);
        System.out.println("Students Above 75: " + above75);
    }

    // 10. Sort Student Names
    static void sortStudentNames() {

        if (studentNames.isEmpty()) {
            System.out.println("No Student Records Available!");
            return;
        }

        ArrayList<String> sortedNames = new ArrayList<>(studentNames);

        System.out.println("1. Alphabetical Order");
        System.out.println("2. Reverse Order");
        System.out.print("Enter Your Choice: ");
        int sortChoice = sc.nextInt();
        sc.nextLine();

        if (sortChoice == 1) {

            Collections.sort(sortedNames);
            System.out.println("\nStudent Names in Alphabetical Order:");

            for (String name : sortedNames) {
                System.out.println(name);
            }

        } else if (sortChoice == 2) {

            Collections.sort(sortedNames);
            Collections.reverse(sortedNames);

            System.out.println("\nStudent Names in Reverse Order:");

            for (String name : sortedNames) {
                System.out.println(name);
            }

        } else {
            System.out.println("Invalid Sorting Choice!");
        }
    }
}