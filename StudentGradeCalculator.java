import java.util.Scanner;

public class StudentGradeCalculator {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        System.out.println("Enter the number of subjects: ");
        int subjects = s.nextInt();
        int totalMarks = 0;

        //Taking marks input
        for (int i = 1; i <= subjects; i++) {
            System.out.println("Enter the marks for subject " + i + " out of 100: ");
            int marks = s.nextInt();

            //Validate marks
            if (marks > 100 || marks < 0) {
                System.out.println("Invalid marks! Please enter between 0 and 100.");
                i--; //repeat this subject
                continue;
            }
            totalMarks += marks;
        }

        // Calculate average
        double averagePercentage = (double) totalMarks / subjects;

        // Grade calculation
        char grade;
        if (averagePercentage >= 90) {
            grade = 'A';
        } else if (averagePercentage >= 80) {
            grade = 'B';
        } else if (averagePercentage >= 70) {
            grade = 'C';
        } else if (averagePercentage >= 60) {
            grade = 'D';
        } else if (averagePercentage >= 50) {
            grade = 'E';
        } else {
            grade = 'F';

        }
        //Display results
        System.out.println("\n----Result ----");
        System.out.println("Total marks: " + totalMarks);
        System.out.println("Average Perceentagee:" + averagePercentage + "%");
        System.out.println("Grade: " + grade);
        s.close();

    }
}
