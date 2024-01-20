class Solution {
    public int getLastMoment(int n, int[] left, int[] right) {
        int lastMoment=0;
        //Calculte the max position in the left list
        for(int l: left){
            lastMoment = Math.max(lastMoment, l);
        }
        //Calculte the max position in the left list
        for(int r: right){
            lastMoment = Math.max(lastMoment, n-r);
        }
          return lastMoment;
        
    }
}