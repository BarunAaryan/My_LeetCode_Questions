class Solution {
    public boolean isValid(String s) {
        Stack<Character> sta = new Stack<>();
        for(int i =0 ; i<s.length(); i++){
            char ch = s.charAt(i);
            //opening
            if(ch == '(' || ch == '{' || ch == '['){
                sta.push(ch);
            }else{
                //closing 
                if(sta.isEmpty()){
                    return false;
                }
            if((sta.peek() == '(' && ch == ')') || (sta.peek() == '{' && ch == '}') || (sta.peek() == '[' && ch == ']')){
                sta.pop();
            }else{
                return false;
            }
            }
        }
        //if stack is empty
               if(sta.isEmpty()){
                   return true;
               }else{
                   return false;
               }
    }
}