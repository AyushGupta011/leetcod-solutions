#include <stdio.h>
#include <stdlib.h>
#include <string.h>

// Function to find the length of the shortest common supersequence
int shortestCommonSupersequenceLength(char* str1, char* str2, int m, int n) {
    // Create a DP table to store lengths of shortest common supersequences
    int** dp = (int**)malloc((m + 1) * sizeof(int*));
    for (int i = 0; i <= m; i++) {
        dp[i] = (int*)malloc((n + 1) * sizeof(int));
    }

    // Initialize the DP table
    for (int i = 0; i <= m; i++) {
        dp[i][0] = i;
    }
    for (int j = 0; j <= n; j++) {
        dp[0][j] = j;
    }

    // Fill in the DP table
    for (int i = 1; i <= m; i++) {
        for (int j = 1; j <= n; j++) {
            if (str1[i - 1] == str2[j - 1]) {
                dp[i][j] = 1 + dp[i - 1][j - 1];
            } else {
                dp[i][j] = 1 + (dp[i - 1][j] < dp[i][j - 1] ? dp[i - 1][j] : dp[i][j - 1]);
            }
        }
    }

    // Return the length of the shortest common supersequence
    return dp[m][n];
}

// Function to construct the shortest common supersequence string
void shortestCommonSupersequence(char* str1, char* str2, int m, int n) {
    // Create a DP table to store lengths of shortest common supersequences
    int** dp = (int**)malloc((m + 1) * sizeof(int*));
    for (int i = 0; i <= m; i++) {
        dp[i] = (int*)malloc((n + 1) * sizeof(int));
    }

    // Initialize the DP table
    for (int i = 0; i <= m; i++) {
        dp[i][0] = i;
    }
    for (int j = 0; j <= n; j++) {
        dp[0][j] = j;
    }

    // Fill in the DP table
    for (int i = 1; i <= m; i++) {
        for (int j = 1; j <= n; j++) {
            if (str1[i - 1] == str2[j - 1]) {
                dp[i][j] = 1 + dp[i - 1][j - 1];
            } else {
                dp[i][j] = 1 + (dp[i - 1][j] < dp[i][j - 1] ? dp[i - 1][j] : dp[i][j - 1]);
            }
        }
    }

    // Construct the shortest common supersequence string
    int i = m, j = n;
    char* result = (char*)malloc((dp[m][n] + 1) * sizeof(char));
    int k = dp[m][n] - 1;
    while (i > 0 && j > 0) {
        if (str1[i - 1] == str2[j - 1]) {
            result[k--] = str1[i - 1];
            i--;
            j--;
        } else if (dp[i - 1][j] < dp[i][j - 1]) {
            result[k--] = str1[i - 1];
            i--;
        } else {
            result[k--] = str2[j - 1];
            j--;
        }
    }
    while (i > 0) {
        result[k--] = str1[i - 1];
        i--;
    }
    while (j > 0) {
        result[k--] = str2[j - 1];
        j--;
    }
    result[dp[m][n]] = '\0';

    // Print the shortest common supersequence string
    printf("%s\n", result);

    // Free memory
    free(result);
    for (int i = 0; i <= m; i++) {
        free(dp[i]);
    }
    free(dp);
}

int main() {
    char str1[] = "abac";
    char str2[] = "cab";
    int m = strlen(str1);
    int n = strlen(str2);
    shortestCommonSupersequence(str1, str2, m, n);
    return 0;
}