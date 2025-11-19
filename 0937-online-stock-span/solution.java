class StockSpanner {

    Stack<Integer> st;     // stores indices
    ArrayList<Integer> prices;   // to store incoming prices

    public StockSpanner() {
        st = new Stack<>();
        prices = new ArrayList<>();
    }
    
    public int next(int price) {

        int index = prices.size();   // current index
        prices.add(price);

        // Pop all smaller or equal prices
        while (!st.isEmpty() && prices.get(st.peek()) <= price) {
            st.pop();
        }

        int span;

        // If stack empty → no greater element on left
        if (st.isEmpty()) {
            span = index + 1;
        } else {
            span = index - st.peek();
        }

        // Push this index
        st.push(index);

        return span;
    }
}

