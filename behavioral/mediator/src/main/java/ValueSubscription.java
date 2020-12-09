import java.util.concurrent.Flow;

class ValueSubscription implements Flow.Subscription {
    private int value;

    public ValueSubscription(int value) {
        this.value = value;
    }

    @Override
    public void request(long n) {

    }

    @Override
    public void cancel() {

    }

    public int getValue() {
        return value;
    }
}