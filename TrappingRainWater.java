public class TrappingRainWater {

    public int brute(int[] height) {
        int n = height.length;
        int totalWater = 0;

        for (int i = 0; i < n; i++) {
            int leftMax = 0, rightMax = 0;

            // Find the maximum height to the left of the current bar.
            for (int j = i; j >= 0; j--) {
                leftMax = Math.max(leftMax, height[j]);
            }

            // Find the maximum height to the right of the current bar.
            for (int j = i; j < n; j++) {
                rightMax = Math.max(rightMax, height[j]);
            }

            // Calculate the trapped water at the current position.
            totalWater += Math.min(leftMax, rightMax) - height[i];
        }

        return totalWater;
    }

    public int best(int[] height) {
        int n = height.length;
        if (n <= 2) {
            return 0; // No water can be trapped with less than 3 elevations.
        }

        int leftMax = 0;
        int rightMax = 0;
        int left = 0;
        int right = n - 1;
        int trappedWater = 0;

        while (left < right) {
            if (height[left] < height[right]) {
                if (height[left] > leftMax) {
                    leftMax = height[left];
                } else {
                    trappedWater += leftMax - height[left];
                }
                left++;
            } else {
                if (height[right] > rightMax) {
                    rightMax = height[right];
                } else {
                    trappedWater += rightMax - height[right];
                }
                right--;
            }
        }

        return trappedWater;

    }

    public static void main(String[] args) {
        TrappingRainWater solution = new TrappingRainWater();
        int[] height = { 0, 1, 6, 2, 1, 0, 1, 3, 2, 1, 2, 1 };
        int trappedWater = solution.best(height);
        System.out.println("Total trapped water: " + trappedWater);
    }
}
