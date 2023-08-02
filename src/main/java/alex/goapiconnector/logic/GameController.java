package alex.goapiconnector.logic;

import alex.goapiconnector.domain.Board;
import alex.goapiconnector.domain.Stone;

public class GameController {

    private final int MIN_COORDINATE = 1;
    private final int MAX_COORDINATE;
    private Board board;
    private boolean gameOver;
    private boolean blackTurn;
    private boolean passFlag;

    public GameController(int boardSize) {
        MAX_COORDINATE = boardSize;
        board = new Board(boardSize);
        gameOver = false;
        blackTurn = true;
        passFlag = false;
    }

    public void makeMove(int[] move) {
        if (move.length == 0 && passFlag == false) {
            passFlag = true;
            return;
        } else if (move.length == 0 && passFlag == true) {
            gameOver = true;
            return;
        } else {
            passFlag = false;
        }

        Stone stone;
        if (blackTurn) {
            stone = new Stone('b', move);
        } else {
            stone = new Stone('w', move);
        }

        blackTurn = !blackTurn;
        board.placeStone(stone);
    }

    public boolean isGameOver() {
        return gameOver;
    }

    public int getMIN_COORDINATE() {
        return MIN_COORDINATE;
    }

    public int getMAX_COORDINATE() {
        return MAX_COORDINATE;
    }

    public Board getBoard() {
        return board;
    }
    
    public boolean isValidMove(int x, int y) {
        return (MIN_COORDINATE <= x && x <= MAX_COORDINATE && MIN_COORDINATE <= y && y <= MAX_COORDINATE);
    }
    
}
