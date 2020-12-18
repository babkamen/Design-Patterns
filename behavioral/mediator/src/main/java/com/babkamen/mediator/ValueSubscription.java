package com.babkamen.mediator;

import java.util.concurrent.Flow;

class ValueSubscription implements Flow.Subscription {

    private int value;

    public ValueSubscription(int value) {
        this.value = value;
    }

    @Override
    public void request(long n) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void cancel() {
        throw new UnsupportedOperationException();
    }

    public int getValue() {
        return value;
    }
}