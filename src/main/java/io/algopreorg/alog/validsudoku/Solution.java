package io.algopreorg.alog.validsudoku;

import java.util.HashSet;

public class Solution {

    public static final char EMPTY = '.';

    public boolean isValidSudoku(char[][] board) {
        for (int i = 0; i < 9; i++) {
            var rowSet = new HashSet<Character>();
            var colSet = new HashSet<Character>();
            var subgridSet = new HashSet<Character>();
            for (int j = 0; j < 9; j++) {
                char row = board[i][j];
                char column = board[j][i];

                if (row != EMPTY && !rowSet.add(row) || column != EMPTY && !colSet.add(column)) {
                    return false;
                }

                // Check 3x3 sub-grids
                int rowIndex = 3 * (i / 3);
                int colIndex = 3 * (i % 3);

                if (board[rowIndex + j / 3][colIndex + j % 3] != EMPTY &&
                        !subgridSet.add(board[rowIndex + j / 3][colIndex + j % 3])) {
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Solution sudoku = new Solution();
        char[][] board = {
                {'5', '3', EMPTY, EMPTY, '7', EMPTY, EMPTY, EMPTY, EMPTY},
                {'6', EMPTY, EMPTY, '1', '9', '5', EMPTY, EMPTY, EMPTY},
                {EMPTY, '9', '8', EMPTY, EMPTY, EMPTY, EMPTY, '6', EMPTY},
                {'8', EMPTY, EMPTY, EMPTY, '6', EMPTY, EMPTY, EMPTY, '3'},
                {'4', EMPTY, EMPTY, '8', EMPTY, '3', EMPTY, EMPTY, '1'},
                {'7', EMPTY, EMPTY, EMPTY, '2', EMPTY, EMPTY, EMPTY, '6'},
                {EMPTY, '6', EMPTY, EMPTY, EMPTY, EMPTY, '2', '8', EMPTY},
                {EMPTY, EMPTY, EMPTY, '4', '1', '9', EMPTY, EMPTY, '5'},
                {EMPTY, EMPTY, EMPTY, EMPTY, '8', EMPTY, EMPTY, '7', '9'}
        };
        System.out.println(sudoku.isValidSudoku(board)); // Output: true
    }
}
