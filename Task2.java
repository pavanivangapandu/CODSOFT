import java.util.Random;
import java.util.Scanner;

public class NumberGame {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Random random = new Random();

        int score = 0;
        int round = 1;
        char playAgain;

        do {

            int number = random.nextInt(100) + 1;
            int attempts = 5;
            int guess;
            boolean guessedCorrectly = false;

            System.out.println("\n===== ROUND " + round + " =====");
            System.out.println("Guess a number between 1 and 100");
            System.out.println("You have only 5 attempts.");

            while (attempts > 0) {

                System.out.print("Enter your guess: ");
                guess = sc.nextInt();

                if (guess == number) {
                    System.out.println("Correct! You guessed the number.");
                    score++;
                    guessedCorrectly = true;
                    break;
                } 
                else if (guess > number) {
                    System.out.println("Too High!");
                } 
                else {
                    System.out.println("Too Low!");
                }

                attempts--;

                System.out.println("Attempts left: " + attempts);
            }

            if (!guessedCorrectly) {
                System.out.println("You lost! The correct number was: " + number);
            }

            System.out.println("Current Score: " + score);

            System.out.print("Do you want to play again? (y/n): ");
            playAgain = sc.next().charAt(0);

            round++;

        } while (playAgain == 'y' || playAgain == 'Y');

        System.out.println("Thank you for playing!");

        sc.close();
    }
}