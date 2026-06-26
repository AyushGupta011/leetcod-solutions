/**
 * Traps rain water in an elevation map.
 */
public class Solution {
    /**
     * Calculates the total water trapped in the elevation map.
     * 
     * @param height the elevation map
     * @return the total water trapped
     */
    public int trap(int[] height) {
        // Handle edge cases
        if (height == null || height.length == 0) {
            return 0;
        }

        int n = height.length;
        // Initialize arrays to store left and right maximum heights
        int[] leftMax = new int[n];
        int[] rightMax = new int[n];

        // Calculate left maximum heights
        leftMax[0] = height[0];
        for (int i = 1; i < n; i++) {
            leftMax[i] = Math.max(leftMax[i - 1], height[i]);
        }

        // Calculate right maximum heights
        rightMax[n - 1] = height[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            rightMax[i] = Math.max(rightMax[i + 1], height[i]);
        }

        // Calculate total water trapped
        int totalWater = 0;
        for (int i = 0; i < n; i++) {
            totalWater += Math.min(leftMax[i], rightMax[i]) - height[i];
        }

        return totalWater;
    }

    /**
     * Optimized solution using two pointers.
     * 
     * @param height the elevation map
     * @return the total water trapped
     */
    public int trapOptimized(int[] height) {
        // Handle edge cases
        if (height == null || height.length == 0) {
            return 0;
        }

        int n = height.length;
        int left = 0;
        int right = n - 1;
        int leftMax = height[0];
        int rightMax = height[n - 1];
        int totalWater = 0;

        // Traverse the elevation map from both ends
        while (left <= right) {
            // Update left maximum height
            if (height[left] < leftMax) {
                totalWater += leftMax - height[left];
            } else {
                leftMax = height[left];
            }

            // Update right maximum height
            if (height[right] < rightMax) {
                totalWater += rightMax - height[right];
            } else {
                rightMax = height[right];
            }

            // Move the pointer with the smaller height
            if (leftMax < rightMax) {
                left++;
            } else {
                right--;
            }
        }

        return totalWater;
    }
}