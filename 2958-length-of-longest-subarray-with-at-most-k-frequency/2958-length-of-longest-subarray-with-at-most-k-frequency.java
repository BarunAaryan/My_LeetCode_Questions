class Solution {
    public int maxSubarrayLength(int[] nums, int k) {
         int n = nums.length;
        Map<Integer, Integer> map = new HashMap<>();
        int i = 0, j = 0, ans = 1;
        while (i < n && j < n) {
            map.put(nums[j], map.getOrDefault(nums[j], 0) + 1);
            while (map.get(nums[j]) > k) {
                map.put(nums[i], map.get(nums[i]) - 1);
                i++;
            }
            ans = Math.max(ans, j - i + 1);
            j++;
        }
        return ans;
    }
}