package com.babkamen.observer;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Flow;

class Game implements Flow.Publisher<Integer> {

    private List<Flow.Subscriber<? super Integer>> subscribers = new ArrayList<>();

    @Override
    public void subscribe(Flow.Subscriber<? super Integer> subscriber) {
        this.subscribers.add(subscriber);
        subscriber.onSubscribe(new GameSubscription(this, subscriber));
        submit(this.subscribers.size());
    }

    private void submit(int item) {
        subscribers.forEach(s -> s.onNext(item));
    }

    public int getNumberOfSubscribers() {
        return subscribers.size();
    }

    public void unsubscribe(Flow.Subscriber<? super Integer> subscriber) {
        subscribers.remove(subscriber);
        submit(this.subscribers.size());
    }
}
