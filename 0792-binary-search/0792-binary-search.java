class Solution {
    public int binarySearch(int[] nums, int low, int high, int target){
                
        while(low<=high){
        int mid= (low+high)/2;
        if(nums[mid]==target){
         return mid;
}
           else if(target>nums[mid]){
              return binarySearch(nums, mid+1, high, target);
            } else{
             return binarySearch(nums, low, mid-1, target);
}
        }
        return -1;
    }
    public int search(int[] nums, int target) {
       return binarySearch(nums, 0, nums.length-1, target);
    }
}