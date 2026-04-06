class Solution {
    public boolean isNStraightHand(int[] hand, int groupSize) {
        if(hand.length % groupSize != 0){
            return false;
        }

        TreeMap<Integer, Integer> map = new TreeMap<>();

        for(int i=0; i<hand.length; i++){
            map.put(hand[i], map.getOrDefault(hand[i], 0) + 1);
        }

        for(int key : map.keySet()){
            int count = map.get(key);
            while(count > 0){
                int curr = key;
                for(int i=0;i<groupSize;i++){
                    curr = key + i;

                    if(!(map.getOrDefault(curr, 0) > 0)){
                        return false;
                    } 

                    map.put(curr, map.getOrDefault(curr, 0) - 1);
                }
                count--;
            }
        }
        return true;
    }
}
