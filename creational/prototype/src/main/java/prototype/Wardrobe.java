package prototype;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@Setter
@Getter
@EqualsAndHashCode
public class Wardrobe implements Cloneable {
    private List<Garment> garments = new ArrayList<>();
    private String name;

    @Override
    public Wardrobe clone() throws CloneNotSupportedException {
        Wardrobe wardrobe = new Wardrobe();
        wardrobe.setName(this.name);
        for (Garment garment : garments) {
            wardrobe.getGarments().add(garment.clone());
        }
        return wardrobe;
    }
}
