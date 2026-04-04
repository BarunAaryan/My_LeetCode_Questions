class Solution {
    private static boolean isPossible(int[] bloomDay, int day,int m , int k){
        int count =0; // counts consecutive flowers that bloomed on or before 'day'
        int bouquets=0;
        for (int  bloom: bloomDay){
            if(bloom<=day){
                count++; //flower is ready
                if(count==k){
                    bouquets++; // form one bouquet
                    count = 0; // reset count for next bouquet
                }
            }else{
                    count = 0; // break in consecutive flowers
                }
            
        }
        return bouquets >= m; // check if required bouquets can be made

    }
    public int minDays(int[] bloomDay, int m, int k) {
        long required = (long)m*k; 
        if (required> bloomDay.length) return -1;//not enough flowers
        int minDay = Integer.MAX_VALUE;
        int maxDay = Integer.MIN_VALUE;

        // Find the minimum and maximum bloom day
        for (int bloom: bloomDay){
            minDay= Math.min(minDay, bloom);
            maxDay = Math.max(maxDay, bloom); 
        }
        // Binary search between minDay and maxDay
        int low= minDay, high = maxDay, result =-1;
        while(low<=high){
            int mid = (low +high)/2;
            if (isPossible(bloomDay, mid, m, k)) {
                result = mid; // possible to form bouquets, try earlier
                high = mid - 1;
            } else {
                low = mid + 1; // need more days
            }
        }
        return result;
    }
}