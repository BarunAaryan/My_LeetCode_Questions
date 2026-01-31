class Solution {
    public int totalFruit(int[] fruits) {
        int maxlen=0;
        int lastFruit=-1, secondLastFruit=-1;
        int currCount =0, lastFruitStreak=0;
        //treansverese through the fruits
        for(int fruit: fruits){
            //if fruit matches last two , expand the window
            if(fruit ==lastFruit || fruit ==secondLastFruit){
                currCount++;
            }else{
                //Reset Window size to streak+1
                currCount= lastFruitStreak+1;
            }
            //Update LastFruitStreak and fruit types
            if (fruit==lastFruit){
                lastFruitStreak++;
            }else{
                lastFruitStreak=1;
                secondLastFruit= lastFruit;
                lastFruit= fruit;
            }

            //update max window size
            maxlen = Math.max(maxlen, currCount);
        }
        return maxlen;
        
    }
}