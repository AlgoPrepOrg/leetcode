package io.algopreorg.alog.isvalidsudoku;

import java.util.HashSet;
import java.util.Set;

public class Solution2 {
    public boolean isValidSudoku(char[][] board) {
        for (int i = 0; i < board.length; i++) {
            Set<Character> setRow = new HashSet<>();
            Set<Character> setColumn = new HashSet<>();
            for (int j = 0; j < board[i].length; j++) {
                if (!setRow.add(board[i][j])) {
                    return false;
                }
                if (!setColumn.add(board[j][i])) {
                    return false;
                }
            }
        }
        return true;
    }
}
