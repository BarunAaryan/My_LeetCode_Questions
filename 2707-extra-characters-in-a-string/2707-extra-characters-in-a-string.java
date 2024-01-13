class Solution {
    public int minExtraChar(String s, String[] dictionary) {
        int[] dp = new int[s.length()];
        Arrays.fill(dp, -1);
        
        Map<String, Integer> mp= new HashMap<>();
        for(String word :dictionary){
            mp.put(word, mp.getOrDefault(word, 0)+1);
        }
        return solve(s, mp, dp, 0);
    }
    private int solve(String s, Map<String, Integer> mp, int[] dp, int idx){
        if(idx>= s.length()) return 0;
        if(dp[idx]!= -1) return dp[idx];
        
        StringBuilder currStr = new StringBuilder();
        int ans= s.length();
        
        for(int cutIdx = idx; cutIdx < s.length(); cutIdx++){
            currStr.append(s.charAt(cutIdx));
            int count = (mp.containsKey(currStr.toString())? 0: currStr.length()) + solve(s,mp, dp, cutIdx+1);
            ans = Math.min(ans, count);
        }
        return dp[idx]= ans;
        
    }
}