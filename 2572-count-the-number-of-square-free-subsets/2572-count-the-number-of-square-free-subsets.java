class Solution {
     private static int[] masks = new int[31];
    static {
        for (int i = 2; i <= 30; i++) {
            int x = i, m = 0;
            for (int j = 2; j * j <= x; j++) {
                if (x % j == 0) {
                    if (x / j % j == 0) {
                        m = -1;
                        break;
                    }
                    m |= 1 << j;
                    x /= j;
                }
            }
            if (m != -1 && x > 1) {
                m |= 1 << x;
            }
            masks[i] = m;
        }
    }
    public int squareFreeSubsets(int[] nums) {
        int[] cnt = new int[31];
        for (int num : nums) {
            if (masks[num] != -1) {
                cnt[num]++;
            }
        }
        Map<Integer, Long> map = new HashMap<>();
        long ans = 0, N = (long) 1e9 + 7;
        for (int i = 2; i <= 30; i++) {
            if (cnt[i] > 0) {
                int m = masks[i];
                Map<Integer, Long> tmp = new HashMap<>(map);
                ans = (ans + cnt[i]) % N;
                tmp.put(m, (tmp.getOrDefault(m, 0L) + cnt[i]) % N);
                for (Map.Entry<Integer, Long> entry : map.entrySet()) {
                    int key = entry.getKey();
                    long count = entry.getValue();
                    if ((key & m) == 0) {
                        long c = (map.getOrDefault(key | m, 0L) + count * cnt[i]) % N;
                        tmp.put(key | m, c);
                        ans = (ans + count * cnt[i]) % N;
                    }
                }
                map = tmp;
            }
        }
        for (int i = 0; i < cnt[1]; i++) {
            ans = ((ans << 1) + 1) % N;
        }
        return (int) ans;
    }
}