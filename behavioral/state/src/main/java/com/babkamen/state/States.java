package com.babkamen.state;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public enum States {
    OPEN("OPEN"),
    LOCKED("LOCKED"),
    ERROR("ERROR"),
    DIGIT_INPUT("");

    private String value;
    private List<Integer> combination = new ArrayList<>();

    States(String value) {
        this.value = value;
    }

    public String getValue() {
        if (!combination.isEmpty()) {
            return combination.stream().map(Objects::toString).collect(Collectors.joining());
        }
        return value;
    }

    public void enterDigit(int n) {
        combination.add(n);
    }

    public List<Integer> getCombination() {
        return combination;
    }
}