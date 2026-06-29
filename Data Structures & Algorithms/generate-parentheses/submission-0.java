class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        generate(n, res, 0, 0, new StringBuilder());    
        return res;
    }

    public void generate(int n, List<String> res, int open, int close, StringBuilder temp){
        if(temp.length() == 2*n){
            res.add(temp.toString());
        }

        if(open < n){
            temp.append('(');
            generate(n, res, open+1, close, temp);
            temp.deleteCharAt(temp.length()-1);
        }

        if(close < open){
            temp.append(')');
            generate(n, res, open, close+1, temp);
            temp.deleteCharAt(temp.length() - 1);
        }
    }

}
