package alex.goapiconnector.domain;

public class Stone {
    private char colour;
    private int[] move;

    public Stone(char colour, int[] move) {
        this.colour = colour;
        this.move = move;
    }
    
    public int getColour() {
        return this.colour;
    }

    public int[] getMove() {
        return this.move;
    }
}
