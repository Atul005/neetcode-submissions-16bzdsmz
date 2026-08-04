class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();

        for(String str : strs){
            char[]  chars = str.toCharArray();
            Arrays.sort(chars);
            String key = new String(chars);
            List<String> temp = map.get(key);
            if(temp == null){
                temp = new ArrayList<>();
                map.put(key, temp);
            }
            temp.add(str);
        }

        return new ArrayList<>(map.values());
    }
}
