
//Guessing Game
import java.util.Scanner;
import java.util.Random;

public class GuessGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        int roundsWon = 0;
        boolean playAgain = true;

        System.out.println("Welcome to the Number Guessing Game!");

        while (playAgain) {
            int numberToGuess = random.nextInt(100) + 1;
            int attempts = 5;
            boolean guessedCorrectly = false;

            System.out.println("\nI have picked a number between 1 and 100.");
            System.out.println("You have 5 attempts to guess it.");

            while (attempts > 0) {
                System.out.print("Enter your guess: ");
                int userGuess = scanner.nextInt();
                if (userGuess == numberToGuess) {
                    System.out.println("Correct! You guessed the number.");
                    guessedCorrectly = true;
                    roundsWon++;
                    break;
                } else if (userGuess < numberToGuess) {
                    System.out.println("Too low.");
                } else {
                    System.out.println("Too high.");
                }

                attempts--;

                if (attempts > 0) {
                    System.out.println("Attempts left: " + attempts);
                }
            }

            if (!guessedCorrectly) {
                System.out.println("You're out of attempts. The number was: " + numberToGuess);
            }

            System.out.print("Do you want to play again? (yes/no): ");
            String answer = scanner.next().toLowerCase();
            playAgain = answer.equals("yes");
        }

        System.out.println("\nGame Over! You won " + roundsWon + " round(s). Thanks for playing!");
        scanner.close();
    }
}
