public class Main {
    public static void main(String[] args) {
        StockTrade stockTrade = new StockTrade();
        SellStockOrder sellStockOrder = new SellStockOrder(stockTrade);
        BuyStockOrder buyStockOrder = new BuyStockOrder(stockTrade);

        Agent agent = new Agent();
        agent.placeOrder(buyStockOrder);
        agent.placeOrder(sellStockOrder);
        agent.redoLastAction();

        System.out.println(agent.getOrders());
    }
}
