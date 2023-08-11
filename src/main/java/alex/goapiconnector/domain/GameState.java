package alex.goapiconnector.domain;

import org.springframework.web.socket.WebSocketSession;
import com.fasterxml.jackson.databind.ObjectMapper;

public class GameState {
    private int[][] board;
    private int blackCaptures;
    private int whiteCaptures;
    private int turnNumber;
    private boolean blackTurn;

    public GameState() {
        board = new int[19][19];
        blackCaptures = 0;
        whiteCaptures = 0;
        turnNumber = 0;
        blackTurn = true;
    }

    public void playMove(String player, int x, int y) {
        board[x][y] = (player.equals("black") ? 1 : 2);
        blackTurn = !blackTurn;
        incrementTurn();
    }

    public String toJson() {
        ObjectMapper mapper = new ObjectMapper();
        try {
            return mapper.writeValueAsString(this);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    private int incrementTurn() {
        return ++turnNumber;
    }

    public int[][] getBoard() {
        return this.board;
    }

    public int getBlackCaptures() {
        return this.blackCaptures;
    }

    public int getWhiteCaptures() {
        return this.whiteCaptures;
    }

    public int getTurnNumber() {
        return this.turnNumber;
    }

    public boolean getBlackTurn() {
        return this.blackTurn;
    }

}
