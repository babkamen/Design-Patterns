package builder;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class Director {

    private final HouseBuilder builder;

    public void createHouseWithGarage() {
        builder
                .buildDoors()
                .buildRoof()
                .buildWalls()
                .buildWindows()
                .buildGarage();
    }
    public void createHouseWithSwimmingPool() {
        builder
                .buildDoors()
                .buildRoof()
                .buildWalls()
                .buildWindows()
                .buildSwimmingPool();
    }
}
