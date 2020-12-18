package com.babkamen.state;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;


public class CombinationLock {

    private List<Integer> combination;
    private States state = States.LOCKED;
    public String status = state.getValue();

    public CombinationLock(int[] combination) {
        this.combination = Arrays.stream(combination).boxed().collect(Collectors.toList());
    }

    public void enterDigit(int digit) {
        switch (state) {
            case LOCKED:
                state = States.DIGIT_INPUT;
                state.enterDigit(digit);
                break;
            case DIGIT_INPUT:
                state.enterDigit(digit);
                if (state.getCombination().size() == combination.size()) {
                    if (state.getCombination().equals(combination)) {
                        state = States.OPEN;
                    } else {
                        state = States.ERROR;
                    }
                    States.DIGIT_INPUT.getCombination().clear();
                }
                break;
            default:
                throw new RuntimeException("Something went wrong");
        }
        status = state.getValue();
    }
}