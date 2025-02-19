class Solution {
    public boolean rotateString(String s, String goal) {
        int m = s.length();
        int n = goal.length();

        if (m != n) {
            return false;
        }

        if ((s + s).contains(goal)) {
            return true;
        }

        return false;
    }
}