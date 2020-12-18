package com.babkamen.builder;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class House {

    private int roof, windows, walls, door;
    private boolean hasGarage, hasSwimmingPool, hasGarden;
}
