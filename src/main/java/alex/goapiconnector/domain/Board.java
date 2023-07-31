public class Board {
    private int[][] boardState;
    private int blackCaptures;
    private int whiteCaptures;

    public Board() {

    }

    public boolean sameBoardState(Board board) {
        return Arrays.equals(this.boardState, board.getBoardState());
    }

    public int placeStone(Stone stone){
        if (boardState[stone.getX()][stone.getY()] != 0) {
            return -1;
        } else if (stone.getColour() == 'b') {
            boardState[stone.getX()][stone.getY()] = 1;
        } else if (stone.getColour() == 'w') {
            boardState[stone.getX()][stone.getY()] = 2;
        }
        return 1;
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
