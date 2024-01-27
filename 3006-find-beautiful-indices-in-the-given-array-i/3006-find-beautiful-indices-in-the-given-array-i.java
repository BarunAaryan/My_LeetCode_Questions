class Solution {
    public List<Integer> beautifulIndices(String s, String a, String b, int k) {
        char aChar = a.charAt(0);
        char bChar = b.charAt(0);
        int aLen = a.length();
        int bLen = b.length();
        int n = s.length();
        int ai = 0, aj = aLen-1;
        int bi = 0, bj = bLen-1;
        List<Integer> aIndices = new ArrayList<>();
        List<Integer> bIndices = new ArrayList<>();
        for(int i = 0; i < n; i++) {
            char c = s.charAt(i);
            if(i <= n-aLen && c == aChar) {
                String str = s.substring(i,i+aLen);
                if(a.equals(str)) {
                    aIndices.add(i);
                }
            }
            if(i <= n-bLen && c == bChar) {
                String str = s.substring(i,i+bLen);
                if(b.equals(str)) {
                    bIndices.add(i);
                }
            }
        }
        List<Integer> result = new ArrayList<>();
        for(int i = 0; i < aIndices.size(); i++) {
            for(int j = 0; j < bIndices.size(); j++) {
                int calc = Math.abs(bIndices.get(j) - aIndices.get(i));
                if(calc <= k) {
                    result.add(aIndices.get(i));
                    break;
                }
            }
        }
        return result;
    }
}