package stock_example;

public class SellStockOrder extends Order {
    private StockTrade stockTrade;

    public SellStockOrder(StockTrade stockTrade) {
        super(StockOperationType.SELL);
        this.stockTrade = stockTrade;
    }

    @Override
    public void execute() {
        stockTrade.sell();
    }
}
