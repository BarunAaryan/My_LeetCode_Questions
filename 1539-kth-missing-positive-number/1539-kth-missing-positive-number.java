class Solution {
    public int findKthPositive(int[] arr, int k) {
        int low=0, high = arr.length- 1;
        //Binary Search On Loop
        while(low<=high){

int mid = low + (high -low)/2;
        //number of missing elements before index mid
        int missing = arr[mid] - (mid+1);
        if (missing <k){
            low = mid+1; //Move right
        }else{
            high = mid-1; //move left
        }
        
        }
        return k+high+1;
        
        
    }
}
