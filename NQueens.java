public class NQueens {
    private int[][] board;
    private int N;

    public NQueens(int N) {
        this.N = N;
        board = new int[N][N];
    }

    public void solve() {
        if (solveNQueensUtil(0)) {
            printSolution();
        } else {
            System.out.println("Solution does not exist.");
        }
    }

    private boolean solveNQueensUtil(int col) {
        if (col >= N) {
            return true; // All queens are placed successfully.
        }

        for (int i = 0; i < N; i++) {
            if (isSafe(i, col)) {
                board[i][col] = 1; // Place the queen

                if (solveNQueensUtil(col + 1)) {
                    return true;
                }

                // If placing the queen in board[i][col] doesn't lead to a solution, backtrack.
                board[i][col] = 0;
            }
        }

        return false; // If no safe position found in this column, return false.
    }

    private boolean isSafe(int row, int col) {
        // Check the left side of the current row
        for (int i = 0; i < col; i++) {
            if (board[row][i] == 1) {
                return false;
            }
        }

        // Check upper diagonal on the left side
        for (int i = row, j = col; i >= 0 && j >= 0; i--, j--) {
            if (board[i][j] == 1) {
                return false;
            }
        }

        // Check lower diagonal on the left side
        for (int i = row, j = col; i < N && j >= 0; i++, j--) {
            if (board[i][j] == 1) {
                return false;
            }
        }

        return true;
    }

    private void printSolution() {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        int N = 8; // Change N to the desired board size
        NQueens nQueens = new NQueens(N);
        nQueens.solve();
    }
}
