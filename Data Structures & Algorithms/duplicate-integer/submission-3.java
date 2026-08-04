class Solution {
    public boolean hasDuplicate(int[] a) {
        Set<Integer> set = new HashSet<>();
        for(int i=0;i<a.length;i++){
           if(set.contains(a[i])){
            return true;
           }
           else{
            set.add(a[i]);
           }
        }
        return false;
    }
}