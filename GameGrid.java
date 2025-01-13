// Johan Andreasen - Final Assignment

import java.util.Random; // Import the Random class for generating random numbers

//class for the games grid
public class GameGrid {

    private static final int GRID_SIZE = 10; // Defining the size of the grid as a constant (10x10)
    private Cell[][] grid; // Declare a 2D array to represent the grid of Cell objects

    // Constructor to initialize the game grid
    public GameGrid() {
        grid = new Cell[GRID_SIZE][GRID_SIZE]; // initializing the grid with array of Cell objects
        initializeGrid(); // Call the method to initialize all cells in the grid
        placeItemsRandomly('T', 5);  // Place 5 treasures randomly on the grid
        placeItemsRandomly('X', 5);  // Place 5 traps randomly on the grid
        placeItemsRandomly('O', 5);  // Place 5 obstacles randomly on the grid
    }

    // Initialize the grid with empty cells
    private void initializeGrid() {
        for (int y = 0; y < GRID_SIZE; y++) { // Loop through each row of the grid
            for (int x = 0; x < GRID_SIZE; x++) { // Loop through each column of the grid
                grid[y][x] = new Cell(x, y); // Create a new Cell object for each position in the grid
            }
        }
    }

    // Randomly place items on the grid
    private void placeItemsRandomly(char item, int count) {
        Random rand = new Random(); // Create a Random object for generating random positions
        int placed = 0; // chechs how many items have been placed
        while (placed < count) { // Continue until the specified number of items are placed
            int x = rand.nextInt(GRID_SIZE); // Generate a random x-coordinate within the grid size
            int y = rand.nextInt(GRID_SIZE); // Generate a random y-coordinate within the grid size
            Cell cell = grid[y][x]; // Get the cell at the generated coordinates

            // Ensure the cell is empty and not the starting position (0,0)
            if (cell.getContent() == '.' && !(x == 0 && y == 0)) {
                cell.setContent(item); // Set the content of the cell to the specified item
                placed++; // Increment the counter as an item has been placed
            }
        }
    }

    // Get the cell at specified coordinates
    public Cell getCell(int x, int y) {
        // Check if the coordinates are within the bounds of the grid
        if (x >= 0 && x < GRID_SIZE && y >= 0 && y < GRID_SIZE) {
            return grid[y][x]; // Return the cell at the specified coordinates
        }
        return null; // Return null if grid coordinates are out of bounds
    }

    // Display the grid with hidden cells as '?'
    public void displayGridWithHiddenCells(Player player) {
        for (int y = 0; y < GRID_SIZE; y++) { // Loop through each row of the grid
            for (int x = 0; x < GRID_SIZE; x++) { // Loop through each column of the grid
                if (player.getX() == x && player.getY() == y) { // Check if the player is at the current cell
                    System.out.print(player.getSymbol() + " "); // Display player symbol
                } else {
                    Cell cell = grid[y][x]; // Get the current cell
                    if (cell.isVisible()) { // Check if the cell is visible
                        System.out.print(cell.getContent() + " "); // Display the content of the cell
                    } else {
                        System.out.print("? "); // Display '?' if the cell is hidden
                    }
                }
            }
            System.out.println(); // Move to the next line after each row
        }
    }

    // Update visibility based on player's position and direction
    public void updateVisibility(Player player) {
        int x = player.getX(); // Get the player's current x-coordinate
        int y = player.getY(); // Get the player's current y-coordinate
        Direction direction = player.getFacingDirection(); // Get the player's current facing direction

        // Update the visibility of cells based on the direction the player is facing
        switch (direction) {
            case NORTH:
                for (int i = y; i >= 0; i--) { // Loop upwards from the player's position
                    Cell cell = getCell(x, i); // Get the cell in the current column
                    cell.reveal(); // Reveal the cell
                    if (cell.getContent() == 'O') { // Stop if an obstacle is encountered
                        break;
                    }
                }
                break;
            case SOUTH:
                for (int i = y; i < GRID_SIZE; i++) { // Loop downwards from the player's position
                    Cell cell = getCell(x, i); // Get the cell in the current column
                    cell.reveal(); // Reveal the cell
                    if (cell.getContent() == 'O') { // Stop if an obstacle is encountered
                        break;
                    }
                }
                break;
            case EAST:
                for (int i = x; i < GRID_SIZE; i++) { // Loop to the right from the player's position
                    Cell cell = getCell(i, y); // Get the cel in the current row
                    cell.reveal(); // Reveal the cell
                    if (cell.getContent() == 'O') { // Stop if an obstacle is encountered
                        break;
                    }
                }
                break;
            case WEST:
                for (int i = x; i >= 0; i--) { // Loop to the left from the player's position
                    Cell cell = getCell(i, y); // Get the cell in the current row
                    cell.reveal(); // Reveal the cell
                    if (cell.getContent() == 'O') { // Stop if an obstacle is encountered
                        break;
                    }
                }
                break;
        }
    }

    // Check if the player can move forward
    public boolean canMoveForward(Player player) {
        int x = player.getX(); // Get the player's current x-coordinate
        int y = player.getY(); // Get the player's current y-coordinate
        Direction direction = player.getFacingDirection(); // Get the player's current facing direction

        // Calculate the next position based on direction
        int nextX = x; // Initializing variable for next x-coordinate
        int nextY = y; // Initializing variable for next y-coordinate

        //switch statement to determine the next position based on the direction
        switch (direction) {
            case NORTH:
                nextY--; // Move upwards (decrease y-coordinate)
                break;
            case SOUTH:
                nextY++; // Move dowwnwards (increase y-coordinate)
                break;
            case EAST:
                nextX++; // Move to the right (increase x-coordinate)
                break;
            case WEST:
                nextX--; // Move to the left (decrease x-coordinate)
                break;
        }

        // Check if next position is within bounds
        if (nextX < 0 || nextX >= GRID_SIZE || nextY < 0 || nextY >= GRID_SIZE) {
            return false; // Return false if the next position is out of bounds
        }

        Cell nextCell = getCell(nextX, nextY); // Get the cell at the next position
        // Check if next cell is an obstacle
        if (nextCell.getContent() == 'O') {
            return false; // Return false if the next cell is an obstacle
        }

        return true; // Return true if the next position is valid and not blocked
    }

    // Handle interactions when the player moves onto a cell
    public void checkCell(Player player) {
        Cell cell = getCell(player.getX(), player.getY()); // Get the cell at the player's current position
        char content = cell.getContent(); // Get the content of the cell

        if (content == 'T') { // Check if the cell contains a treasure
            player.addScore(10); // Add 10 points to the player's score
            System.out.println("You found a treasure! Score: " + player.getScore()); // Print message and updated score
            cell.setContent('.');  // Remove the treasure from the cell, set it to empty
        } else if (content == 'X') { // Check if the cell contains a trap
            player.addScore(-5); // Deduct 5 points from the player's score
            System.out.println("You hit a trap! Score: " + player.getScore()); // Print message and updated score
            cell.setContent('.');  // Remove the trap from the cell, set it to emptty
        }

        // Reveal the cell since the player is now on it
        cell.reveal();
    }
}
