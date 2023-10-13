class Solution {
    private void recurPermute(int[] nums, List<Integer> ds, List<List<Integer>> ans, boolean[] freq) {
        // Base case
        if (ds.size() == nums.length) {
            ans.add(new ArrayList<>(ds));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            // If it is not marked in the map
            if (!freq[i]) {
                // Pick the item
                freq[i] = true;
                // Add it to ds
                ds.add(nums[i]);
                recurPermute(nums, ds, ans, freq);
                // Remove the last element from ds for backtracking
                ds.remove(ds.size() - 1);
                freq[i] = false;
            }
        }
    }

    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> ds = new ArrayList<>();
        boolean[] freq = new boolean[nums.length]; // Map to keep track of used elements
        recurPermute(nums, ds, ans, freq);
        return ans;
    }
}
