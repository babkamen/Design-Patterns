package com.babkamen.abstract_factory;

public class ArtDecoCoffeeTable implements CoffeeTable {

    @Override
    public boolean hasLegs() {
        return true;
    }

    @Override
    public void drinkCoffee() {
        System.out.println("Drinking coffee from Art deco coffee table");
    }
}
