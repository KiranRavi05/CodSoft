package StudentMarksCalculator;

import java.util.Scanner;

public class StudentMarks {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter number of subjects: ");
        int subjectCount = readPositiveInt(scanner);

        int totalMarks = 0;

        for (int i = 1; i <= subjectCount; i++) {
            int marks = readValidMarks(scanner, i);
            totalMarks += marks;
        }

        double average = (double) totalMarks / subjectCount;
        char grade = calculateGrade(average);

        displayResult(totalMarks, average, grade);

        scanner.close();
    }

    // Method to read a valid positive integer
    private static int readPositiveInt(Scanner scanner) {
        int value;
        while (true) {
            if (scanner.hasNextInt()) {
                value = scanner.nextInt();
                if (value > 0) return value;
            } else {
                scanner.next(); // discard invalid input
            }
            System.out.print("Invalid input. Enter a positive number: ");
        }
    }

    // Method to read valid marks between 0 and 100
    private static int readValidMarks(Scanner scanner, int subjectNumber) {
        int marks;
        System.out.print("Enter marks for Subject " + subjectNumber + " (0-100): ");
        while (true) {
            if (scanner.hasNextInt()) {
                marks = scanner.nextInt();
                if (marks >= 0 && marks <= 100) return marks;
            } else {
                scanner.next(); // discard invalid input
            }
            System.out.print("Invalid marks. Enter a value between 0 and 100: ");
        }
    }

    // Method to calculate grade
    private static char calculateGrade(double average) {
        if (average >= 90) return 'A';
        if (average >= 80) return 'B';
        if (average >= 70) return 'C';
        if (average >= 60) return 'D';
        return 'F';
    }

    // Method to display the result
    private static void displayResult(int totalMarks, double average, char grade) {
        System.out.println("\n----- RESULT -----");
        System.out.println("Total Marks       : " + totalMarks);
        System.out.printf("Average Percentage: %.2f%%\n", average);
        System.out.println("Grade             : " + grade);
    }
}
