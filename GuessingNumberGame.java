import java.util.Random;
import java.util.Scanner;

public class GuessingNumberGame{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Random rd = new Random();
        
        int totalRounds = 0;
        int roundsWon = 0;

        while(true){
            int numberToGuess = rd.nextInt(100) + 1;
            int attempts = 0;
            int maxAttempts = 10;
            boolean guessedCorrectly = false;


            System.out.println("Welcome to the Number GuessingGame !!");
            System.out.println("I'm thinking of a number between 1 and 100. ");
            System.out.println("You have " + maxAttempts + " attempts to guess the correct number.");

            while(attempts < maxAttempts && !guessedCorrectly){
                System.out.print("Enter your guess: ");

                try{
                    int guess = Integer.parseInt(sc.nextLine());
                    attempts++;

                    if(guess < numberToGuess){
                        System.out.println(("Too low! Try again"));
                    }
                    else if(guess > numberToGuess){
                        System.out.println("Too high! Try again");
                    }
                    else{
                        guessedCorrectly = true;
                        roundsWon++;
                        System.out.println("Congratulations! You've guessed the number " + numberToGuess + " in " + attempts + " attempts. ");
                    }
                }catch(NumberFormatException e){
                    System.out.println("Please enter a valid number !!!");
                }
            }

            if (!guessedCorrectly){
                System.out.println("Sorry!!! You've run out of attempts. The number was: " + numberToGuess + ".");
            }

            totalRounds++;
            System.out.print("Do you want to play again?? (Y/N): ");
            String playAgain = sc.nextLine().toLowerCase();
            if(!playAgain.equals("Y")){
                break;
            }
        }

        System.out.println("You played " + totalRounds + " rounds and won " + roundsWon + " times.");
        sc.close();

    }
}