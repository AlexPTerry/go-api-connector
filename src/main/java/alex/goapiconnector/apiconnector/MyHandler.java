package alex.goapiconnector.apiconnector;

import java.io.IOException;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

import alex.goapiconnector.domain.GameState;

public class MyHandler extends TextWebSocketHandler {

    private final Set<WebSocketSession> sessions = ConcurrentHashMap.newKeySet();
    private final Queue<WebSocketSession> playerQueue = new LinkedList<>();

    private final Map<String, String> sessionToGameId = new HashMap<>();
    private final Map<String, GameState> gameIdToGameState = new HashMap<>();

    @Override
    public void afterConnectionEstablished(WebSocketSession session) {
        sessions.add(session);
        playerQueue.offer(session);
        if (playerQueue.size() > 1) {
            WebSocketSession player1 = playerQueue.remove();
            WebSocketSession player2 = playerQueue.remove();
            startGame(player1, player2);
        }
    }

    private void startGame(WebSocketSession p1, WebSocketSession p2) {
        String p1Id = p1.getId();
        String p2Id = p2.getId();

        String gameId = setGameId(p1Id, p2Id);
        GameState newGame = new GameState(p1, p2);
        gameIdToGameState.put(gameId, newGame);

    }

    private String setGameId(String p1Id, String p2Id) {
        String gameId;
        if (p1Id.compareTo(p2Id) < 0) {
            gameId = p1Id + p2Id;
        } else {
            gameId = p2Id + p1Id;
        }

        sessionToGameId.put(p1Id, gameId);
        sessionToGameId.put(p2Id, gameId);

        return gameId;
    }

    @Override
    public void afterConnectionClosed(WebSocketSession session, CloseStatus status) {
        sessions.remove(session);
    }

    public void broadcast(String message) {
        for (WebSocketSession session : sessions) {
            if (session.isOpen()) {
                try {
                    session.sendMessage(new TextMessage(message));
                } catch (IOException e) {
                    System.out.println("Message failed to send");
                }
            }
        }
    }

    @Override
    public void handleTextMessage(WebSocketSession session, TextMessage message) {
        // Extract data from the received message
        String payload = message.getPayload();
        // Do something with the message, like updating the game state

        String gameId = sessionToGameId.get(session.getId());
        GameState gameState = gameIdToGameState.get(gameId);

        // Send a response
        try {
            session.sendMessage(new TextMessage(gameState.incrementTurn() + ""));
            session.sendMessage(new TextMessage("In game: " + session.getId() + ", your move: " + payload + " was received!"));
        } catch (IOException e) {
            System.out.println("Message failed to send");
        }
    }
}
