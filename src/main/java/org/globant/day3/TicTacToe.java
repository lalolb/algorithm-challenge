package org.globant.day3;

public class TicTacToe {
    private char[][] board;
    private char currentPlayerMark = 'X';
    private static final int BOARD_SIZE = 3;
    private static final char EMPTY_SPACE = '-';
    private static final char PLAYER_X_MARK = 'X';
    private static final char PLAYER_O_MARK = 'O';


    public TicTacToe() {
        board = new char[BOARD_SIZE][BOARD_SIZE];
        for (int i = 0; i < BOARD_SIZE; i++) {
            for (int j = 0; j < BOARD_SIZE; j++) {
                board[i][j] = EMPTY_SPACE;
            }
        }
    }

    public String play(int[][] moves) {
        String outcome = null;
        // Make a move
        for (int[] move: moves) {
            makeMove(move);
            if(evaluateBoard()) {
                outcome = currentPlayerMark == 'X'?"A":"B";
                break;
            }
            switchTurn();
        }

        if(outcome == null)
            outcome = moves.length < 9 ? "Pending":"Draw";

        printBoard();
        System.out.println("Outcome: " + outcome);
        return outcome;
    }

    private void makeMove(int[] move) {
        int row = move[0];
        int column = move[1];
        this.board[row][column] = currentPlayerMark;
    }

    private void switchTurn() {
        currentPlayerMark = currentPlayerMark == PLAYER_X_MARK ? PLAYER_O_MARK : PLAYER_X_MARK;
    }

    private boolean evaluateBoard() {
        return validateRows() || validateColumns() || validateDiagonals();
    }

    private boolean validateRows() {
        for (int i = 0; i < BOARD_SIZE; i++) {
            if (checkSpacesForAWin(board[i][0], board[i][1], board[i][2])) {
                return true;
            }
        }
        return false;
    }

    private boolean validateColumns() {
        for (int i = 0; i < BOARD_SIZE; i++) {
            if (checkSpacesForAWin(board[0][i], board[1][i], board[2][i])) {
                return true;
            }
        }
        return false;
    }

    private boolean validateDiagonals() {
        return checkSpacesForAWin(board[0][0], board[1][1], board[2][2]) || checkSpacesForAWin(board[0][2], board[1][1], board[2][0]);
    }

    private boolean checkSpacesForAWin(char c1, char c2, char c3) {
        return (c1 != EMPTY_SPACE) && (c1 == c2) && (c2 == c3);
    }

    private void printBoard() {
        for (int i = 0; i < BOARD_SIZE; i++) {
            for (int j = 0; j < BOARD_SIZE; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println("-----");
    }
}
