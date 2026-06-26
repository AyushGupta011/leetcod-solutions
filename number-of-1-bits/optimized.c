/**
 * Returns the number of set bits in the binary representation of a given positive integer.
 *
 * @param n A positive integer.
 * @return The number of set bits in the binary representation of n.
 */
int hammingWeight(int n) {
    int count = 0;
    // Continue until all bits are processed
    while (n) {
        // Clear the least significant set bit
        n &= (n - 1);
        // Increment the count of set bits
        count++;
    }
    return count;
}