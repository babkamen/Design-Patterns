package com.babkamen.abstract_factory;

public class ModernCoffeeTable implements CoffeeTable {

    @Override
    public boolean hasLegs() {
        return false;
    }

    @Override
    public void drinkCoffee() {
        System.out.println("Drinking coffee from modern coffee table");
    }
}
