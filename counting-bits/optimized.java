public class Solution {
    /**
     * Returns an array of length n + 1 where each index i represents the number of 1's in the binary representation of i.
     * 
     * @param n The input integer.
     * @return An array of length n + 1 with the number of 1's in the binary representation of each index.
     */
    public int[] countBits(int n) {
        // Initialize the result array with a size of n + 1.
        int[] result = new int[n + 1];
        
        // Base case: The number of 1's in the binary representation of 0 is 0.
        result[0] = 0;
        
        // Iterate over the range from 1 to n (inclusive).
        for (int i = 1; i <= n; i++) {
            // Calculate the number of 1's in the binary representation of i using the formula:
            // result[i] = result[i >> 1] + (i & 1)
            // This formula works because the number of 1's in the binary representation of i is equal to the number of 1's in the binary representation of i >> 1 (right shift by 1) plus the least significant bit of i (i & 1).
            result[i] = result[i >> 1] + (i & 1);
        }
        
        // Return the result array.
        return result;
    }
}