import java.util.concurrent.Flow;

class GameSubscription implements Flow.Subscription {

    private final Game game;
    private final Flow.Subscriber<? super Integer> subscriber;

    public GameSubscription(Game game, Flow.Subscriber<? super Integer> subscriber) {
        this.game = game;
        this.subscriber = subscriber;
    }

    @Override
    public void request(long n) {

    }

    @Override
    public void cancel() {
        game.unsubscribe(subscriber);
    }
}
