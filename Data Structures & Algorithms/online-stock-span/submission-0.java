class StockSpanner {

    List<Integer> prices;

    public StockSpanner() {
        prices = new ArrayList<>();
    }
    
    public int next(int price) {
        prices.add(price);
        int count = 1;

        for(int i=prices.size()-1;i>0 && price >= prices.get(i-1);i--){
            count++;
        }
        return count;
    }
}

/**
 * Your StockSpanner object will be instantiated and called as such:
 * StockSpanner obj = new StockSpanner();
 * int param_1 = obj.next(price);
 */