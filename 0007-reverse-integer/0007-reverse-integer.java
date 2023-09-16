class Solution {
    public int reverse(int x) {
        int rev=0;
        //at the end x becomes 0 - so until x becomes 0 we need to do it
        while(x!=0){
            int digit= x%10;
            //overflow conditions
            if(rev>Integer.MAX_VALUE/ 10 || rev<Integer.MIN_VALUE/ 10){
                return 0;
            }
rev= (rev*10)+ digit;
x= x/10;
        }
        return rev;
    }
}