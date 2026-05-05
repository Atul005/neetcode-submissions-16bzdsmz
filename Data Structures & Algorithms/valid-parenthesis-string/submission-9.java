class Solution {
    public boolean checkValidString(String s) {
        int l = 0;
        int star = 0;
        int i=0;
        Deque<Integer> stk1 = new ArrayDeque<>();
        Deque<Integer> stk2 = new ArrayDeque<>();
        while(i<s.length()){
            if(s.charAt(i) == '('){
                stk1.push(i);
            }else if(s.charAt(i) == '*'){
                stk2.push(i);
            }else{
                if(stk1.isEmpty()){
                   if(stk2.isEmpty()){
                    return false;
                   }else{
                    stk2.pop();
                   }
                }else{
                    stk1.pop();
                }
            }
            i++;
        }
        while(!stk1.isEmpty() && !stk2.isEmpty()){
            if(stk1.peek() < stk2.peek()){
                stk1.pop();
                stk2.pop();
            }else{
                return false;
            }
        }
        return stk1.isEmpty();
    }
}
