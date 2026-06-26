import java.util.*;

public class Solution {
    /**
     * Generates all combinations of well-formed parentheses for a given number of pairs.
     * 
     * @param n The number of pairs of parentheses.
     * @return A list of all combinations of well-formed parentheses.
     */
    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        backtrack(result, new StringBuilder(), 0, 0, n);
        return result;
    }

    /**
     * Recursive helper function to generate all combinations of well-formed parentheses.
     * 
     * @param result The list to store the generated combinations.
     * @param sb      The current combination being built.
     * @param open    The number of open parentheses in the current combination.
     * @param close   The number of close parentheses in the current combination.
     * @param n       The number of pairs of parentheses.
     */
    private void backtrack(List<String> result, StringBuilder sb, int open, int close, int n) {
        // Base case: if the length of the current combination is equal to 2n, add it to the result list
        if (sb.length() == 2 * n) {
            result.add(sb.toString());
            return;
        }

        // If the number of open parentheses is less than n, add an open parenthesis to the current combination
        if (open < n) {
            sb.append("(");
            backtrack(result, sb, open + 1, close, n);
            sb.deleteCharAt(sb.length() - 1); // backtrack by removing the last character
        }

        // If the number of close parentheses is less than the number of open parentheses, add a close parenthesis to the current combination
        if (close < open) {
            sb.append(")");
            backtrack(result, sb, open, close + 1, n);
            sb.deleteCharAt(sb.length() - 1); // backtrack by removing the last character
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.generateParenthesis(3));
        System.out.println(solution.generateParenthesis(1));
    }
}