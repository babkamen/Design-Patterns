package stock_example;

import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AgentTest {

    @Test
    public void testRedoLastAction() {
        StockTrade stockTrade = new StockTrade();
        SellStockOrder sellStockOrder = new SellStockOrder(stockTrade);
        BuyStockOrder buyStockOrder = new BuyStockOrder(stockTrade);

        Agent agent = new Agent();
        agent.placeOrder(buyStockOrder);
        agent.placeOrder(sellStockOrder);
        agent.redoLastAction();

        List<StockOperationType> expectedOperations = List.of(StockOperationType.BUY, StockOperationType.SELL, StockOperationType.SELL);
        assertEquals(expectedOperations, agent.getOrders().stream().map(Order::getType).collect(Collectors.toList()));
    }
}
