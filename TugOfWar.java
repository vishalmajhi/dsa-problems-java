import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TugOfWar {

    public static void main(String[] args) {
        int[] weights = { 1, 2, 3, 4, 5, 6 };
        List<Integer> result = findTugOfWar(weights);

        System.out.println("Set 1: " + result);
        System.out.println("Set 2: " + getComplementSet(weights, result));
    }

    public static List<Integer> findTugOfWar(int[] weights) {
        int n = weights.length;

        // Calculate the total sum of all weights
        int totalSum = 0;
        for (int weight : weights) {
            totalSum += weight;
        }

        // Create a 2D boolean array dp[i][j] where dp[i][j] is true if sum 'j' can be
        // achieved using the first 'i' weights.
        boolean[][] dp = new boolean[n + 1][totalSum + 1];

        // Initialize the dp array
        for (int i = 0; i <= n; i++) {
            dp[i][0] = true;
        }

        // Fill the dp array
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= totalSum; j++) {
                dp[i][j] = dp[i - 1][j];
                if (weights[i - 1] <= j) {
                    dp[i][j] |= dp[i - 1][j - weights[i - 1]];
                }
            }
        }

        // Find the maximum sum that can be achieved in the first half
        int halfSum = totalSum / 2;
        while (!dp[n][halfSum]) {
            halfSum--;
        }

        // Reconstruct the two sets of weights
        List<Integer> set1 = new ArrayList<>();
        int i = n;
        int j = halfSum;
        while (i > 0 && j > 0) {
            if (dp[i - 1][j]) {
                i--;
            } else {
                set1.add(weights[i - 1]);
                j -= weights[i - 1];
                i--;
            }
        }

        return set1;
    }

    public static List<Integer> getComplementSet(int[] weights, List<Integer> set1) {
        List<Integer> set2 = new ArrayList<>();
        for (int weight : weights) {
            if (!set1.contains(weight)) {
                set2.add(weight);
            }
        }
        return set2;
    }
}
