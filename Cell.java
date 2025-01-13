// Johan Andreasen - Final Assignment

// Class representing each cell in the game grid
public class Cell {

    // encapsulating the attributes, ensuring that they cannot be accessed or modified directly from outside this class.
    private int x; // Represents the x-position of the cell on the grid.
    private int y; // Represents the y-position of the cell on the grid.
    private char content; // Represents what the cell contains: '.' (empty), 'T' (treasure), 'X' (trap), 'O' (obstacle).
    private boolean isVisible; // Indicates whether the cell should be visible to the player or not (true = visible, false = hidden).

    // Constructor to initialize a Cell object with specific coordinates
    public Cell(int x, int y) {
        this.x = x; // Sets the x-coordinate for this cell to the provided value.
        this.y = y; // Sets the y-coordinate for this cell to the provided value.
        this.content = '.'; // Initializes the content of the cell as empty by default.
        this.isVisible = false; // Initializes the cell as hidden by default.
    }

    // Getter method for 'content' to provide access to the cell's content from outside the class.
    public char getContent() {
        return content; // Returns the character representing the content of the cell.
    }

    // Setter method for 'content' to allow modification of the cell's content while ensuring it remains encapsulated.
    public void setContent(char content) {
        this.content = content; // Sets the content of the cell to the provided character value.
    }

    // Getter method for 'isVisible' to check whether the cell is visible from outside the class.
    public boolean isVisible() {
        return isVisible; // Returns true if the cell is visible, false otherwise.
    }

    // Method to reveal the cell, making it visible to the player.
    public void reveal() {
        this.isVisible = true; // Sets the visibility of the cell to true.
    }

    // Method to hide the cell, making it hidden from the player.
    public void hide() {
        this.isVisible = false; // Sets the visibility of the cell to false.
    }
}
