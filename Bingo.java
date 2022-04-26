package bingo;

import java.util.Scanner;

public class Bingo {
    int[][] board;
    int[][] card;

    Bingo() {
        board = new int[5][5];
        for (int i = 0; i < 5; i++) {

            for (int j = 0; j <= 4; j++) {
                int temp = (int) (Math.random() * 100);
                while (isNumberOnCard(temp)) {
                    temp = (int) (Math.random() * 100);
                }
                board[i][j] = temp;

            }
        }

    }

    public void makeBoard() {
        System.out.println("\tBINGO BOARD");

        for (int i = 0; i < 5; i++) {
            for (int j = 0; j <= 4; j++) {
                if (board[i][j] == 0) {
                    System.out.print("X  | ");
                } else {
                    System.out.printf("%2d" + " | ", board[i][j]);
                }
            }
            System.out.println(" ");
        }

    }

    private boolean isNumberOnCard(int num) {
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                if (board[i][j] == num) {
                    return true;
                }
            }
        }
        return false;

    }

    private void randomCard() {
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j <= 4; j++) {
                card[i][j] = (int) (Math.random() * 100);
            }
        }


    }

    private void putX(int num) {
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                if (board[i][j] == num) {
                    board[i][j] = 0;
                }

            }
        }

    }

    public void checkInput(Scanner input) {

        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                while (!isGameOver()) {
                    System.out.println("Enter the number to cross out");
                    int user = input.nextInt();
                    while (!isNumberOnCard(user)) {
                        System.out.println("Number not FOund");
                        System.out.println("Enter the number to Cross out");
                        user = input.nextInt();

                    }
                    putX(user);
                    makeBoard();
                }
            }
        }
        System.out.println("YOU WON \nBINGO!!!");
    }

    private boolean checkCols() {
        for (int i = 0; i < 5; i++) {
            if (board[0][i] + board[1][i] + board[2][i] + board[3][i] + board[4][i] == 0) {
                return true;
            }
        }
        return false;
    }

    private boolean checkRows() {
        for (int i = 0; i < 5; i++) {
            if (board[i][0] + board[i][1] + board[i][2] + board[i][3] + board[i][4] == 0) {
                return true;
            }

        }
        return false;
    }

    private boolean checkDiag() {
        return (board[0][0] + board[1][1] + board[2][2] + board[3][3] + board[4][4] == 0 ||
                board[0][4] + board[1][3] + board[2][2] + board[3][1] + board[4][0] == 0) ;


    }

    private boolean isGameOver() {
        return (checkCols() || checkRows() || checkDiag());
    }

}
