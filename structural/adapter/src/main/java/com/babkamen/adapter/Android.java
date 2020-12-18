package com.babkamen.adapter;

import java.util.Random;

public class Android {

    public static final int PUNCH_POWER = 10;
    private Random rnd =new Random();
    public int punch() {
        return PUNCH_POWER;
    }

    public int kick() {
        return rnd.nextInt(this.punch() * this.punch());
    }
}
