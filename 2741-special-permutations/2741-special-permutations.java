public class Solution {

    private static final int MOD = 1000000007;

    int findPermutations(int prevIndex, int mask, Integer[][] dp, List<Integer> nums, int count) {
        // base condition
        if (count == nums.size())
            return 1;

        // already computed
        if (dp[prevIndex][mask] != null)
            return dp[prevIndex][mask];

        int ways = 0;
        for (int i = 0; i < nums.size(); i++) {
            // already visited
            if ((mask & (1 << i)) != 0) continue;

            // at least one element selected previously
            if (mask != 0 &&
                    nums.get(i) % nums.get(prevIndex) != 0 &&
                    nums.get(prevIndex) % nums.get(i) != 0)
                continue;

            // take element and update ways
            ways = (int) ((ways + findPermutations(i, mask | (1 << i), dp, nums, count + 1)) % MOD);
        }

        // memoize result
        dp[prevIndex][mask] = ways;
        return ways;
    }

    public int specialPerm(int[] nums) {
        int n = nums.length;
        // Convert int array to List<Integer>
        List<Integer> numsList = Arrays.asList(Arrays.stream(nums).boxed().toArray(Integer[]::new));

        // size of dp required : (n, 2^n)
        Integer[][] dp = new Integer[n][1 << n];
        int mask = 0;           // initially no element selected
        int prevIndex = 0;      // last taken element index
        int count = 0;          // store no of taken elements
        return findPermutations(prevIndex, mask, dp, numsList, count);
    }
}

