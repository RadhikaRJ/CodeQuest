class StockSpanner {
    List<Integer> priceList;
    public StockSpanner() {
        this.priceList = new ArrayList<>();
    }
    //[100,80,60,70],
    public int next(int price) {
        int span = 1;
        int numberOfDays = priceList.size(); //3
        if(numberOfDays == 0){
           priceList.add(price);
            return span;
        }

      //  int days = 0;
        for(int i=numberOfDays-1;i>=0;i--){
            if(priceList.get(i)<=price){
                span++;
            }
            else if(priceList.get(i)>price){
                break;
            }
        }
        priceList.add(price);
        return span;
    }
}

/**
 * Your StockSpanner object will be instantiated and called as such:
 * StockSpanner obj = new StockSpanner();
 * int param_1 = obj.next(price);
 */