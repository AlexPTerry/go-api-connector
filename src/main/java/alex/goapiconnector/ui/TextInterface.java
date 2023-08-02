package alex.goapiconnector.ui;

import java.util.Scanner;

import alex.goapiconnector.logic.GameController;

public class TextInterface {
    
    private GameController gameController;
    private Scanner scan;

    public TextInterface(GameController gameController) {
        this.gameController = gameController;
        scan = new Scanner(System.in);
    }

    public void displayBoard() {
        System.out.println(gameController.getBoard());
    }

    public void displayGameResult() {
        // Compute result!
        System.out.println("Result: N/A!!!");
        System.out.println(gameController.getBoard());
    }

    public int[] requestMove() {
        while (true) {
            try {
                System.out.print("Enter move in the form x, y: ");
                String move = scan.nextLine();

                if (move.equals("pass")) {
                    return new int[0];
                }

                String[] coordinates = move.split(", ");

                if (coordinates.length != 2) {
                    System.out.println("Please enter exactly two coordinates");
                    continue;
                }

                int x = Integer.parseInt(coordinates[0]);
                int y = Integer.parseInt(coordinates[1]);

                if (gameController.isValidMove(x, y)) {
                    return new int[] {x-1, y-1};
                } else {
                    System.out.println("Coordinates must be between " 
                                        + gameController.getMIN_COORDINATE() 
                                        + " and " 
                                        + gameController.getMAX_COORDINATE());
                    continue;
                }

            } catch (Exception e) {
                System.out.println("Please enter a move in the form: x, y");
            }
        }
    }

}
