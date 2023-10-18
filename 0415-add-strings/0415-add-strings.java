class Solution {
    public String addStrings(String num1, String num2) {
        int p1 = num1.length() - 1;
        int p2 = num2.length() - 1;
        StringBuilder res = new StringBuilder();
        int c = 0, base = 10;

        while (p1 >= 0 || p2 >= 0) {
            int s = 0, s1 = 0, s2 = 0;
            if (p1 >= 0) {
                s1 = num1.charAt(p1--) - '0';
            }
            if (p2 >= 0) {
                s2 = num2.charAt(p2--) - '0';
            }
            s = s1 + s2 + c;
            c = s / base; // Update carry for the next iteration
            s = s % base; // Update s to the digit to be appended

            res.append(s); // Append the current digit to the result
        }

        if (c == 1) {
            res.append(c);
        }
        
        return res.reverse().toString();
    }
}
