package bingo;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Bingo game = new Bingo();

        game.makeBoard();
        game.checkInput(input);

    }
}









