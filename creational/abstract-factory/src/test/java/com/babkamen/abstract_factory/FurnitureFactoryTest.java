package com.babkamen.abstract_factory;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class FurnitureFactoryTest {

    @Test
    void modernFurnitureTest() {
        Client client = new Client(new ArtDecoFurnitureFactory());
        client.testFurniture();
        assertTrue(client.everythingHasLegs());

        client.setFurnitureFactory(new ModernFurnitureFactory());
        client.testFurniture();
        assertFalse(client.everythingHasLegs());
    }
}