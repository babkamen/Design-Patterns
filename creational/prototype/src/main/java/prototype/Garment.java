package prototype;

import lombok.*;

import java.awt.*;

@AllArgsConstructor
@Data
public class Garment implements Cloneable {
    private Size size;
    private Color color;
    private Fabric fabric;
    private String name;

    @Override
    public Garment clone() throws CloneNotSupportedException {
        return new Garment(size, color, fabric, name);
    }
}
