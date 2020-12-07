package stock_example;

import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Getter
public class Agent {
    private List<Order> orders = new ArrayList<>();

    public void placeOrder(Order order) {
        this.orders.add(order);
        order.execute();
    }

    public void redoLastAction() {
        if (!orders.isEmpty()) {
            Order order = this.orders.get(orders.size() - 1);
            this.orders.add(order);
            order.execute();
        }
    }
}
