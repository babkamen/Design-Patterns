import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Flow;

public class Mediator implements Flow.Publisher<ValueSubscription> {
    public List<Flow.Subscriber<ValueSubscription>> subscribers = new ArrayList<>();

    @Override
    public void subscribe(Flow.Subscriber<? super ValueSubscription> subscriber) {
        subscribers.add((Flow.Subscriber<ValueSubscription>) subscriber);
    }

    public void broadcast(int value, Flow.Subscriber<ValueSubscription> author) {
        subscribers.forEach(s -> {
            if (s != author) {
                s.onNext(new ValueSubscription(value));
            }
        });
    }
}
