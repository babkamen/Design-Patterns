import java.util.concurrent.Flow;

class GameSubscription implements Flow.Subscription {
    private Game game;
    private Flow.Subscriber subscriber;

    public GameSubscription(Game game, Flow.Subscriber subscriber) {
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
