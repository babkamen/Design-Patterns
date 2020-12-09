import java.util.concurrent.Flow;


class Participant implements Flow.Subscriber<ValueSubscription> {
    private int value;
    private Mediator mediator;
    private int id;

    public Participant(Mediator mediator) {
        this.mediator = mediator;
        mediator.subscribe(this);
    }

    public Participant(int id, Mediator mediator) {
        this.id = id;
        this.mediator = mediator;
        mediator.subscribe(this);
    }

    public void say(int n) {
        mediator.broadcast(n, this);
    }

    @Override
    public void onSubscribe(Flow.Subscription subscription) {
    }

    @Override
    public void onNext(ValueSubscription item) {
        value += item.getValue();
    }

    @Override
    public void onError(Throwable throwable) {

    }

    @Override
    public void onComplete() {

    }

    public int getValue() {
        return value;
    }

    @Override
    public String toString() {
        return "Participant{" +
                "value=" + value +
                ", id=" + id +
                '}';
    }
}
