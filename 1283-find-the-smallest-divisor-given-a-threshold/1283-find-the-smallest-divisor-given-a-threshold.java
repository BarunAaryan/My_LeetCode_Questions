class Solution {
    //Helper function to calculate sum of divisor
    private int sumByD(int[] nums, int div){
        int sum=0;
        for(int num:nums){
            sum+=Math.ceil((double)num/div);
        }
        return sum;
    }

    public int smallestDivisor(int[] nums, int threshold) {
        if(nums.length>threshold) return -1;
        int low = 1;
        int high = Arrays.stream(nums).max().getAsInt();
        //BS on answer
        while(low<=high){
            int mid = low + (high - low) / 2;
            if(sumByD(nums,mid)<=threshold){
                high = mid -1;
            }else{
                low = mid+1;
            }
        }
        return low;
        
    }
}