//Task 1 :- NUMBER GAME 
import java.util.Random;   //Random class is used to generate random number 
import java.util.Scanner;

public class NumberGame {
    public static void main(String[] args) 
    {
        Scanner sc = new Scanner(System.in);
        Random random = new Random();       //Created a Random object to generate random numbers 
        int MaximumAttempts = 10;           // maximum no. of attempts allowed 
        boolean playAgain = true;

        while (playAgain)     //Main Game Loop
        {
            int targetNumber = random.nextInt(100) + 1;  //this line will generate a random number between 1 to 100 
            int attempts = 0;
            boolean hasWon = false;

            System.out.println("Welcome to the Number Game!");
            System.out.println("I have generated a random number between 1 and 100.");
            System.out.println("You have " + MaximumAttempts + " attempts to guess the number.");

            while (attempts < MaximumAttempts)  //Guessing Loop 
            {
                System.out.print("Enter your guess: ");
                int guess = sc.nextInt();          //Taking input from user 
                attempts++;

                if (guess < targetNumber) 
                {
                    System.out.println("Too low! Try again.");       
                } 
                else if (guess > targetNumber) 
                {
                    System.out.println("Too high! Try again.");
                }
                 else 
                 {
                    System.out.println("Congratulations! You guessed the correct number.");
                    System.out.println("It took you " + attempts + " attempts.");
                    hasWon = true;
                    break;
                }
            }
            if (!hasWon)   //End of Game Feedback
            {
                System.out.println("You've used all your attempts. The correct number was: " + targetNumber);
            }
            System.out.print("Do you want to play again? (yes/no): ");    // Play Again Prompt
            String response = sc.next();
            playAgain = response.equalsIgnoreCase("yes");
        }
        System.out.println("Thank you for playing the Number Game!");     //Closing the Game
        sc.close();
    }
}