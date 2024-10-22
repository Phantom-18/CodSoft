import java.util.Scanner;

public class StudentGradeCalculator{

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

       String[] subjects = {
        "Object Oriented Programming",
        "Compiler Design",
        "Operating System",
        "Software Engineering",
        "Artificial Intelligence",
        "Introducton to Industrial Management"
       };
       int numberOfSubjects = subjects.length;
       int[] marks = new int[numberOfSubjects];
       int totalMarks = 0;

       for(int i = 0; i< numberOfSubjects; i++){
        System.out.print("Enter marks for " + subjects[i] + " (out of 100)");
        marks[i] = sc.nextInt();

        while(marks[i] < 0 || marks[i] > 100 ){
            System.out.println("Invalid input!!!. Please enter marks between 0 and 100");
            System.out.println("Enter marks for" + subjects[i] + " (out of 100)");
            marks[i] = sc.nextInt();
        }
        totalMarks += marks[i];
       }
       double averagePercentage = (double) totalMarks / numberOfSubjects;

       String grade;
       if(averagePercentage >= 90){
        grade = "A+";
       }
       else if(averagePercentage >=80){
        grade = "A";
       }
       else if(averagePercentage >= 70){
        grade = "B+";
       }
       else if(averagePercentage >= 60){
        grade = "B";
       }
       else if(averagePercentage >=50){
        grade = "C";
       }
       else if(averagePercentage >= 40){
        grade = "D";
       }
       else{
        grade = "F";
       }
       System.out.println("\nResults: ");

       for(int i = 0; i < numberOfSubjects; i++){
        System.out.println(subjects[i] + "Marks: " + marks[i]);
       }
       System.out.println("Total Marks: " + totalMarks);
       System.out.printf("Average Percentage: %2f%%\n",averagePercentage);
       System.out.println("Grade: " + grade);

       sc.close();
    }
}