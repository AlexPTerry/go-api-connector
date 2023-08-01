package alex.goapiconnector.domain;

public class Stone {
    private char colour;
    private int x;
    private int y;

    public Stone(char colour, int x, int y) {
        this.colour = colour;
        this.x = x;
        this.y = y;
    }
    
    public int getColour() {
        return this.colour;
    }

    public int getX() {
        return this.x;
    }
    
    public int getY() {
        return this.y;
    }
    
}
