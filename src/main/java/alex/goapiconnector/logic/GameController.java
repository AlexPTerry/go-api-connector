package alex.goapiconnector.logic;

public class GameController {

    private final int MIN_COORDINATE = 1;
    private final int MAX_COORDINATE;

    public GameController(int boardSize) {
        this.MAX_COORDINATE = boardSize;
    }

    public int getMIN_COORDINATE() {
        return MIN_COORDINATE;
    }

    public int getMAX_COORDINATE() {
        return MAX_COORDINATE;
    }
    
    public boolean isValidMove(int x, int y) {
        return (MIN_COORDINATE <= x && x <= MAX_COORDINATE && MIN_COORDINATE <= y && y <= MAX_COORDINATE);
    }
    
}
