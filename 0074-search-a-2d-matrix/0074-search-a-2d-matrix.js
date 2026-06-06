/**
 * @param {number[][]} matrix
 * @param {number} target
 * @return {boolean}
 */
var searchMatrix = function(matrix, target) {
    const n = matrix.length;
    const m = matrix[0].length;
    let low=0;
    let high = n*m-1;
    while(low<=high){
        const mid = Math.floor((low+high)/2);
        const row = Math.floor(mid / m);
        const col = mid % m;

        if (matrix[row][col] === target) {
            return true;
        } else if (matrix[row][col] < target) {
            low = mid + 1;
        } else {
            high = mid - 1;
        }
    }

    return false;

};