package com.babkamen.abstract_factory;

public class ArtDecoChair implements Chair {

    @Override
    public boolean hasLegs() {
        return true;
    }

    @Override
    public void sitOn() {
        System.out.println("Sitting on Art deco chair");
    }
}
