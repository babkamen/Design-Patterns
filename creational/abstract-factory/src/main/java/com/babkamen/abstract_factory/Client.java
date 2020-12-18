package com.babkamen.abstract_factory;

import lombok.AllArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@Setter
public class Client {

    private FurnitureFactory furnitureFactory;

    public boolean everythingHasLegs() {
        return furnitureFactory.createSofa().hasLegs() &&
                furnitureFactory.createCoffeeTable().hasLegs() &&
                furnitureFactory.createChair().hasLegs();
    }

    public void testFurniture() {
        furnitureFactory.createChair().sitOn();
        furnitureFactory.createCoffeeTable().drinkCoffee();
        furnitureFactory.createSofa().lieOn();
    }
}
