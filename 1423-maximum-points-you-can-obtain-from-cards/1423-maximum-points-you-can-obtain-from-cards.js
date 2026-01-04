/**
 * @param {number[]} cardPoints
 * @param {number} k
 * @return {number}
 */
var maxScore = function(cardPoints, k) {
  const n= cardPoints.length;
  let total =0;
  for(i=0; i<k; i++){
    total+=cardPoints[i];
  }  
  let maxPoints= total;
  //Shifting
  for (let i=0; i<k; i++){
    total-=cardPoints[k-1-i];
    total+=cardPoints[n-1-i];
    maxPoints = Math.max(maxPoints, total);
  }
  return maxPoints;
};