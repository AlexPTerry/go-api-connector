package alex.goapiconnector.logic;

import alex.goapiconnector.ui.TextInterface;

public class GameRunner {

    private GameController gameController;
    private TextInterface textInterface;

    public GameRunner(int boardSize) {
        gameController = new GameController(boardSize);
        textInterface = new TextInterface(gameController);
    }

    public void start() {
        while(!gameController.isGameOver()) {
            textInterface.displayBoard();
            int[] move = textInterface.requestMove();
            gameController.makeMove(move);
        }

        textInterface.displayGameResult();
    }
}
