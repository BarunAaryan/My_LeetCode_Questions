class Solution {
    private int[] dp;
    public boolean Solution(String s, List<String> wordDict) {
        int n = s.length();
        dp = new int[n];
        Arrays.fill(dp, -1);

        if (wordBreak(s, wordDict)) {
return true;
        } else {
return false;
        }
    }

    public boolean wordBreak(String s, List<String> wordDict) {
        int n = s.length();
        dp = new int[n];
        Arrays.fill(dp, -1);
        return help(0, s, wordDict);
    }
        private boolean help(int i, String s, List<String> wordDict) {
        if (i == s.length()) return true;
        if (dp[i] != -1) return dp[i] == 1;

        for (int j = i; j < s.length(); j++) {
            String temp = s.substring(i, j + 1);
            if (wordDict.contains(temp) && help(j + 1, s, wordDict)) {
                dp[i] = 1;
                return true;
            }
        }

        dp[i] = 0;
        return false;
    }
}