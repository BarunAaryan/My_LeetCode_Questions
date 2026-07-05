class Solution {
    public int countArray(int[] numbers, int maxAllowedSum) {

        int subarrayCount = 1;
        long currentSubarraySum = 0;

        for (int number : numbers) {

            if (currentSubarraySum + number <= maxAllowedSum) {
                currentSubarraySum += number;
            } else {
                subarrayCount++;
                currentSubarraySum = number;
            }
        }

        return subarrayCount;
    }
    public int splitArray(int[] nums, int k) {
        int totalElements = nums.length;
        if (k > totalElements) {
            return -1;
        }
        int low = Arrays.stream(nums).max().getAsInt();
        int high = Arrays.stream(nums).sum();
        while(low<=high){
            int mid = (low+ high)/2;
            int requiredSubarrays = countArray(nums, mid);
            if (requiredSubarrays > k) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return low;
    }
}