package com.babkamen.adapter;

import lombok.experimental.Delegate;

import java.util.ArrayList;
import java.util.List;

interface WarriorList extends List<Warrior> {

}

public class Tournament {

    @Delegate(types = WarriorList.class)
    private List<Warrior> warriors = new ArrayList<>();

    public void fight() {
        warriors.forEach(f -> System.out.println(f.getName() + " attacks for " + f.attack()));
    }
}
