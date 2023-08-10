package alex.goapiconnector.domain;

import org.springframework.web.socket.WebSocketSession;

public class GameState {
    private String board;
    private int blackCaptures;
    private int whiteCaptures;
    private int turnNumber;
    private WebSocketSession player1;
    private WebSocketSession player2;

    public GameState(WebSocketSession player1, WebSocketSession player2) {
        this.player1 = player1;
        this.player2 = player2;
        board = "";
        blackCaptures = 0;
        whiteCaptures = 0;
        turnNumber = 0;
    }

    public int incrementTurn() {
        return ++turnNumber;
    }
}
