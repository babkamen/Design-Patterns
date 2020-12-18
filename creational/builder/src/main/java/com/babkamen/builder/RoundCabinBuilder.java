package com.babkamen.builder;

public class RoundCabinBuilder implements HouseBuilder {

    private int roof, windows, walls, door;
    private boolean hasGarage, hasSwimmingPool, hasGarden;

    @Override
    public HouseBuilder buildWalls() {
        this.walls = 1;
        return this;
    }

    @Override
    public HouseBuilder buildDoors() {
        this.door = 2;
        return this;
    }

    @Override
    public HouseBuilder buildWindows() {
        this.windows = 2;
        return this;
    }

    @Override
    public HouseBuilder buildRoof() {
        this.roof = 1;
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
