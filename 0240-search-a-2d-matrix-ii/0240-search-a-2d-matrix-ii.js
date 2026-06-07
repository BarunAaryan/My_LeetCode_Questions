/**
 * @param {number[][]} matrix
 * @param {number} target
 * @return {boolean}
 */
var searchMatrix = function(matrix, target) {
    const n = matrix.length;
    const m = matrix[0].length;

    let row = 0;
    let col = m - 1;

    while (row < n && col >= 0) {
        const current = matrix[row][col];

        if (current === target) {
            return true;
        } else if (current < target) {
            row++;      // Move down
        } else {
            col--;      // Move left
        }
    }
    return false;
};