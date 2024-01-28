class Solution {
    public int maximumProduct(int[] nums, int k) {
        PriorityQueue<Long> minHeap = new PriorityQueue<>();
        int n = nums.length;
        long mod = 1000000007;
        if(n == 1) {
            long ans = (nums[0]+k)%mod;
            return (int) ans;
        }
        for(int i = 0; i < n; i++) {
            minHeap.offer((long) nums[i]);
        }
        while(k > 0) {
            long num1 = minHeap.poll();
            long num2 = minHeap.poll();
            long diff = Math.min(k,(num2-num1)+1);
            num1 += diff;
            k -= diff;
            minHeap.add(num1);
            minHeap.add(num2);
        }

        long ans = 1;
        while(!minHeap.isEmpty()) {
            long elem = minHeap.poll();
            ans = (ans*elem) % mod;
        }

        return (int)ans;
    }
}