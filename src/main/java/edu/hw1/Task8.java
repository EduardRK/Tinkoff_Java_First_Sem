package edu.hw1;

public final class Task8 {
    private static final int BOARD_SIZE = 8;

    private Task8() {
    }

    private static boolean isCorrectBoard(int[][] board) {
        if (board.length != BOARD_SIZE) {
            return false;
        }
        for (int[] i : board) {
            if (i.length != BOARD_SIZE) {
                return false;
            }
        }
        return true;
    }

    private static boolean isCorrectBoardValues(int[][] board) {
        for (int[] i : board) {
            for (int j : i) {
                if (j != 1 && j != 0) {
                    return false;
                }
            }
        }
        return true;
    }

    private static boolean isCorrectPosition(int x, int y) {
        return (x >= 0 && x < BOARD_SIZE) && (y >= 0 && y < BOARD_SIZE);
    }

    public static boolean knightBoardCapture(int[][] board) {
        if (!isCorrectBoard(board)) {
            return false;
        }

        if (!isCorrectBoardValues(board)) {
            return false;
        }

        for (int i = 0; i < BOARD_SIZE; ++i) {
            for (int j = 0; j < BOARD_SIZE; ++j) {
                if (board[i][j] != 1) {
                    continue;
                }
                if ((isCorrectPosition(i - 2, j + 1) && (board[i - 2][j + 1] == 1))
                    || (isCorrectPosition(i + 2, j + 1) && (board[i + 2][j + 1] == 1))
                    || (isCorrectPosition(i - 1, j + 2) && (board[i - 1][j + 2] == 1))
                    || (isCorrectPosition(i + 1, j + 2) && (board[i + 1][j + 2] == 1))) {
                    return false;
                }
            }
        }
        return true;
    }
}
