/**
 * @param {number[]} weights
 * @param {number} days
 * @return {number}
 */

var daysRequired = function(weights, capacity){
    let days =1;
    let currentLoad=0;
    for(let w of weights){
        if(currentLoad+w>capacity){
            days++;
            currentLoad=w;
        }else{
            currentLoad+=w;
        }

    }
    return days;


}
var shipWithinDays = function(weights, days) {
    let low = Math.max(...weights);
    let high = weights.reduce((acc, curr) => acc + curr, 0);
    while(low<=high){
        let mid = Math.floor(low + (high - low) / 2);
        //Calculate how many days needed for capacity
        let needed = daysRequired(weights, mid);
        if(needed<=days){
            high = mid-1;
        }else{
            low= mid+1
        }

    }return low;
    


    
};