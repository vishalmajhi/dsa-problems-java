
// backtraking

public class Rat_trap_maze {
    private static int N; // Size of the maze
    private static int[][] maze; // The maze itself

    // Function to solve the maze using backtracking
    private static boolean solveMaze() {
        int[][] sol = new int[N][N];

        if (!solveMazeUtil(0, 0, sol)) {
            return false;
        }

        return true;
    }

    // Utility function to solve the maze recursively
    private static boolean solveMazeUtil(int x, int y, int[][] sol) {
        // If the rat reaches the destination
        if (x == N - 1 && y == N - 1) {
            sol[x][y] = 1;
            return true;
        }

        // Check if x, y is a valid cell
        if (isValid(x, y)) {
            // Mark the cell as part of the solution
            sol[x][y] = 1;

            // Move right
            if (solveMazeUtil(x + 1, y, sol)) {
                return true;
            }

            // Move down
            if (solveMazeUtil(x, y + 1, sol)) {
                return true;
            }

            // If neither right nor down leads to a solution, backtrack
            sol[x][y] = 0;
            return false;
        }

        return false;
    }

    // Utility function to check if x, y is a valid cell
    private static boolean isValid(int x, int y) {
        return (x >= 0 && x < N && y >= 0 && y < N && maze[x][y] == 1);
    }

    // Utility function to print the solution
    private static void printSolution() {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                System.out.print(" " + maze[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        N = 4; // Size of the maze (N x N)
        maze = new int[][] {
                { 1, 0, 0, 0 },
                { 1, 1, 0, 1 },
                { 0, 1, 0, 0 },
                { 1, 1, 0, 1 }
        };

        if (solveMaze()) {
            System.out.println("Solution exists.");
            printSolution();
        } else {
            System.out.println("Solution does not exist.");
        }
    }
}
