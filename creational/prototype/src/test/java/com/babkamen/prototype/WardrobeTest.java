package com.babkamen.prototype;

import org.apache.commons.lang3.SerializationUtils;
import org.junit.jupiter.api.Test;

import java.awt.*;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

class WardrobeTest {

    @Test
     void testWardrobe() {

        Wardrobe wardrobe = new Wardrobe();
        wardrobe.setName("wardrobe1");
        Garment shirt = new Garment(Size.S, Color.BLACK, Fabric.LEATHER, "shirt");
        wardrobe.getGarments().add(shirt);
        wardrobe.getGarments().add(new Garment(Size.M, Color.WHITE, Fabric.WOOL, "trousers"));
        Wardrobe clone = SerializationUtils.clone(wardrobe);

        assertEquals(wardrobe, clone);
        //check for deep cloning
        shirt.setColor(Color.BLUE);
        assertNotEquals(wardrobe, clone);
    }

}
