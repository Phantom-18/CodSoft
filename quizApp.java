import java.util.*;

class QuizApp {
    static Scanner sc = new Scanner(System.in);
    static int score = 0;
    static int currentQuestion = 0;
    static final int TimeLimit = 10;

    
    static String[] question = {
        "1. What is the Capital of India?",
        "2. Who has scored the most number of 100s in ODI?",
        "3. Who is known as the Father of Genetics?",
        "4. Who wrote 'Hamlet'?",
        "5. What is the chemical formula of Carbon Monoxide?"
    };

    static String[][] option = {
        {"A. Mumbai", "B. Delhi", "C. Kolkata", "D. Hyderabad"},
        {"A. Virat Kohli", "B. AB de Villiers", "C. Sachin Tendulkar", "D. Jacques Kallis"},
        {"A. Gregor Mendel", "B. Michael Faraday", "C. Nikola Tesla", "D. Niels Bohr"},
        {"A. Robert Greene", "B. Thomas Nashe", "C. William Shakespeare", "D. Thomas Middleton"},
        {"A. CO", "B. CO2", "C. CH4", "D. CH3COOH"}
    };

    static char[] correctAnswer = {'B', 'A', 'A', 'C', 'A'};
    static char[] userAnswer = new char[question.length];

    public static void main(String[] args) {
        for (currentQuestion = 0; currentQuestion < question.length; currentQuestion++) {
            displayQuestion(currentQuestion);
            char answer = getUserAnswerWithTimer();
            userAnswer[currentQuestion] = answer;

            if (answer == correctAnswer[currentQuestion]) {
                score++;
            }
        }
        displayResults();
    }

    
    static char getUserAnswerWithTimer() {
        TimerTask task = new TimerTask() {
            public void run() {
                System.out.println("\nTime's up! Moving to the next question...");
                userAnswer[currentQuestion] = 'X'; 
                System.out.println();
                System.exit(0);
            }
        };

        Timer timer = new Timer();
        timer.schedule(task, TimeLimit * 1000);

        char answer = 'X'; 


        while (true) {
            System.out.print("Enter your Answer (A/B/C/D): ");
            answer = sc.next().toUpperCase().charAt(0);

            if (answer == 'A' || answer == 'B' || answer == 'C' || answer == 'D') {
                break; // Valid answer, so exit loop
            } else {
                System.out.println("Invalid input. Please enter A, B, C, or D.");
            }
        }

        timer.cancel();
        return answer;
    }

    
    static void displayQuestion(int questionIndex) {
        System.out.println(question[questionIndex]);
        for (String opt : option[questionIndex]) {
            System.out.println(opt);
        }
    }

    
    static void displayResults() {
        System.out.println("\nQuiz Over!!!");
        System.out.println("Your Score: " + score + "/" + question.length);

        for (int i = 0; i < question.length; i++) {
            System.out.println("\nQuestion: " + question[i]);
            System.out.println("Correct Answer: " + correctAnswer[i]);
            if (userAnswer[i] != 'X') {
                System.out.println("Your Answer: " + userAnswer[i]);
            } else {
                System.out.println("Your Answer: (No Answer)");
            }
        }
    }
}
