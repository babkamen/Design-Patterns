package stock_example;

public class BuyStockOrder extends Order{
    private StockTrade stockTrade;

    public BuyStockOrder(StockTrade stockTrade) {
        super(StockOperationType.BUY);
        this.stockTrade = stockTrade;
    }

    @Override
    public void execute() {
        stockTrade.buy();
    }
}
