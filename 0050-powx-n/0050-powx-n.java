class Solution {
    public double myPow(double x, int n) {
        double ans = 1.0;
        long nn= n;
        if(nn<0){ //if nn is -ve make it +ve;
            nn= -1*nn;
        }
        while(nn>0){
            if(nn%2==1){
                //odd power
                ans= ans *x;
                nn=nn-1;
            }
            else{
                //even power
                x= x*x;
                nn= nn/2;
            }
        }
        if(n<0){ //if n is nagative
            ans = (double)(1.0)/ (double)(ans);
        }
        return ans;
    }
}