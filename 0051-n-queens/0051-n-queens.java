class Solution {

    List<List<String>> result = new ArrayList<>();

    public List<List<String>> solveNQueens(int n) {

        char[][] board = new char[n][n];

        // Fill board with '.'
        for (int i = 0; i < n; i++) {
            Arrays.fill(board[i], '.');
        }

        solve(board, 0, n);

        return result;
    }

    void solve(char[][] board, int col, int n) {

        if (col == n) {
            List<String> temp = new ArrayList<>();

            for (int i = 0; i < n; i++) {
                temp.add(new String(board[i]));
            }

            result.add(temp);
            return;
        }

        for (int row = 0; row < n; row++) {

            if (isSafe(board, row, col, n)) {

                board[row][col] = 'Q';

                solve(board, col + 1, n);

                // Backtrack
                board[row][col] = '.';
            }
        }
    }

    boolean isSafe(char[][] board, int row, int col, int n) {

        // Check left side
        for (int i = 0; i < col; i++)
            if (board[row][i] == 'Q')
                return false;

        // Check upper-left diagonal
        for (int i = row, j = col; i >= 0 && j >= 0; i--, j--)
            if (board[i][j] == 'Q')
                return false;

        // Check lower-left diagonal
        for (int i = row, j = col; i < n && j >= 0; i++, j--)
            if (board[i][j] == 'Q')
                return false;

        return true;
    }
}