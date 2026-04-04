class Solution {
    //helper function to calculate Days required
    private int daysRequired(int [] weights, int capacity){
        int days=1, currentLoad=0;
        //iterte over all package weights
        for(int w: weights){
            //check if adding current package exceeds capacity
            if(currentLoad +w>capacity){
                // If yes, increase days count since we start a new day
                days++;
                //reset current load to current package weight
                currentLoad=w;

            }else{
                 // Else, add current package weight to current load
                currentLoad += w;
            }
        }
        return days;


    }
    public int shipWithinDays(int[] weights, int days) {
        //first we need to find range
        int low = Arrays.stream(weights).max().getAsInt();
        int high = Arrays.stream(weights).sum();
        //Binary Search
        while(low<=high){
            int mid = low + (high-low)/2;
            //Calculate how many days needed for capacity
            int needed = daysRequired(weights, mid);
            if(needed<=days){
                high = mid-1;
            }else{
                low = mid+1;
            }

        }return low;
    }
}