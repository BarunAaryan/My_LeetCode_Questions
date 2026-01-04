class Solution {
    public int maxScore(int[] cardPoints, int k) {
        //get the total number of cards
        int n = cardPoints.length;
        //calculate sum of first k cards from the front
        int total =0;
        for(int i =0; i<k; i++){
            total+=cardPoints[i];
        }
        //Store the max score 
        int maxPoints= total;
        //Slide the window remove from front and add it in the back
        for(int i =0; i<k; i++){
            //Subtract Card from the front
            total -=cardPoints[k-1-i];
            //Add Caerd from back 
            total +=cardPoints[n-1-i];
            maxPoints = Math.max(maxPoints, total);
        }
        //return best possible score
        return maxPoints;
    }
}