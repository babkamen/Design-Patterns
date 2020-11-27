import lombok.AllArgsConstructor;
import lombok.Data;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
public class Product implements Priceable {
    private String name;
    private BigDecimal price;
}
