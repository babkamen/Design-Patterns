package abstract_factory;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FurnitureFactoryTest {
    @Test
    public void modernFurnitureTest(){
        Client client = new Client(new ArtDecoFurnitureFactory());
        client.testFurniture();
        assertTrue(client.everythingHasLegs());

        client.setFurnitureFactory(new ModernFurnitureFactory());
        client.testFurniture();
        assertFalse(client.everythingHasLegs());
    }
}