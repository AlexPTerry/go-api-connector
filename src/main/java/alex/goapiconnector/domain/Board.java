package alex.goapiconnector.domain;

import java.util.Arrays;
import java.util.Map;
import com.google.common.collect.ImmutableMap;

public class Board {
    private int[][] boardState;
    private int blackCaptures;
    private int whiteCaptures;

    private final Map<Integer, Character> MOVE_CONVERSION;

    public Board(int boardSize) {
        this.boardState = new int[19][19];
        this.blackCaptures = 0;
        this.whiteCaptures = 0;

        MOVE_CONVERSION = ImmutableMap.of(
            0, '+',
            1, '●',
            2, '⚬'
        );
    }

    public boolean sameBoardState(Board board) {
        return Arrays.equals(this.boardState, board.getBoardState());
    }

    public int placeStone(Stone stone){
        int[] move = stone.getMove();
        if (boardState[move[0]][move[1]] != 0) {
            return -1;
        } else if (stone.getColour() == 'b') {
            boardState[move[0]][move[1]] = 1;
        } else if (stone.getColour() == 'w') {
            boardState[move[0]][move[1]] = 2;
        }
        return 1;
    }

    @Override
    public String toString() {
        String out = "";
        for (int[] row: boardState) {
            for (int type: row) {
                out += " " + MOVE_CONVERSION.get(type);
            }
            out += "\n";
        }
        return out;
    }

    public int[][] getBoardState() {
        return this.boardState;
    }

    public void setBoardState(int[][] boardState) {
        this.boardState = boardState;
    }

    public int getBlackCaptures() {
        return this.blackCaptures;
    }

    public void setBlackCaptures(int blackCaptures) {
        this.blackCaptures = blackCaptures;
    }

    public int getWhiteCaptures() {
        return this.whiteCaptures;
    }

    public void setWhiteCaptures(int whiteCaptures) {
        this.whiteCaptures = whiteCaptures;
    }
}
