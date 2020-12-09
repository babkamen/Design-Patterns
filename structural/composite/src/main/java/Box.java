import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class Box implements Priceable {

    private List<Priceable> children = new ArrayList<>();

    public void add(Priceable child) {
        children.add(child);
    }

    @Override
    public BigDecimal getPrice() {
        BigDecimal result = BigDecimal.ZERO;
        for (Priceable child : children) {
            result = result.add(child.getPrice());
        }
        return result;
    }
}
