// Johan Andreasen - Final Assignment

// Enum to represent the cardinal directions
public enum Direction {
    // Enum constants 
    NORTH,
    EAST,
    SOUTH,
    WEST;

    // Method to get the symbol representing the player based on direction
    public char getSymbol() {
        switch (this) {
            case NORTH:
                // Player facing north is represented by '^'
                return '^';
            case EAST:
                // Player facing east is represented by '>'
                return '>';
            case SOUTH:
                // Player facing south is represented by 'v'
                return 'v';
            case WEST:
                // Player facing west is represented by '<'
                return '<';
            default:
                // Default case to handle unexpected values
                return '?';
        }
    }
}
