class Solution {
    public boolean carPooling(int[][] trips, int capacity) {
        int[] first = trips[0];
        if(first[0] > capacity){
            return false;
        }

        int[] stops = new int[1001];

        for(int[] trip : trips){
            int numPassengers = trip[0];
            int start = trip[1];
            int end = trip[2];

            stops[start] += numPassengers;
            stops[end]  -= numPassengers; 
        }

        int currentPassenger = 0;

        for(int passengers : stops){
            currentPassenger += passengers;
            if(currentPassenger > capacity){
                return false;
            }
        }

        return true;
    }
}