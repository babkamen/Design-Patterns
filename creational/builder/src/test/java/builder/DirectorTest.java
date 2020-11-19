package builder;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DirectorTest {

    @Test
    public void createRoundCabinWithGarage() {
        HouseBuilder builder = new RoundCabinBuilder();
        Director director = new Director(builder);
        director.createHouseWithGarage();

        House house = builder.build();
        assertTrue(house.isHasGarage());
        assertEquals(1, house.getWalls());
    }

    @Test
    public void createHouseWithSwimmingPool() {
        HouseBuilder builder = new StoneHouseBuilder();
        Director director = new Director(builder);
        director.createHouseWithSwimmingPool();

        House house = builder.build();
        assertFalse(house.isHasGarage());
        assertEquals(4, house.getWalls());
    }
}