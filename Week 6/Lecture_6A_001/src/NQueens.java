public class NQueens {

  public static void main(String[] args) {
    int n = 6;
    int[][] board = new int[n][n];
    System.out.println(solveNQueens(board,0));
  }


  public static boolean solveNQueens(int[][] board, int col) {
    if (col == board.length) {
      return true; // All queens placed
    }
    for (int row = 0; row < board.length; row++) {
      if (isSafe(board, row, col)) {
        board[row][col] = 1; // Place queen
        if (solveNQueens(board, col + 1)) { // Recursion to place next queen
          return true;
        }
        board[row][col] = 0; // Backtrack (remove queen)
      }
    }
    return false; // No place for queen in this column
  }


  public static boolean isSafe(int[][] board, int row, int col) {
    // Check this row on the left side
    for (int i = 0; i < col; i++) if (board[row][i] == 1) {
      return false;
    }
    // Check upper diagonal
    for (int i = row, j = col; i >= 0 && j >= 0; i--, j--) {
      if (board[i][j] == 1) {
        return false;
      }
    }
    // Check lower diagonal
    for (int i = row, j = col; i < board.length && j >= 0; i++, j--) {
      if (board[i][j] == 1) {
        return false;
      }
    }
    return true;
  }

}
