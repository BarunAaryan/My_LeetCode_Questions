class Solution {
    public int firstOccurrence(int[] nums, int target){
        int n= nums.length;
        int low= 0, high= n-1;
        int first = -1;
        while(low<=high){
            int mid = (low+ high)/2;
            //maybe an answer
            if(nums[mid] == target){
                first= mid;
                //look for smaller index on the left
                high= mid -1;
            }else if(nums[mid] <target){
                low= mid+1; //look on the right
            }else{
                high= mid-1;
            }
        }
        return first;
    }
public int lastOccurrence(int[] nums, int target){
    int n = nums.length;
    int low =0, high = n-1;
    int last= -1;
    while(low<= high){
        int mid= (low+ high)/2;
        //maybe an answer
        if(nums[mid]== target){
            last = mid;
            //look for larger index on the right
            low= mid+1;
        }else if(nums[mid]<target){
               low= mid+1; //look at the right
        }
        else{
            high= mid-1; //look on the left
        }
    }
    return last;
}


    public int[] searchRange(int[] nums, int target) {
        int first = firstOccurrence(nums, target);
        if(first ==-1){
            return new int[] {-1, -1};
        }
        int last = lastOccurrence(nums, target);
        return new int[]{first, last};
    }
}