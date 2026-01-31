/**
 * @param {number[]} fruits
 * @return {number}
 */
var totalFruit = function(fruits) {
    let maxlen=0;
    let lastFruit =-1, secondLastFruit= -1;
    let currCount =0, lastFruitStreak =0;

    //Transverse the fruits array
    for(let fruit of fruits){
        //if current fruit matches the last 2 types
        if(fruit == lastFruit || fruit == secondLastFruit){
            currCount++;
        }else{
            //Reset the streak size
            currCount = lastFruitStreak+1;
        }
        //update streak and fruit types
        if (fruit ===lastFruit){
            lastFruitStreak++;
        //if its a new fruit update the 2nd last and last fruit
        }else{
            lastFruitStreak=1;
            secondLastFruit = lastFruit;
            lastFruit = fruit;
        }
        maxlen = Math.max(maxlen, currCount);

    }
    return maxlen
};