import lombok.Getter;

import java.io.Closeable;
import java.util.concurrent.Flow;

/**
 * Rats attack as a swarm so attack of each rat=number of rats in swarm
 */
public class Rat implements Closeable, Flow.Subscriber<Integer> {

    private Game game;
    private Flow.Subscription subscription;
    @Getter
    private int attack = 1;
    private int id;


    public Rat(Game game) {
        this.game = game;
        game.subscribe(this);
        this.id = this.game.getNumberOfSubscribers() + 1;
        System.out.println("Created rat with id " + id);

    }

    @Override
    public void close() {
        this.subscription.cancel();
    }

    @Override
    public void onSubscribe(Flow.Subscription subscription) {
        this.subscription = subscription;
        System.out.println("On subscribe");
    }

    @Override
    public synchronized void onNext(Integer item) {
        this.attack = item;
        System.out.println("Changing attack to " + this.attack + " for rat#" + id);
    }

    @Override
    public void onError(Throwable throwable) {
    }

    @Override
    public void onComplete() {
    }

    @Override
    public String toString() {
        return "Rat{" +
                "attack=" + attack +
                ", id=" + id +
                '}';
    }
}

