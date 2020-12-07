package stock_example;

import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

import java.util.UUID;

@ToString
@Getter
@RequiredArgsConstructor
public abstract class Order {
    private String id = UUID.randomUUID().toString();
    @NonNull
    protected StockOperationType type;

    abstract public void execute();
}
