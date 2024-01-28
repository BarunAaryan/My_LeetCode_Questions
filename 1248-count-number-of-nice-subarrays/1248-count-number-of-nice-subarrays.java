class Solution {
    public int numberOfSubarrays(int[] nums, int k) {
         int ans = 0;
        int n = nums.length;
        int[] map = new int[n+1];
        map[0] = 1;
        int sum = 0;
        for(int i = 0; i < n; i++) {
            sum += nums[i]%2;
            if(sum >= k)    ans += map[sum-k];
            map[sum]++;
        }
        return ans;
    }
}