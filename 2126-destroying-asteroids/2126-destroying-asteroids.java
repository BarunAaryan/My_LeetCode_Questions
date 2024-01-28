class Solution {
    public boolean asteroidsDestroyed(int mass, int[] asteroids) {
        Arrays.sort(asteroids);
        for(int size: asteroids) {
            if(size > mass) return false;
            else if(mass > 100_000) return true;
            mass += size;
        }
        return true;
    }
}