package alex.goapiconnector.ui;

import java.util.Scanner;

import alex.goapiconnector.logic.GameController;

public class TextInterface {
    
    private GameController control;
    private Scanner scan;

    public TextInterface(GameController control) {
        this.control = control;
        this.scan = new Scanner(System.in);
    }

    public int[] requestMove() {
        try {
            System.out.print("Enter move in the form x, y: ");
            String move = scan.nextLine();
            String[] coordinates = move.split(", ");

            int x = Integer.parseInt(coordinates[0]);
            int y = Integer.parseInt(coordinates[1]);

            if (control.isValidMove(x, y)) {
                return new int[] {x, y};
            }


        } catch (Exception e) {
            System.out.println("Please enter a move in the form: x, y");
        }

        return new int[0];
    }

}
