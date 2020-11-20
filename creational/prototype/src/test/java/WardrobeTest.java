import org.junit.jupiter.api.Test;
import prototype.Fabric;
import prototype.Garment;
import prototype.Size;
import prototype.Wardrobe;

import java.awt.*;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class WardrobeTest {
    @Test
    public void testWardrobe() throws CloneNotSupportedException {

        Wardrobe wardrobe = new Wardrobe();
        wardrobe.setName("wardrobe1");
        Garment shirt = new Garment(Size.S, Color.BLACK, Fabric.LEATHER, "shirt");
        wardrobe.getGarments().add(shirt);
        wardrobe.getGarments().add(new Garment(Size.M, Color.WHITE, Fabric.WOOL, "trousers"));

        Wardrobe clone = wardrobe.clone();

        assertEquals(wardrobe, clone);
        //check for deep cloning
        shirt.setColor(Color.BLUE);
        assertNotEquals(wardrobe,clone);
    }

}
