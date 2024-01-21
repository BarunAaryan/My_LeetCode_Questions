class Solution {
    public int findTheDistanceValue(int[] arr1, int[] arr2, int d) {
        int cnt=0;
        for(int i=0; i<arr1.length; i++){
            int fst= arr1[i];
            boolean flag= false;
            for(int j=0; j<arr2.length; j++){
                int scd= arr2[j];
                if(Math.abs(scd-fst)<=d){
                    flag= true;
                    break;
                }
            }
            if(flag== false){
                cnt++;
            }
        }
        return cnt;
    }
}