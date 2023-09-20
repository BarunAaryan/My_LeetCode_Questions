class Solution {
    public String removeOuterParentheses(String s) {
        StringBuilder ans = new StringBuilder();
        int count = 0;

        for (int i = 0; i < s.length(); i++) {
            char currentChar = s.charAt(i);
            if (currentChar == '(') {
                if (count > 0) {
                    ans.append(currentChar);
                }
                count++;
            } else if (currentChar == ')') {
                if (count > 1) {
                    ans.append(currentChar);
                }
                count--;
            }
        }

        return ans.toString();
    }
}
