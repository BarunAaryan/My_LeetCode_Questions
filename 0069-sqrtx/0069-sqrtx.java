class Solution {
    public int mySqrt(int x) {
    long low=1, high=x;
        //Binary search on the answers
        while(low<=high){
            long mid= (low+high)/2;
            long val = mid*mid;
            if(val<=(long)(x)){
                //eliminate the left half
                low=(int)(mid+1);
            }else{
                //eliminate the right half
                high=(int)(mid-1);
            }
        }
        return (int)high;
    }
}