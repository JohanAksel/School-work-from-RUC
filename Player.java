// Johan Andreasen - Final Assignment

public class Player {

    private int x;               // Player's x-coordinate
    private int y;               // Player's y-coordinate
    private Direction facingDirection;  // Player's facing direction
    private int score;           // Player's current score

    // Constructor to initialize player's position and facing direction
    public Player(int x, int y, Direction facingDirection) {
        this.x = x;  // Set the player's initial x-coordinate
        this.y = y;  // Set the player's initial y-coordinate
        this.facingDirection = facingDirection;  // Set the player's initial facing direction
        this.score = 0;  // Initial score is set to 0
    }

    // Getter method to get the player's current x-coordinate
    public int getX() {
        return x;  // Return the current x-coordinate of the player
    }

    // Getter method to get the player's current y-coordinate
    public int getY() {
        return y;  // Return the current y-coordinate of the player
    }

    // Getter method to get the player's current facing direction
    public Direction getFacingDirection() {
        return facingDirection;  // Return the current direction the player is facing
    }

    // Getter method to get the player's current score
    public int getScore() {
        return score;  // Return the current score of the player
    }

    // Method to turn the player to the left
    public void turnLeft() {
        // Update facing direction based on the current direction
        switch (facingDirection) {
            case NORTH:
                facingDirection = Direction.WEST;  // If facing north, turn to west
                break;
            case WEST:
                facingDirection = Direction.SOUTH;  // If facing west, turn to south
                break;
            case SOUTH:
                facingDirection = Direction.EAST;  // If facing south, turn to east
                break;
            case EAST:
                facingDirection = Direction.NORTH;  // If facing east, turn to north
                break;
        }
    }

    // Method to turn the player to the right
    public void turnRight() {
        // Update facing direction based on the current direction
        switch (facingDirection) {
            case NORTH:
                facingDirection = Direction.EAST;  // If facing north, turn to east
                break;
            case EAST:
                facingDirection = Direction.SOUTH;  // If facing east, turn to south
                break;
            case SOUTH:
                facingDirection = Direction.WEST;  // If facing south, turn to west
                break;
            case WEST:
                facingDirection = Direction.NORTH;  // If facing west, turn to north
                break;
        }
    }

    // Method to move the player forward in the direction they are facing
    public void moveForward() {
        // Update player's coordinates based on the direction they are facing
        switch (facingDirection) {
            case NORTH:
                y--;  // Moving up in the grid (decreasing y-coordinate)
                break;
            case SOUTH:
                y++;  // Moving down in the grid (increasing y-coordinate)
                break;
            case EAST:
                x++;  // Moving right in the grid (increasing x-coordinate)
                break;
            case WEST:
                x--;  // Moving left in the grid (decreasing x-coordinate)
                break;
        }
    }

    // Method to update the player's score by adding points
    public void addScore(int points) {
        score += points;  // Add the specified number of points to the current score
    }

    // Method to get the symbol representing the player based on their facing direction
    public char getSymbol() {
        return facingDirection.getSymbol();  // Use the getSymbol() method from Direction enum to get the player's symbol
    }
}
