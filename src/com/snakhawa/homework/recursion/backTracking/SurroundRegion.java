package com.snakhawa.homework.recursion.backTracking;

/**
 * https://leetcode.com/problems/surrounded-regions/
 */
public class SurroundRegion {

    public static void solve(char[][] board) {
        if (board.length < 2)
            return;
        boolean[][] visited = new boolean[board.length][board[0].length];

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (isBorder(board, i, j))
                    find(board, i, j, true, visited);
            }
        }

        for (int i = 1; i < board.length - 1; i++) {
            for (int j = 1; j < board[0].length - 1; j++) {
                find(board, i, j, false, visited);
            }
        }
    }

    private static void find(char[][] board, int i, int j, boolean isBorder, boolean[][] visited) {
        if (isOOB(board, i, j) || visited[i][j])
            return;
        visited[i][j] = true;
        if (board[i][j] == 'O') {
            if (!isBorder)
                board[i][j] = 'X';
            find(board, i + 1, j, isBorder, visited);
            find(board, i - 1, j, isBorder, visited);
            find(board, i, j + 1, isBorder, visited);
            find(board, i, j - 1, isBorder, visited);
        }
    }

    private static boolean isOOB(char[][] board, int i, int j) {
        return i < 0 || j < 0 || i >= board.length || j >= board[0].length;
    }

    private static boolean isBorder(char[][] board, int i, int j) {
        return i == 0 || j == 0 || i == board.length - 1 || j == board[0].length - 1;
    }
}
