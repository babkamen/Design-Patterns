package builder;

public class StoneHouseBuilder implements HouseBuilder {

    private int roof, windows, walls, door;
    private boolean hasGarage, hasSwimmingPool, hasGarden;

    @Override
    public HouseBuilder buildWalls() {
        walls = 4;
        return this;
    }

    @Override
    public HouseBuilder buildDoors() {
        door = 1;
        return this;
    }

    @Override
    public HouseBuilder buildWindows() {
        windows = 4;
        return this;
    }

    @Override
    public HouseBuilder buildRoof() {
        roof = 2;
        return this;
    }

    @Override
    public HouseBuilder buildGarage() {
        hasGarage = true;
        return this;
    }

    @Override
    public HouseBuilder buildSwimmingPool() {
        hasSwimmingPool = true;
        return this;
    }

    @Override
    public HouseBuilder buildGarden() {
        hasGarden = true;
        return this;
    }

    @Override
    public House build() {
        return new House(roof, windows, walls, door, hasGarage, hasSwimmingPool, hasGarden);
    }
}
