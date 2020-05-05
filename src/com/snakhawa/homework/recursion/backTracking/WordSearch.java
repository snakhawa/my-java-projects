package com.snakhawa.homework.recursion.backTracking;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/word-search/
 */
public class WordSearch {

    public static void main(String[] args) {

        char[][] board = {{'A', 'B', 'C', 'E'}, {'S', 'F', 'C', 'S'}, {'A', 'D', 'E', 'E'}};
        String word = "ABCCED";
        exist(board, word);
    }

    public static boolean exist(char[][] board, String word) {
        int row = board.length;
        int col = board[0].length;
        State[][] visited = new State[board.length][board[0].length];
        for (State[] states : visited)
            Arrays.fill(states, State.UNVISITED);

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (board[i][j] == word.charAt(0)) {
                    if (pathExists(board, i, j, word, 0, visited)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }


    public static boolean pathExists(char[][] board, int row, int col, String word, int index, State[][] visited) {

        if (index == word.length()) return true;
        if (oob(board, row, col) || visited[row][col] == State.VISITING) return false;

        if (board[row][col] != word.charAt(index)) return false;

        visited[row][col] = State.VISITING;

        int[][] points = {{row + 1, col}, {row - 1, col}, {row, col + 1}, {row, col - 1}};

        for (int[] point : points) {
            if (pathExists(board, point[0], point[1], word, index + 1, visited)) return true;
        }

        visited[row][col] = State.UNVISITED;

        return false;
    }

    public static boolean oob(char[][] board, int row, int col) {
        return row >= board.length || row < 0 || col >= board[0].length || col < 0;
    }

    public enum State {
        UNVISITED,
        VISITING
    }
}
