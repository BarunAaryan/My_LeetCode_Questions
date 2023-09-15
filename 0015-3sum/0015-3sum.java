class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>(); // Initialize res within the method

        // Sort the array
        Arrays.sort(nums);

        for (int i = 0; i < nums.length - 2; i++) { // Iterate up to the third-to-last element
            if (i == 0 || (i > 0 && nums[i] != nums[i - 1])) { // Avoid duplicates for a1
                int target = -nums[i];
                int left = i + 1;
                int right = nums.length - 1;

                while (left < right) {
                    if (nums[left] + nums[right] == target) {
                        res.add(Arrays.asList(nums[i], nums[left], nums[right]));

                        // Skip duplicates for b and c
                        while (left < right && nums[left] == nums[left + 1]) left++;
                        while (left < right && nums[right] == nums[right - 1]) right--;

                        left++;
                        right--;
                    } else if (nums[left] + nums[right] < target) {
                        left++;
                    } else {
                        right--;
                    }
                }
            }
        }
        return res;
    }
}
