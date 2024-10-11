import java.util.Random;
import java.util.Scanner;

public class Exc52 {

 
    
public static void main(String[] args) {
    Scanner in = new Scanner(System.in); // scanner for user input
    Random bla = new Random(); // random class for random number generation

    // generate random number
    int number = bla.nextInt(100) + 1;
    int attempts = 0; // variable for number of attempts

    // prompt to get user to input guess
    System.out.println("I am thinking of a number from 1 to 100. Can you guess it?");
    
    
    // Loop that runs while the variable attempts is less than 3
    while (attempts <3 ) {
        attempts++; // increments the number of attempts
        int guess = in.nextInt(); // variable that puts users input as an int and stores it in guess
        
        // if statement that checks if the guess is higher or lower than the number or equal to the number
    if (guess > number)
    {System.out.println("your guess is higher than the number. Guess again");
    } else if (guess < number) 
    {System.out.println("your guess is lower than the number. Guess again");
    } else System.out.println("Correct! You've guessed the number.");
    
    // if statement that checks if the number of attempts is equal to 3 or if the guess is equal to the number
    if (attempts == 3 || guess == number) {
        System.out.println("its over.");
        break;
    }
    }

    System.out.println("I was thinking of: " + number);


}


}
