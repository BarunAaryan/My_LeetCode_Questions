class Solution {
    public int longestOnes(int[] nums, int k) {
        int l = 0; // Left pointer
        int r = 0; // Right pointer
        int zeros = 0; // Number of zeros in the current window
        int maxLength = 0; // Maximum length of the window with at most k zeros
        
        while (r < nums.length) {
            if (nums[r] == 0) {
                zeros++;
            }
            
            while (zeros > k) {
                if (nums[l] == 0) {
                    zeros--;
                }
                l++;
            }
            
            maxLength = Math.max(maxLength, r - l + 1);
            r++;
        }
        
        return maxLength;
    }
}
