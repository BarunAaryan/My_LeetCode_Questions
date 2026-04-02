/**
 * @param {number[]} piles
 * @param {number} h
 * @return {number}
 */

var calculateTotalHours = function(piles, speed){
    let totalH = 0;
    for (let bananas of piles) {
        totalH += Math.floor((bananas + speed - 1) / speed); // FIX
    }
    return totalH;
}

var minEatingSpeed = function(piles, h) {
    let maxPile = Math.max(...piles);
    
    let low = 1, high = maxPile;
    let ans = maxPile;

    while (low <= high) {
        let mid = Math.floor((low + high) / 2);
        let totalH = calculateTotalHours(piles, mid); // FIX

        if (totalH <= h) {
            ans = mid;
            high = mid - 1;
        } else {
            low = mid + 1;
        }
    }
    return ans;
};