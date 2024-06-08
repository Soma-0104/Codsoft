package numbergame;
import java.util.Scanner;
import java.util.Random;

public class NumberGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        int minRange = 1;
        int maxRange = 100;
        int attempts = 10;
        boolean playAgain = true;
        int score = 0;

        System.out.println("Welcome to Number game!");

        while (playAgain) {
            int randomNumber = random.nextInt(maxRange - minRange + 1) + minRange;
            int guess;
            System.out.println("I've picked a number between " + minRange + " and " + maxRange + ". You have " + attempts + " attempts to guess it.");

            for (int i = 1; i <= attempts; i++) {
                System.out.print("Attempt " + i + ": Enter your guess: ");
                guess = scanner.nextInt();

                if (guess == randomNumber) {
                    System.out.println("Congratulations! You guessed the correct number in " + i + " attempts.");
                    score++;
                    break;
                } else if (guess < randomNumber) {
                    if (randomNumber - guess > 10) {
                        System.out.println("Too low. Try again.");
                    } else {
                        System.out.println("Low. Try again.");
                    }
                } else {
                    if (guess - randomNumber > 10) {
                        System.out.println("Too high. Try again.");
                    } else {
                        System.out.println("High. Try again.");
                    }
                }

                if (i == attempts) {
                    System.out.println("Sorry, you've run out of attempts. The correct number was: " + randomNumber);
                }
            }

            System.out.print("Do you want to play again? (yes/no): ");
            String playAgainResponse = scanner.next();
            if (!playAgainResponse.equalsIgnoreCase("yes")) {
                playAgain = false;
            }
        }

        System.out.println("Game over. Your score: " + score);
        scanner.close();
    }
}
