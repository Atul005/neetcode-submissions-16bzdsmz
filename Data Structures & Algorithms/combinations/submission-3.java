class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> res = new ArrayList<>();
        comb(1, n, k, res,  new ArrayList<Integer>());
        return res;
    }

    public void comb(int index, int n, int k, List<List<Integer>> res, ArrayList<Integer> temp){
        if(temp.size() == k){
            res.add(new ArrayList<>(temp));
            return;
        }

        if(index > n){
            return;
        }

        temp.add(index);
        comb(index+1,n,k,res, temp);

        temp.remove(temp.size()-1);
        comb(index+1,n,k,res, temp);
    }
}