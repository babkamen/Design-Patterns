package prototype;

import lombok.*;

import java.awt.*;
import java.io.Serializable;

@AllArgsConstructor
@Data
public class Garment implements Serializable {
    private Size size;
    private Color color;
    private Fabric fabric;
    private String name;
}
