class Solution {
    public int[][] highestPeak(int[][] isWater) {
        int n = isWater.length, m = isWater[0].length;
        int[][] ans = new int[n][m];

        Queue<int[]> q = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (isWater[i][j] == 1) {
                    ans[i][j] = 0;
                    q.add(new int[]{i, j});
                } else {
                    ans[i][j] = -1;  // Initialize non-water cells with -1.
                }
            }
        }

        int[] temp = {-1, 0, 1, 0, -1};
        while (!q.isEmpty()) {
            int[] a = q.poll();
            int x = a[0], y = a[1];
            int v = ans[x][y];

            for (int i = 0; i < temp.length - 1; i++) {
                int newX = x + temp[i];
                int newY = y + temp[i + 1];
                if (newX >= 0 && newX < n && newY >= 0 && newY < m && ans[newX][newY] == -1) {
                    ans[newX][newY] = v + 1;
                    q.add(new int[]{newX, newY});
                }
            }
        }

        return ans;
    }
}