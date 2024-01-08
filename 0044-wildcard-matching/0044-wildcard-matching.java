class Solution {
    static boolean isAllStars(String p, int i) {
        for (int j = 1; j <= i; j++) {
            if (p.charAt(j - 1) != '*')
                return false;
        }
        return true;
    }

    public boolean isMatch(String s, String p) {
        int n = s.length();
        int m = p.length();
        // Create a 2D array to store the matching results
        boolean dp[][] = new boolean[n + 1][m + 1];
        dp[0][0] = true;

        // Initialize the first row based on the wildcard pattern
        for (int j = 1; j <= m; j++) {
            if (p.charAt(j - 1) == '*') {
                dp[0][j] = dp[0][j - 1];
            }
        }

        // Fill in the dp array using bottom-up approach
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (s.charAt(i - 1) == p.charAt(j - 1) || p.charAt(j - 1) == '?') {
                    dp[i][j] = dp[i - 1][j - 1];
                } else if (p.charAt(j - 1) == '*') {
                    dp[i][j] = dp[i - 1][j] || dp[i][j - 1];
                }
            }
        }
        return dp[n][m];
    }
}
