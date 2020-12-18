package com.babkamen.adapter;

import lombok.RequiredArgsConstructor;

import java.util.Random;

@RequiredArgsConstructor
public class Pokemon implements Warrior {

    private final String name;
    private int atkBase = 100;
    private Random random = new Random();
    private double critChance = 0.05;

    @Override
    public int attack() {
        int attackPower = atkBase + random.nextInt(100);
        if (random.nextDouble() >= critChance) {
            attackPower *= 1.5;
        }
        return attackPower;
    }

    @Override
    public String getName() {
        return name;
    }
}
