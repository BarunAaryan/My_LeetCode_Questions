/**
 * @param {number[]} bloomDay
 * @param {number} m
 * @param {number} k
 * @return {number}
 */
var isPossible = function (bloomDay, day, m, k) {
  let bouquets = 0;
  let count = 0;

  for (let bloom of bloomDay) {
    if (bloom <= day) {
      count++;
      if (count === k) {
        bouquets++;
        count = 0;
      }
    } else {
      count = 0;
    }
  }

  return bouquets >= m;
};

var minDays = function (bloomDay, m, k) {
  if (m * k > bloomDay.length) return -1;

  let minDay = Math.min(...bloomDay);
  let maxDay = Math.max(...bloomDay);
  let result = -1;

  while (minDay <= maxDay) {
    let mid = Math.floor((minDay + maxDay) / 2);

    if (isPossible(bloomDay, mid, m, k)) {
      result = mid;
      maxDay = mid - 1;
    } else {
      minDay = mid + 1;
    }
  }

  return result;
};