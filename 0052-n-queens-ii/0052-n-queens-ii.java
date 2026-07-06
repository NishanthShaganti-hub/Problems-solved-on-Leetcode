class Solution {

    int count = 0;

    public int totalNQueens(int n) {
        int[][] board = new int[n][n];
        solve(board, 0, n);
        return count;
    }

    boolean isSafe(int[][] board, int row, int col, int n) {

        // Check left side of row
        for (int i = 0; i < col; i++)
            if (board[row][i] == 1)
                return false;

        // Check upper-left diagonal
        for (int i = row, j = col; i >= 0 && j >= 0; i--, j--)
            if (board[i][j] == 1)
                return false;

        // Check lower-left diagonal
        for (int i = row, j = col; i < n && j >= 0; i++, j--)
            if (board[i][j] == 1)
                return false;

        return true;
    }

    void solve(int[][] board, int col, int n) {

        if (col == n) {
            count++;
            return;
        }

        for (int row = 0; row < n; row++) {
            if (isSafe(board, row, col, n)) {

                board[row][col] = 1;

                solve(board, col + 1, n);

                // Backtrack
                board[row][col] = 0;
            }
        }
    }
}