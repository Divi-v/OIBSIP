import java.util.Scanner;
import java.util.Random;

class NumberGuessingGame {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Random random = new Random();

        int maxAttempts = 10;
        int score = 0;
        int originalNumber = random.nextInt(100) + 1;

        System.out.println("*************** WELCOME TO NUMBER GUESSING GAME ***************");
        System.out.println("Rules of the Game:");
        System.out.println("1. You have " + maxAttempts + " attempts to guess the number.");
        System.out.println("2. For every unsuccessful attempt, you lose 1 point.");
        System.out.println("3. For a successful attempt, you earn 10 points.");
        System.out.println("4. Guess a number between 1 and 100\n");

        boolean playAgain = true;

        while (playAgain) {
            int numOfAttempts = 0;
            score = 0;
            originalNumber = random.nextInt(100) + 1;

            while (numOfAttempts < maxAttempts) {
                System.out.print("Enter your guess: ");
                int numOfGuess = input.nextInt();

                if (numOfGuess == originalNumber) {
                    score += 10;
                    System.out.println("Congratulations! You won the game.");
                    System.out.println("Your score is " + score + ", and you guessed it in " + (numOfAttempts + 1) + " attempts.\n");
                    break;
                } else if (numOfGuess < originalNumber) {
                    System.out.println("Your guess is too low.");
                } else if (numOfGuess > originalNumber) {
                    System.out.println("Your guess is too high.");
                }

                numOfAttempts++;
                score--;

                if (numOfAttempts < maxAttempts) {
                    System.out.println("Attempts remaining: " + (maxAttempts - numOfAttempts));
                }
            }

            if (numOfAttempts >= maxAttempts) {
                System.out.println("Sorry, you have exceeded the maximum number of attempts.");
                System.out.println("The correct number was: " + originalNumber);
            }

            System.out.print("Do you want to play again? (yes/no): ");
            String play = input.next().toLowerCase();
            playAgain = play.equals("yes");
        }

        System.out.println("Thank you for playing the Number Guessing Game.");
        input.close();
    }
}
