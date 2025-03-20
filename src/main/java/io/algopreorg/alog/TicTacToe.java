package io.algopreorg.alog;

import java.util.Scanner;

public class TicTacToe {
  private static final char EMPTY = '-';
  private static final char PLAYER_X = 'X';
  private static final char PLAYER_O = 'O';
  private static char[][] board = new char[3][3];
  private static char currentPlayer = PLAYER_X;

  public static void main(String[] args) {
    initializeBoard();
    playGame();
  }

  private static void initializeBoard() {
    for (int i = 0; i < 3; i++) {
      for (int j = 0; j < 3; j++) {
        board[i][j] = EMPTY;
      }
    }
  }

  private static void playGame() {
    Scanner scanner = new Scanner(System.in);
    boolean gameWon = false;
    int moves = 0;

    while (!gameWon && moves < 9) {
      printBoard();
      System.out.println("Player " + currentPlayer + ", enter your move (row and column: 0 1 2): ");
      int row = scanner.nextInt();
      int col = scanner.nextInt();

      if (isValidMove(row, col)) {
        board[row][col] = currentPlayer;
        moves++;

        if (checkWin()) {
          gameWon = true;
          printBoard();
          System.out.println("Player " + currentPlayer + " wins!");
          return;
        }

        currentPlayer = (currentPlayer == PLAYER_X) ? PLAYER_O : PLAYER_X;
      } else {
        System.out.println("Invalid move. Try again.");
      }
    }

    printBoard();
    System.out.println("It's a draw!");
  }

  private static boolean isValidMove(int row, int col) {
    return row >= 0 && row < 3 && col >= 0 && col < 3 && board[row][col] == EMPTY;
  }

  private static boolean checkWin() {
    for (int i = 0; i < 3; i++) {
      if (board[i][0] == currentPlayer && board[i][1] == currentPlayer && board[i][2] == currentPlayer)
        return true;
      if (board[0][i] == currentPlayer && board[1][i] == currentPlayer && board[2][i] == currentPlayer)
        return true;
    }
    if (board[0][0] == currentPlayer && board[1][1] == currentPlayer && board[2][2] == currentPlayer)
      return true;
    if (board[0][2] == currentPlayer && board[1][1] == currentPlayer && board[2][0] == currentPlayer)
      return true;
    return false;
  }

  private static void printBoard() {
    for (char[] row : board) {
      for (char cell : row) {
        System.out.print(cell + " ");
      }
      System.out.println();
    }
    System.out.println();
  }
}

