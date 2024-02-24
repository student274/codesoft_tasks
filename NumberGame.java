package CodeSoft;
import java.util.Scanner;
import java.util.Random;

public class NumberGame {

	public static void main(String[] args) {
		        Scanner scanner = new Scanner(System.in);
		        Random random = new Random();
		        int minRange = 1;
		        int maxRange = 100;
		        int maxAttempts = 5;
		        int score = 0;

		        System.out.println("-----Welcome to the Number Guessing Game!----");
		        
		        System.out.println("I have chosen a number between 1 and 100. Can you guess it?");

		        while (true) {
		            int targetNumber = random.nextInt(maxRange - minRange + 1) + minRange;
		            System.out.println("New round started. Your current score is: " + score);
		            int attempts = 0;

		            while (true) {
		                System.out.println("Enter your guessing number: ");
		                int userGuess = scanner.nextInt();
		                attempts++;

		                if (userGuess == targetNumber) {
		                    System.out.println("Congratulations! You've guessed the number correctly in" + attempts + " attempts!");
		                    score += maxAttempts - attempts + 1;
		                    break;
		                } else if (userGuess < targetNumber) {
		                    System.out.println("Your guess is too low. Try again.");
		                } else {
		                    System.out.println("Your guess is too high. Try again.");
		                }

		                if (attempts == maxAttempts) {
		                    System.out.println("your attemp is finished. The correct number was: " + targetNumber);
		                    break;
		                }
		            }

		            System.out.println("Would you like to play again? (yes/no)");
		            String playAgain = scanner.next();

		            if (!playAgain.equalsIgnoreCase("yes")) {
		                System.out.println("Your final score is: " + score);
		                break;
		            }
		        }

		        
		    }
		

	}


