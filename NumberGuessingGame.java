import java.util.Random;
import java.util.Scanner;

public class NumberGuessingGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        int score = 0;
        String playAgain;

        System.out.println("Welcome to the Number Guessing Game!");

        do {
            int numberToGuess = random.nextInt(100) + 1;  // Generates a random number between 1 and 100
            int numberOfAttempts = 0;
            int maxAttempts = 10;  // Limiting the number of guesses to 10
            boolean guessedCorrectly = false;

            System.out.println("I have selected a number between 1 and 100. Try to guess it!");

            while (numberOfAttempts < maxAttempts && !guessedCorrectly) {
                System.out.print("Enter your guess: ");
                int userGuess = scanner.nextInt();
                numberOfAttempts++;

                if (userGuess == numberToGuess) {
                    System.out.println("Congratulations! You've guessed the correct number.");
                    guessedCorrectly = true;
                    score += (maxAttempts - numberOfAttempts + 1);  // Higher score for fewer attempts
                } else if (userGuess > numberToGuess) {
                    System.out.println("Your guess is too high.");
                } else {
                    System.out.println("Your guess is too low.");
                }

                if (numberOfAttempts == maxAttempts && !guessedCorrectly) {
                    System.out.println("Sorry, you've used all your attempts. The correct number was: " + numberToGuess);
                }
            }

            System.out.println("Your score: " + score);

            System.out.print("Do you want to play again? (yes/no): ");
            playAgain = scanner.next();
        } while (playAgain.equalsIgnoreCase("yes"));

        System.out.println("Thank you for playing! Your final score is: " + score);
        scanner.close();
    }
}
