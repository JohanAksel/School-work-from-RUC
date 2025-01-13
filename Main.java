// Johan Andreasen - Final Assignment

import java.util.Scanner; // Import Scanner class to read user input

//Main class where the game will run
public class Main {

    public static void main(String[] args) {
        GameGrid gameGrid = new GameGrid(); // Create a new game grid object
        Player player = new Player(0, 0, Direction.NORTH); // Create a player object starting at position (0, 0) facing north
        Scanner scanner = new Scanner(System.in); // Create a Scanner object to read user input

        // Reveal initial visibility of the starting cell
        gameGrid.updateVisibility(player); // Update the visibility based on player's position
        gameGrid.getCell(player.getX(), player.getY()).reveal();  // Reveal the starting cell

        while (true) { // Start the game loop
            // Display the current state of the grid
            gameGrid.displayGridWithHiddenCells(player);

            // Prompt the player for their next move
            System.out.print("Enter your move (L/R/F/E): ");
            String input = scanner.nextLine().toUpperCase(); // Read the input and convert to uppercase in case of lowercase input

            // Handling player input
            if (input.equals("L")) { // checks if the player chooses to turn left
                player.turnLeft(); // Turn the player left
                gameGrid.updateVisibility(player); // Update visibility after turning
            } else if (input.equals("R")) { // check
                player.turnRight(); // Turn the player right
                gameGrid.updateVisibility(player); // Update visibility after turning
            } else if (input.equals("F")) { // If the player chooses to move forward
                if (gameGrid.canMoveForward(player)) { // Check if the player can move forward
                    player.moveForward(); // Move the player forward
                    gameGrid.checkCell(player); // Check the cell the player moved to (e.g., for treasures or traps)
                    gameGrid.updateVisibility(player); // Update visibility after moving
                } else {
                    System.out.println("Cannot move forward!"); // Inform the player if they cannot move forward
                }
            } else if (input.equals("E")) { // If the player chooses to exit the game
                System.out.println("Exiting the cave. Final Score: " + player.getScore()); // Display final score
                break; // Exit the loop and end the game
            } else { // Handle invalid input
                System.out.println("Invalid command."); // Inform the player of invalid input
            }

            // Check if the player is back at the starting position (0,0) to allow exiting
            if (player.getX() == 0 && player.getY() == 0) {
                System.out.print("You are at the cave entrance. Exit? (Y/N): ");
                String exitInput = scanner.nextLine().toUpperCase(); // Read the input to determine if the player wants to exit
                if (exitInput.equals("Y")) { // If the player chooses to exit
                    System.out.println("Exiting the cave. Final Score: " + player.getScore()); // Display final score
                    break; // Exit the loop and end the game
                }
            }
        }

    }
}
