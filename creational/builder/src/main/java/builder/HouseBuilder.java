package builder;

public interface HouseBuilder {

    HouseBuilder buildWalls();

    HouseBuilder buildDoors();

    HouseBuilder buildWindows();

    HouseBuilder buildRoof();

    HouseBuilder buildGarage();

    HouseBuilder buildSwimmingPool();

    HouseBuilder buildGarden();

    House build();
}
