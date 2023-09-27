public class TrappingRainWater {

    public int trap(int[] height) {
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

    public static void main(String[] args) {
        TrappingRainWater solution = new TrappingRainWater();
        int[] height = { 0, 1, 6, 2, 1, 0, 1, 3, 2, 1, 2, 1 };
        int trappedWater = solution.trap(height);
        System.out.println("Total trapped water: " + trappedWater);
    }
}
